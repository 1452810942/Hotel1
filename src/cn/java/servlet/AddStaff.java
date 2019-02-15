package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Staff;
import cn.java.bean.Vip;
import cn.java.service.SendMessage;
import cn.java.service.VipService;


//@WebServlet("/AddStaff")
public class AddStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sname = request.getParameter("sname");
		String sgender = request.getParameter("sgender");
		String stel = request.getParameter("stel");
		String saddress = request.getParameter("address");
		String spassword = request.getParameter("spassword");
		
		System.out.println(sname);
		System.out.println(sgender);
		System.out.println(stel);
		System.out.println(saddress);
		System.out.println(spassword);
		boolean type = true;
		StaffService ss =new StaffService();
		
			try {
				type = ss.addStaff(sname,sgender,stel,saddress,spassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Map<String,Object> map = new HashMap<String, Object>();
		SendMessage<Staff> sm = new SendMessage<Staff>();
		sm.sendType(map, response, type, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
