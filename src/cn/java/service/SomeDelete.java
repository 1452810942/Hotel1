package cn.java.service;

import java.sql.SQLException;
import java.util.List;

import cn.java.bean.Liveroom;
import cn.java.bean.Reservation;
import cn.java.db.Delete_Information;
import cn.java.db.Get_Information;

public class SomeDelete {

	public boolean deleteReservation(String[] id) {
		boolean result = true;
		for(String s : id) {
			if(checkIsHaveReservation(s)) {
				try {
					Delete_Information.deleteReservation(Integer.parseInt(s));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				result = false;
				break;
			}
		}
		return result;
	}
	public boolean checkIsHaveReservation(String id) {
		boolean result = false;
		List<Reservation> list = null;
		try {
			list = Get_Information.getReservation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Reservation res : list) {
			if(Integer.parseInt(id) == res.getNid()) {
				result = true;
			}
		}
		return result;
	}
	
}
