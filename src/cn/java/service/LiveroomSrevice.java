package cn.java.service;

import java.sql.SQLException;
import java.util.List;

import cn.java.bean.Liveroom;
import cn.java.bean.Room;
import cn.java.bean.Vip;
import cn.java.db.Get_Information;
import cn.java.db.Insert_Information;
import cn.java.db.Update_Information;

public class LiveroomSrevice {

	public boolean addLiveroom(String vname,String rid,String vnumber) throws SQLException{
		List<Vip> vipList = Get_Information.getVipByNumber(vnumber);
		
		boolean result = true;
		if(vname == null && rid == null && vnumber == null) {
			result =  false;
		}else if(vipList.size() == 0) {
			result =  false;
			}else {
				List<Room> roomList = Get_Information.getRoomByID(Integer.parseInt(rid));
				Vip vip = vipList.get(0);
				Room room = roomList.get(0);
				Liveroom lr = new Liveroom();
				lr.setVid(vip.getVid());
				lr.setVname(vip.getVname());
				lr.setVtel(vip.getVtel());
				lr.setRid(Integer.parseInt(rid));
				lr.setRtype(room.getRtype());
				lr.setRprice(room.getRprice());
				lr.setNdate1(GetNowtime.getNowDate());
				lr.setLdesc("入住");
				lr.setNdate2(null);
				lr.setNid(0);
				Insert_Information.insertLivingroom(lr);
				room.setRstate("有人");
				Update_Information.updateRoom(room);
				
			}
		return result;
		
	}
}
