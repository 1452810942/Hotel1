package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Room;
import cn.java.service.RoomService;
import cn.java.service.SendMessage;


//@WebServlet("/RstreatsRoom")
public class RstreatsRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("roomNow");
	
		RoomService rs = new RoomService();
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map = rs.rstreatsroom(rid);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SendMessage<Room> sm = new SendMessage<Room>();
		boolean type = (boolean) map.get("type");
		map.remove("type");
		sm.sendType(map, response, type, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
