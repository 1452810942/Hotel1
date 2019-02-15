package cn.java.db;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
/**
 * 得到id删除该条信息
 * @author 1
 *
 */
public class Delete_Information {
	private static QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	public  static void deleteReservation(int id) throws Exception {
	    String sql = "DELETE FROM Reservation WHERE nid = ?";
	    qr.update(sql, id);
	}
	public static void deleteVip(int vid) throws Exception {
		String sql = "DELETE FROM Vip WHERE vid = ?";
		qr.update(sql, vid);
	}
	public static void deleteStaff(int sid) throws SQLException {
		String sql = "DELETE FROM Staff WHERE sid = ?";
		qr.update(sql, sid);
		
	}
	
	
}
