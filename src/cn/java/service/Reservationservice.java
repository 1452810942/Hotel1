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
 * ��ԤԼ���еĴ���״̬��Ϊ׼��״̬
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
		if("����".equals(room.getRstate())) {
			result =false;
		}else {
			res.setNtype("׼��");
			Liveroom lr = new Liveroom();
			lr.setLdesc("��ס");
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
		res.setNtype("�ܾ�");
		
			Update_Information.updateReservation(res);
	
	}


	public List<Object> getOrderFormByVid(String vid) throws NumberFormatException, SQLException {
		List<Reservation> allInformation = Get_Information.getReservationByVid(Integer.parseInt(vid));
		List<Object> result = new ArrayList<Object>();
		
		for(Reservation rs : allInformation) {
			Map<String,Object> map = new HashMap<String,Object>();
			if("����".equals(rs.getNtype()) ) {
				map.put("message", "ԤԼ�ɹ�");
				map.put("price", GetNowtime.getDaySub(rs.getNdate1(), rs.getNdate2())*rs.getRprice());
			}else if("�ܾ�".equals(rs.getNtype())) {
				map.put("message", "ԤԼʧ��");
				map.put("price", GetNowtime.getDaySub(rs.getNdate1(), rs.getNdate2())*rs.getRprice());
			}else if("׼��".equals(rs.getNtype())) {
				List<Liveroom> listl = Get_Information.getLiveroomBYNidAndLdesc(rs.getNid(), "�˷�");
				if(listl.size() != 0) {
					if(Get_Information.getSuggestByLid(listl.get(0).getLid()).size() == 0) {
						map.put("message", "���˷�");
						map.put("lid", listl.get(0).getLid());
						
					}
					else {
						map.put("message", "������");
					}
					map.put("price", Get_Information.getFianceByLid(listl.get(0).getLid()).get(0).getFamount());
				}else if(listl.size() == 0) {
					map.put("message", "ԤԼ�ɹ�");
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
