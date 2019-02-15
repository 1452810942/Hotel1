package cn.java.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.java.bean.Liveroom;
import cn.java.bean.Reservation;
import cn.java.bean.Room;
import cn.java.bean.Suggest;
import cn.java.db.Get_Information;
import cn.java.db.Insert_Information;
import cn.java.db.Update_Information;

/**
 * 将预约表中的待审状态改为准许状态
 * @author 1
 *
 */
public class Reservationservice {
	
	public boolean resToAccept(String id) throws SQLException {
		List<Reservation> list = null;
		boolean result = true;
			list = Get_Information.getReservationByID(Integer.parseInt(id));
		
		Reservation res = list.get(0);
		List<Room> roomList = Get_Information.getRoomByID(res.getRid());
		Room room = roomList.get(0);
		if("有人".equals(room.getRstate())) {
			result =false;
		}else {
			res.setNtype("准许");
			Liveroom lr = new Liveroom();
			lr.setLdesc("入住");
			lr.setNdate1(res.getNdate1());
			lr.setNdate2(res.getNdate2());
			lr.setNid(Integer.parseInt(id));
			lr.setRid(res.getRid());
			lr.setRprice(res.getRprice());
			lr.setRtype(res.getRtype());
			lr.setVid(res.getVid());
			lr.setVname(res.getVname());
			lr.setVtel(res.getVtel());
			try {
				Insert_Information.insertLivingroom(lr);
				Update_Information.updateReservation(res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int rid = res.getRid();
			RoomService rs = new RoomService();
			rs.changeRoomType(rid);
		}
		return result;
	}
	
	
	public void resToRefuse(String id) throws SQLException{
		List<Reservation> list = null;
		
			list = Get_Information.getReservationByID(Integer.parseInt(id));
		
		Reservation res = list.get(0);
		res.setNtype("拒绝");
		
			Update_Information.updateReservation(res);
	
	}


	public List<Object> getOrderFormByVid(String vid) throws NumberFormatException, SQLException {
		List<Reservation> allInformation = Get_Information.getReservationByVid(Integer.parseInt(vid));
		List<Object> result = new ArrayList<Object>();
		
		for(Reservation rs : allInformation) {
			Map<String,Object> map = new HashMap<String,Object>();
			if("待审".equals(rs.getNtype()) ) {
				map.put("message", "预约成功");
				map.put("price", GetNowtime.getDaySub(rs.getNdate1(), rs.getNdate2())*rs.getRprice());
			}else if("拒绝".equals(rs.getNtype())) {
				map.put("message", "预约失败");
				map.put("price", GetNowtime.getDaySub(rs.getNdate1(), rs.getNdate2())*rs.getRprice());
			}else if("准许".equals(rs.getNtype())) {
				List<Liveroom> listl = Get_Information.getLiveroomBYNidAndLdesc(rs.getNid(), "退房");
				if(listl.size() != 0) {
					if(Get_Information.getSuggestByLid(listl.get(0).getLid()).size() == 0) {
						map.put("message", "已退房");
						map.put("lid", listl.get(0).getLid());
						
					}
					else {
						map.put("message", "已评价");
					}
					map.put("price", Get_Information.getFianceByLid(listl.get(0).getLid()).get(0).getFamount());
				}else if(listl.size() == 0) {
					map.put("message", "预约成功");
					map.put("price", GetNowtime.getDaySub(rs.getNdate1(), rs.getNdate2())*rs.getRprice());
				}
			}
			
			map.put("infoemation", rs);
			map.put("rid", rs.getRid());
			result.add(map);
		}
		return result;
		
		
	}
	
}
