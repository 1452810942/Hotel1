package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Vip;
import cn.java.service.SendMessage;
import cn.java.service.VipService;


//@WebServlet("/UpdatePasswordOfVip")
public class UpdatePasswordOfVip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String vid = request.getParameter("vid");
		System.out.println(vid);
		System.out.println(oldPassword);
		System.out.println(newPassword);
		boolean type = true;
		VipService vs = new VipService();
		try {
			type = vs.updatePassword(vid,oldPassword,newPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SendMessage<Vip> sm = new SendMessage<Vip>();
		sm.sendType(new HashMap<String,Object>(), response, type, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
