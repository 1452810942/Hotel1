package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Liveroom;
import cn.java.service.LiveroomSrevice;
import cn.java.service.SendMessage;

/**
 * 
 * @author 1
 *
 */
//@WebServlet("/AddLiveroom")
public class AddLiveroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vname = request.getParameter("name");
		String rid = request.getParameter("room");
		String vnumber = request.getParameter("idCard");	
		System.out.println(vname+"   "+rid+"   "+vnumber);
		LiveroomSrevice lrs = new LiveroomSrevice();
		boolean result = true;
		try {
			 result = lrs.addLiveroom(vname, rid,vnumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		SendMessage<Liveroom> sm = new SendMessage<Liveroom>();
		Map<String,Object> map = new HashMap<String,Object>();
		sm.sendType(map, response, result, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
