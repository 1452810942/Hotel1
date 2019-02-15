package cn.java.db;

import java.sql.SQLException;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.java.bean.Finance;
import cn.java.bean.Liveroom;
import cn.java.bean.Reservation;
import cn.java.bean.Room;
import cn.java.bean.Staff;
import cn.java.bean.Suggest;
import cn.java.bean.Vip;

public class Get_Information {
	//获得链接
	private static QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	/**
	 * 返回封装staff对象的list集合
	 * @return list
	 * @throws SQLException
	 */
	public  static List<Staff> getStaff() throws SQLException{
		String sql = "SELECT * FROM Staff";
		List<Staff> list = qr.query(sql, new BeanListHandler<Staff>(Staff.class));
		return list;
	}
	/**
	 * 返回封装Vip对象的list集合
	 * @return
	 * @throws SQLException
	 */
	public static List<Vip> getVip() throws SQLException{
		String sql = "SELECT * FROM Vip";
		List<Vip> list = qr.query(sql, new BeanListHandler<Vip>(Vip.class));
		return list;
			
	}
	/**
	 * 返回封装room的list集合
	 * 
	 * @return
	 * @throws SQLException
	 */
	public  static List<Room> getRoom() throws SQLException{
		String sql = "SELECT * FROM Room";
		List<Room> list = qr.query(sql, new BeanListHandler<Room>(Room.class));
		return list;
	}
	public static  List<Reservation> getReservation() throws SQLException {
		String sql = "SELECT * FROM Reservation";
		List<Reservation> list = qr.query(sql, new BeanListHandler<Reservation>(Reservation.class));
		return list;
		
	}
	
	public static  List<Liveroom> getLiveroom() throws SQLException {
		String sql = "SELECT * FROM Liveroom";
		List<Liveroom> list = qr.query(sql, new BeanListHandler<Liveroom>(Liveroom.class));
		return list;
		
	}
	
	public static List<Reservation> getReservationByID(int nid) throws SQLException {
		String sql = "SELECT * FROM Reservation WHERE nid=?";
		List<Reservation> list = qr.query(sql, new BeanListHandler<Reservation>(Reservation.class),nid);
		return list;
	}
	public static List<Room> getRoomByID(int rid)throws SQLException{
		String sql = "SELECT * FROM Room WHERE rid=?";
		List<Room> list = qr.query(sql, new BeanListHandler<Room>(Room.class),rid);
		return list;
		
	}
	public static List<Vip> getVipByName(String vname)throws SQLException{
		
		String sql = "SELECT * FROM Vip WHERE vname=?";
		List<Vip> list = qr.query(sql, new BeanListHandler<Vip>(Vip.class),vname);
		return list;
		
	}
	public static List<Vip> getVipByNumber(String vnumber)throws SQLException{
		
		String sql = "SELECT * FROM Vip WHERE vnumber=?";
		List<Vip> list = qr.query(sql, new BeanListHandler<Vip>(Vip.class),vnumber);
		return list;
		
	}
	
	public static List<Vip> getVipByVid(String vid)throws SQLException{
		
		String sql = "SELECT * FROM Vip WHERE vid=?";
		List<Vip> list = qr.query(sql, new BeanListHandler<Vip>(Vip.class),vid);
		return list;
		
	}
	
	public static List<Liveroom> getLiveroomByID(int lid)throws SQLException{
		
		String sql = "SELECT * FROM Liveroom WHERE lid=?";
		List<Liveroom> list = qr.query(sql, new BeanListHandler<Liveroom>(Liveroom.class),lid);
		return list;
		
	}
	public static List<Liveroom> getLiveroomBYRidAndLdesc(int rid,String ldesc)throws SQLException{
		String sql = "SELECT * FROM Liveroom WHERE rid=? AND ldesc=?";
		Object[] param = {rid,ldesc};
		List<Liveroom> list = qr.query(sql, new BeanListHandler<Liveroom>(Liveroom.class),param);
		return list;
		
	}
	
	public static List<Liveroom> getLiveroomBYVidAndLdesc(int vid,String ldesc)throws SQLException{
		String sql = "SELECT * FROM Liveroom WHERE vid=? AND ldesc=?";
		Object[] param = {vid,ldesc};
		List<Liveroom> list = qr.query(sql, new BeanListHandler<Liveroom>(Liveroom.class),param);
		return list;
		
	}
	public static List<Staff> getStaffBySid(String sid) throws SQLException {
		String sql = "SELECT * FROM Staff WHERE sid=?";
		Object[] param = {sid};
		List<Staff> list = qr.query(sql, new BeanListHandler<Staff>(Staff.class),param);
		return list;
	}
	public static List<Finance> getFinace() throws SQLException {
		String sql = "SELECT * FROM Finance";
		List<Finance> list = qr.query(sql, new BeanListHandler<Finance>(Finance.class));
		return list;
	}
	public static List<Reservation> getReservationByRidAndNtype(int rid, String ntype) throws SQLException {
		
		String sql = "SELECT * FROM Reservation WHERE rid=? AND ntype=?";
		Object[] param = {rid,ntype};
		List<Reservation> list = qr.query(sql, new BeanListHandler<Reservation>(Reservation.class),param);
		return list;
	
	}
	public static List<Vip> getVipByTel(String tel) throws SQLException {
		String sql = "SELECT * FROM Vip WHERE vtel=?";
		Object[] param = {tel};
		List<Vip> list = qr.query(sql, new BeanListHandler<Vip>(Vip.class),param);
		return list;
		
	}
	public static List<Liveroom> getLiveroomByVid(int vid) throws SQLException {
		String sql = "SELECT * FROM Liveroom WHERE vid=?";
		Object[] param = {vid};
		List<Liveroom> list = qr.query(sql, new BeanListHandler<Liveroom>(Liveroom.class),param);
		return list;
		
	}
	public static List<Reservation> getReservationByVid(int vid) throws SQLException {
		String sql = "SELECT * FROM Reservation WHERE vid=?";
		Object[] param = {vid};
		List<Reservation> list = qr.query(sql, new BeanListHandler<Reservation>(Reservation.class),param);
		return list;
		
	}
	public static List<Liveroom>  getLiveroomBYNidAndLdesc(int nid, String ldesc) throws SQLException {
		String sql = "SELECT * FROM Liveroom WHERE nid=? AND ldesc=?";
		Object[] param = {nid,ldesc};
		List<Liveroom> list = qr.query(sql, new BeanListHandler<Liveroom>(Liveroom.class),param);
		return list;
		
	}
	public static List<Suggest> getSuggest() throws SQLException {
		String sql = "SELECT * FROM Suggest";
		List<Suggest> list = qr.query(sql, new BeanListHandler<Suggest>(Suggest.class));
		return list;
	}
	public static List<Suggest> getSuggestByLid(int lid) throws SQLException {
		String sql = "SELECT * FROM Suggest WHERE lid=?";
		Object[] param = {lid};
		List<Suggest> list = qr.query(sql, new BeanListHandler<Suggest>(Suggest.class),param);
		return list;
	}
	public static List<Finance> getFianceByLid(int lid) throws SQLException {
		String sql = "SELECT * FROM Finance WHERE lid=?";
		Object[] param = {lid};
		List<Finance> list = qr.query(sql, new BeanListHandler<Finance>(Finance.class),param);
		return list;
	}
		

}
