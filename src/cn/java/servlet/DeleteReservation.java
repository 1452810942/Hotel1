package cn.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Reservation;
import cn.java.service.SendMessage;
import cn.java.service.SomeDelete;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//@WebServlet("/DeleteReservation")
public class DeleteReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] id = request.getParameterValues("id");
		SomeDelete sd = new SomeDelete();
		boolean result = sd.deleteReservation(id);

		Map<String,Object> map = new HashMap<String,Object>();
		SendMessage<Reservation> sm = new SendMessage<Reservation>();
		sm.sendType(map, response, result, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
