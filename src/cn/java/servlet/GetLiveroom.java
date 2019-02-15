package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.java.bean.Liveroom;
import cn.java.db.Get_Information;
import cn.java.service.Paging;
import cn.java.service.SendMessage;


//@WebServlet("/GetLiveroom")
public class GetLiveroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
	
		List<Liveroom> list = null;
		try {
			list = Get_Information.getLiveroom();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Paging<Liveroom> paging = new Paging<Liveroom>(); //·ÖÒ³
		
		SendMessage<Liveroom> sm = new SendMessage<Liveroom>();
		sm.send(paging, response, list, page);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
