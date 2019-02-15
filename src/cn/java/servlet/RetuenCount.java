package cn.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Finance;
import cn.java.bean.Room;
import cn.java.bean.Staff;
import cn.java.bean.Vip;
import cn.java.db.Get_Information;
import net.sf.json.JSONObject;


//@WebServlet("/RetuenCount")
public class RetuenCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Room> list_r = null;
		List<Staff> list_s = null;
		List<Vip> list_v = null;
		List<Finance> list_f = null;
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			list_r = Get_Information.getRoom();
			list_s = Get_Information.getStaff();
			list_v = Get_Information.getVip();
			list_f = Get_Information.getFinace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		map.put("Room", list_r.size());
		map.put("Staff", list_s.size());
		map.put("Vip", list_v.size());
		double amount = 0.0;
		for(Finance f : list_f) {
			amount = amount + f.getFamount();
		}
		map.put("Finance", amount);
		JSONObject jb = JSONObject.fromObject(map);
		PrintWriter pw = response.getWriter();
		pw.write(jb.toString());
		pw.flush();
		pw.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
