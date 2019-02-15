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

import cn.java.bean.Staff;
import cn.java.bean.Vip;
import cn.java.db.Get_Information;
import cn.java.service.SendMessage;


//@WebServlet("/GetStaffByID")
public class GetStaffByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		
		List<Staff> list = null;
		try {
			list = Get_Information.getStaffBySid(sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		Staff staff = list.get(0);
		map.put("sname", staff.getSname());
		map.put("sgender", staff.getSgender());
		map.put("saddress", staff.getSaddress());
		map.put("stel", staff.getStel());
		map.put("spassword", staff.getSpassword());
		map.put("sid", staff.getSid());
		map.put("sdate", staff.getSdate());
		SendMessage<Staff> sm = new SendMessage<Staff>();
		sm.sendType(map, response, true, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
