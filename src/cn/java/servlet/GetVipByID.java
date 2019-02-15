package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Vip;
import cn.java.db.Get_Information;
import cn.java.service.SendMessage;

/**
 * Servlet implementation class GetVipByID
 */
//@WebServlet("/GetVipByID")
public class GetVipByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vid = request.getParameter("vid");
		
		List<Vip> list = null;
		try {
			list = Get_Information.getVipByVid(vid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		Vip vip = list.get(0);
		map.put("vname", vip.getVname());
		map.put("vgender", vip.getVgender());
		map.put("vnumber", vip.getVnumber());
		map.put("vtel", vip.getVtel());
		map.put("vpassword", vip.getVpassword());
		map.put("vid", vip.getVid());
		SendMessage<Vip> sm = new SendMessage<Vip>();
		sm.sendType(map, response, true, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
