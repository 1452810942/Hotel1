package cn.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.service.VipService;
import net.sf.json.JSONObject;


//@WebServlet("/UpdateVip")
public class UpdateVip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vid = request.getParameter("vid");
		String vname = request.getParameter("vname");
		String vtel = request.getParameter("vtel");
		String vpassword = request.getParameter("vpassword");
		VipService vs = new VipService();
		try {
			vs.updateVip(vid,vname,vtel,vpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("type", true);
		
		 JSONObject ja = JSONObject.fromObject(map);
		 PrintWriter pw = response.getWriter();
		 pw.write(ja.toString());
		 pw.flush();
		 pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
