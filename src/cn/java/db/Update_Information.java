package cn.java.db;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.java.bean.Liveroom;
import cn.java.bean.Reservation;
import cn.java.bean.Room;
import cn.java.bean.Staff;
import cn.java.bean.Vip;

public class Update_Information {

	private static QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	public static void updateReservation(Reservation res) throws SQLException {
		String sql = "UPDATE Reservation SET vid=?,vname=?,vtel=?,vnumber=?,rid=?,rtype=?,rprice=?,ntime=?,ntype=?,ndate1=?,ndate2=? WHERE nid=?";
		Object[] pram = {res.getVid(),res.getVname(),res.getVtel(),res.getVnumber(),res.getRid(),res.getRtype(),res.getRprice(),res.getNtime(),res.getNtype(),res.getNdate1(),res.getNdate2(),res.getNid()};
		qr.update(sql, pram);
	}
	public static void updateRoom(Room room)throws SQLException{
		String sql = "UPDATE Room SET rtype=?,rprice=?,rdesc=?,rstate=? WHERE rid=?";
		Object[] pram = {room.getRtype(),room.getRprice(),room.getRdesc(),room.getRstate(),room.getRid()};
		qr.update(sql, pram);
	}
	public static void updateLiveroom(Liveroom lr) throws SQLException {
		String sql = "UPDATE Liveroom SET nid=?,rid=?,rtype=?,rprice=?,vid=?,vname=?,vtel=?,ndate1=?,ndate2=?,ldesc=? WHERE lid=?";
		Object[] pram = {lr.getNid(),lr.getRid(),lr.getRtype(),lr.getRprice(),lr.getVid(),lr.getVname(),lr.getVtel(),lr.getNdate1(),lr.getNdate2(),lr.getLdesc(),lr.getLid()};
		qr.update(sql, pram);
		
	}
	public static void updateVip(Vip vip) throws SQLException {
		String sql ="UPDATE Vip SET vname=?,vtel=?,vpassword=? WHERE vid=?";
		Object[] pram = {vip.getVname(),vip.getVtel(),vip.getVpassword(),vip.getVid()};
		qr.update(sql, pram);
	}
	public static void updateStaff(Staff staff) throws SQLException {
		String sql ="UPDATE Staff SET sname=?,stel=?,spassword=?,saddress=? WHERE sid=?";
		Object[] pram = {staff.getSname(),staff.getStel(),staff.getSpassword(),staff.getSaddress(),staff.getSid()};
		qr.update(sql, pram);
		
	}
}
