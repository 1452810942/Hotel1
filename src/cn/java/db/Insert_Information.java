package cn.java.db;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.java.bean.Finance;
import cn.java.bean.Liveroom;
import cn.java.bean.Reservation;
import cn.java.bean.Staff;
import cn.java.bean.Suggest;
import cn.java.bean.Vip;

public class Insert_Information {
	
	private static QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	
	public static void insertLivingroom(Liveroom lr) throws SQLException{
		String sql ="INSERT INTO Liveroom (nid,rid,rtype,rprice,vid,vname,vtel,ndate1,ndate2,ldesc)VALUES(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {lr.getNid(),lr.getRid(),lr.getRtype(),lr.getRprice(),lr.getVid(),lr.getVname(),lr.getVtel(),lr.getNdate1(),lr.getNdate2(),lr.getLdesc()};
		qr.update(sql, params);
	}
	
	public static void insertVip(Vip vip) throws SQLException{
		String sql ="INSERT INTO Vip (vid,vname,vgender,vnumber,vtel,vpassword)VALUES(?,?,?,?,?,?)";
		Object[] params = {vip.getVid(),vip.getVname(),vip.getVgender(),vip.getVnumber(),vip.getVtel(),vip.getVpassword()};
		qr.update(sql, params);
	}

	public static void insertFinance(Finance finance) throws SQLException {
		String sql ="INSERT INTO Finance (lid,fsource,famount)VALUES(?,?,?)";
		Object[] params = {finance.getLid(),finance.getFsource(),finance.getFamount()};
		qr.update(sql, params);
	}

	public static void insertStaff(Staff staff) throws SQLException {
		String sql ="INSERT INTO Staff (sid,sname,sgender,stel,saddress,sdate,spassword)VALUES(?,?,?,?,?,?,?)";
		Object[] params = {staff.getSid(),staff.getSname(),staff.getSgender(),staff.getStel(),staff.getSaddress(),staff.getSdate(),staff.getSpassword()};
		qr.update(sql, params);
		
	}

	public static void insertReservation(Reservation rv) throws SQLException {
		String sql ="INSERT INTO Reservation (vid,vname,vtel,vnumber,rid,rtype,rprice,ntime,ntype,ndate1,ndate2)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {rv.getVid(),rv.getVname(),rv.getVtel(),rv.getVnumber(),rv.getRid(),rv.getRtype(),rv.getRprice(),rv.getNtime(),rv.getNtype(),rv.getNdate1(),rv.getNdate2()};
		qr.update(sql, params);
		
	}

	public static void insertSuggest(Suggest s) throws SQLException {
		String sql ="INSERT INTO Suggest (lid,vid,rid,sudesc,sudate)VALUES(?,?,?,?,?)";
		Object[] params = {s.getLid(),s.getVid(),s.getRid(),s.getSudesc(),s.getSudate()};
		qr.update(sql, params);
		
	}
	
}
