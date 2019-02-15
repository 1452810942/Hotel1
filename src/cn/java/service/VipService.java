package cn.java.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.java.bean.Reservation;
import cn.java.bean.Room;
import cn.java.bean.Vip;
import cn.java.db.Delete_Information;
import cn.java.db.Get_Information;
import cn.java.db.Insert_Information;
import cn.java.db.Update_Information;

public class VipService {

	public boolean addVip(String vname,String vgender,String vnumber,String vtel,String vpassword) throws SQLException {
		boolean result = true;
		boolean select = true;
		FaintSelect fs = new FaintSelect();
		if(vname != null && vgender != null && vnumber != null && vtel != null && vpassword != null && !"".equals(vpassword)&& !"".equals(vname)&& !"".equals(vgender)&& !"".equals(vnumber)&& !"".equals(vtel)) {
				List<Vip> list = Get_Information.getVip();
				for(Vip vip : list) {
					if(vnumber.equals(vip.getVnumber())) {
						
						select = false;
						result = false;
						break;
					}
				}
				if(select) {
					System.out.println("1");
					Vip vip = new Vip();
					vip.setVgender(vgender);
					vip.setVname(vname);
					vip.setVnumber(vnumber);
					vip.setVpassword(vpassword);
					vip.setVtel(vtel);
					vip.setVid(getBigestVid()+1);
					Insert_Information.insertVip(vip);
				}
				
		}else {
			result = false;
			System.out.println("false");
		}
		return result;
		
	}
	public int getBigestVid() throws SQLException {
		List<Vip> list = Get_Information.getVip();
		int count = 0;
		for(Vip vip : list) {
			if(vip.getVid() > count) {
				count = vip.getVid();
			}
		}
		
		return count;
		
	}
	public boolean deleteVip(String vid) throws NumberFormatException, Exception {
		List<Vip> lt = Get_Information.getVipByVid(vid);
		boolean result = true;
		if(lt.size() == 0) {
			result = false;
		}else {
			Delete_Information.deleteVip(Integer.parseInt(vid));
		}
		return result;
	}
	
	public void updateVip(String vid, String vname, String vtel, String vpassword) throws SQLException {
		List<Vip> list = Get_Information.getVipByVid(vid);
		Vip vip = list.get(0);
		vip.setVname(vname);
		vip.setVtel(vtel);
		vip.setVpassword(vpassword);
		Update_Information.updateVip(vip);
	}
	public Map<String,Object> orderRoom(String vid, String rid, String ndate1, String ndate2) throws SQLException {
		List<Vip> listv = Get_Information.getVipByVid(vid);
		boolean type =true;
		Map<String,Object> map = new HashMap<String,Object>();
		List<Room> listr = Get_Information.getRoomByID(Integer.parseInt(rid));
		if(listv.size() == 0 || listr.size() == 0) {
			type = false;
		}else {
			Room room = listr.get(0);
			Vip vip = listv.get(0);
			
			Reservation rv =new Reservation(Integer.parseInt(vid), vip.getVname(), vip.getVtel(), vip.getVnumber(), Integer.parseInt(rid), room.getRtype(),room.getRprice(), GetNowtime.getNowDate(), "´ýÉó", ndate1, ndate2);
			Insert_Information.insertReservation(rv);
				
			map.put("vname", rv.getVname());
			map.put("rid", rv.getRid());
			map.put("rtype", rv.getRtype());
			map.put("rprice", rv.getRprice());
			map.put("ntime", rv.getNtime());
			map.put("ndate1", rv.getNdate1());
			map.put("ndate2", rv.getNdate2());
		}
		map.put("type", type);
		return map;
	}
	public boolean updatePassword(String vid,String oldPassword, String newPassword) throws SQLException {
		boolean type = true;
		if(oldPassword == null || "".equals(oldPassword) || newPassword == null || "".equals(newPassword)) {
			type =false;
		}else {
			Vip vip = Get_Information.getVipByVid(vid).get(0);
			if(oldPassword.equals(vip.getVpassword())) {
				vip.setVpassword(newPassword);
				Update_Information.updateVip(vip);
			}else {
				type = false;
			}
		}
		return type;
	}
}
