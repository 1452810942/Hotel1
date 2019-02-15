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

import cn.java.bean.Reservation;
import cn.java.service.SendMessage;
import cn.java.service.VipService;


//@WebServlet("/VipOrder")
public class VipOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vid = request.getParameter("vid");
		String rid = request.getParameter("rid");
		String ndate1 = request.getParameter("ndate1");
		String ndate2 = request.getParameter("ndate2");
		String[] array1 = ndate1.split("-");
		String[] array2 = ndate2.split("-");
		ndate1 = array1[1] + "-" + array1[2];
		ndate2 = array2[1] + "-" + array2[2];
		Map<String,Object> map = new HashMap<String,Object>();
		VipService vs = new VipService();
		try {
			map = vs.orderRoom(vid,rid,ndate1,ndate2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean type = (boolean) map.get("type");
		map.remove("type");
		SendMessage<Reservation> sm = new SendMessage<Reservation>();
		sm.sendType(map, response, type, false);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
