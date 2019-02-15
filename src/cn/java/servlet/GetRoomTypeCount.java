package cn.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Room;
import cn.java.service.RoomService;
import net.sf.json.JSONArray;


//@WebServlet("/GetRoomTypeCount")
public class GetRoomTypeCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		
		RoomService rs = new RoomService();
		List<Room> result = null;
		try {
			result = rs.getRoomTypeCount(type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jb = JSONArray.fromObject(result);
		PrintWriter pw = response.getWriter();
		pw.write(jb.toString());
		pw.flush();
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
