package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Room;
import cn.java.service.RoomService;
import cn.java.service.SendMessage;

//@WebServlet("/ChangeRoom")
public class ChangeRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ridNow = request.getParameter("roomNow");
		String ridFuture = request.getParameter("roomFuture");
		boolean type = true;
		RoomService rs = new RoomService();
		try {
			type = rs.changeRoom(ridNow, ridFuture);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SendMessage<Room> sm = new SendMessage<Room>();
		sm.sendType(new HashMap<String, Object>(), response, type, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
