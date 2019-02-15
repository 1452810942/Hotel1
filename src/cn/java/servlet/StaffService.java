package cn.java.servlet;

import java.sql.SQLException;
import java.util.List;

import cn.java.bean.Staff;
import cn.java.bean.Vip;
import cn.java.db.Delete_Information;
import cn.java.db.Get_Information;
import cn.java.db.Insert_Information;
import cn.java.db.Update_Information;
import cn.java.service.FaintSelect;
import cn.java.service.GetNowtime;

public class StaffService {

	public boolean addStaff(String sname, String sgender, String stel, String saddress, String spassword) throws SQLException {
		boolean result = true;
		boolean select = true;
		FaintSelect fs = new FaintSelect();
		if( sname != null && sgender != null && stel != null && saddress != null && spassword != null &&  !"".equals(sname)&& !"".equals(sgender)&& !"".equals(saddress) && !"".equals(stel) && !"".equals(spassword)) {
				List<Staff> list = Get_Information.getStaff();
				for(Staff staff : list) {
					if(stel.equals(staff.getStel())) {
						
						select = false;
						result = false;
						break;
					}
				}
				if(select) {
					
					Staff staff = new Staff();
					staff.setSgender(sgender);
					staff.setSname(sname);
					staff.setSaddress(saddress);
					staff.setSpassword(spassword);
					staff.setStel(stel);
					staff.setSdate(GetNowtime.getNowDate());
					staff.setSid(getBigestSid()+1);
					Insert_Information.insertStaff(staff);
				}
				
		}else {
			result = false;
			System.out.println("false");
		}
		return result;
		
		
	}
	public int getBigestSid() throws SQLException {
		List<Staff> list = Get_Information.getStaff();
		int count = 0;
		for(Staff staff : list) {
			if(staff.getSid() > count) {
				count = staff.getSid();
			}
		}
		
		return count;
		
	}
	public boolean deleteStaff(String sid) throws SQLException {
		List<Staff> lt = Get_Information.getStaffBySid(sid);
		boolean result = true;
		if(lt.size() == 0) {
			result = false;
		}else {
			Delete_Information.deleteStaff(Integer.parseInt(sid));
		}
		return result;
		
	}
	public void updateStaff(String sid, String sname, String stel, String spassword, String saddress) throws SQLException {
		List<Staff> list = Get_Information.getStaffBySid(sid);
		Staff staff = list.get(0);
		staff.setSname(sname);
		staff.setStel(stel);
		staff.setSpassword(spassword);
		staff.setSaddress(saddress);
		Update_Information.updateStaff(staff);
		
	}
	
	
}
