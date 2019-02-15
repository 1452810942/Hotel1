package cn.java.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.java.bean.Finance;
import cn.java.bean.Liveroom;
import cn.java.bean.Reservation;
import cn.java.bean.Room;
import cn.java.db.Get_Information;
import cn.java.db.Insert_Information;
import cn.java.db.Update_Information;

public class RoomService {

	public void changeRoomType(int rid) throws SQLException {
		
		List list = null;
		list = Get_Information.getRoomByID(rid);
	
		Room room = (Room) list.get(0);
		room.setRstate("有人");
		Update_Information.updateRoom(room);
	}
	
	
	public boolean changeRoom (String ridNow,String ridFutuer) throws NumberFormatException, SQLException {
		boolean result = true;
		List<Liveroom> list = Get_Information.getLiveroomBYRidAndLdesc(Integer.parseInt(ridNow), "入住");	
		
		if(list.size() == 0) {
			result = false;
		}else {
			Room roomNow = Get_Information.getRoomByID(Integer.parseInt(ridNow)).get(0);
			Room roomFuture = Get_Information.getRoomByID(Integer.parseInt(ridFutuer)).get(0);
			roomNow.setRstate("无人");
			roomFuture.setRstate("有人");
			Update_Information.updateRoom(roomNow);
			Update_Information.updateRoom(roomFuture);
			Liveroom lrNow = list.get(0);
			Liveroom lrFuture = new Liveroom();
			if(lrNow.getNdate2() == null || "".equals(lrNow.getNdate2())) {
				
				lrFuture.setNdate2(null);
			}else {
				lrFuture.setNdate2(lrNow.getNdate2());
				
			}
			lrNow.setNdate2(GetNowtime.getNowDate());
			lrNow.setLdesc("换房");
			Update_Information.updateLiveroom(lrNow);
			lrFuture.setLdesc("入住");
			lrFuture.setNdate1(GetNowtime.getNowDate());
			lrFuture.setVtel(lrNow.getVtel());
			lrFuture.setVname(lrNow.getVname());
			lrFuture.setVid(lrNow.getVid());
			lrFuture.setRid(roomFuture.getRid());
			lrFuture.setRprice(roomFuture.getRprice());
			lrFuture.setRtype(roomFuture.getRtype());
			lrFuture.setNid(lrNow.getNid());
			Insert_Information.insertLivingroom(lrFuture);
		}
		return result;
		
	}
	
	public Map<String,Object> rstreatsroom(String rid) throws NumberFormatException, SQLException {
		boolean result =true;
		Map<String,Object> map = new HashMap<String, Object>();
		double price = 0;
		List<Liveroom> lrList = Get_Information.getLiveroomBYRidAndLdesc(Integer.parseInt(rid), "入住");
		if(lrList.size() == 0) {
			result = false;
		}else {
			Liveroom lr = lrList.get(0);
			List<Liveroom> changeRoom = Get_Information.getLiveroomBYVidAndLdesc(lr.getVid(), "换房");
			if(changeRoom.size() == 0) {
				
				price = GetNowtime.getDaySub(lr.getNdate1(), GetNowtime.getNowDate()) * lr.getRprice();
				lr.setLdesc("退房");
				lr.setNdate2(GetNowtime.getNowDate());
				Update_Information.updateLiveroom(lr);
				Room room =Get_Information.getRoomByID(Integer.parseInt(rid)).get(0);
				room.setRstate("无人");
				Update_Information.updateRoom(room);
				Finance finance = FinanceService.returnFinance(lr.getLid(), price, "退房");
				Insert_Information.insertFinance(finance);
			}else {
				/**
				 * 带有换房的退房
				 */
				
				price = GetNowtime.getDaySub(lr.getNdate1(), GetNowtime.getNowDate()) * lr.getRprice();
				lr.setLdesc("退房");
				Update_Information.updateLiveroom(lr);
				
				Liveroom cr = changeRoom.get(0);
				price = price + GetNowtime.getDaySub(cr.getNdate1(), cr.getNdate2()) * cr.getRprice();
				cr.setLdesc("退房");
				cr.setNdate2(GetNowtime.getNowDate());
				Update_Information.updateLiveroom(cr);
				
				Room room =Get_Information.getRoomByID(Integer.parseInt(rid)).get(0);
				room.setRstate("无人");
				Update_Information.updateRoom(room);
				Finance finance = FinanceService.returnFinance(lr.getLid(), price, "退房");
				Insert_Information.insertFinance(finance);
			}
			
		}
		map.put("type", result);
		map.put("price", price);
		return map;
	}
	public Map<String,Object> roomOnClick(String rid) throws NumberFormatException, SQLException {
		List<Room> list = Get_Information.getRoomByID(Integer.parseInt(rid));
		Room room = list.get(0);
		Map<String,Object> result = new HashMap<String,Object>();
		if("无人".equals(room.getRstate())) {
			
			result.put("rid", rid);
			result.put("rtype", room.getRtype());
			result.put("vname", null);
			result.put("vid", null);
			result.put("vtel", null);
		}else if("有人".equals(room.getRstate())) {
			List<Liveroom> lists = Get_Information.getLiveroomBYRidAndLdesc(Integer.parseInt(rid), "入住");
			Liveroom liveroom = lists.get(0);
			result.put("rtype", room.getRtype());
			result.put("rid", rid);
			result.put("vname", liveroom.getVname());
			result.put("vid", liveroom.getVid());
			result.put("vtel", liveroom.getVtel());
		}
		List<Object> ls = new ArrayList<Object>();
		List<Reservation> listr = Get_Information.getReservationByRidAndNtype(Integer.parseInt(rid),"待审");
		if(listr.size() == 0) {
			ls.add(null);
		}else {

			for(Reservation rv : listr) {
				Map<String,String> mm = new HashMap<String,String>();
				
				ls.add(rv.getNdate1()+"——"+rv.getNdate2());
			}
		}
		result.put("reservationTime", ls);
		return result;
	}


	public void updateRoom(String rid, String rtype, String rprice, String rdesc) throws NumberFormatException, SQLException {
		List<Room> list = Get_Information.getRoomByID(Integer.parseInt(rid));
		Room room = list.get(0);
		room.setRtype(rtype);
		room.setRdesc(rdesc);
		room.setRprice(Double.parseDouble(rprice));
		Update_Information.updateRoom(room);
	}


	public List<Room> getRoomTypeCount(String type) throws SQLException {
		List<Room> result = new ArrayList<Room>();
		List<Room> listr = Get_Information.getRoom();
		for(Room room : listr) {
			if(room.getRtype().equals(type)) {
				result.add(room);
			}
		}
		
		return result;
		
	}
}
