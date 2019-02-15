package cn.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Reservation;
import cn.java.service.Reservationservice;
import cn.java.service.SendMessage;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//@WebServlet("/AcceptReservation")
public class AcceptReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("id"+id);
		Reservationservice resToAcc = new Reservationservice();
		boolean type = true;
		try {
			type = resToAcc.resToAccept(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		SendMessage<Reservation> sm = new SendMessage<Reservation>();
		sm.sendType(map, response, type, false);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
