package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.java.bean.Room;
import cn.java.db.Get_Information;
import cn.java.service.SendMessage;


//@WebServlet("/GetRoomByID")
public class GetRoomByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		List<Room> list = null;
		try {
			list = Get_Information.getRoomByID(Integer.parseInt(rid));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		Room room = list.get(0);
		map.put("rdesc", room.getRdesc());
		map.put("rprice", room.getRprice());
		map.put("rid", room.getRid());
		map.put("rtype", room.getRtype());
		
		SendMessage<Room> sm = new SendMessage<Room>();
		sm.sendType(map, response, true, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
