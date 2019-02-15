package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Liveroom;
import cn.java.bean.Reservation;
import cn.java.db.Get_Information;
import cn.java.service.FaintSelect;
import cn.java.service.Paging;
import cn.java.service.SendMessage;


//@WebServlet("/SelectLiveroom")
public class SelectLiveroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String child = request.getParameter("message");
		String page = request.getParameter("page");
		System.out.println(child+"   "+page);
		List<Liveroom> list = null;
		List<Liveroom> results = null;
		boolean type = true;
		try {
			list = Get_Information.getLiveroom();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		FaintSelect fs = new FaintSelect();
		results = fs.fainSelectLiveroom(list, child);
		if(results.size() == 0) {
			type = false;
		}
		Paging<Liveroom> paging = new Paging<Liveroom>();
		SendMessage<Liveroom> sm = new SendMessage<Liveroom>();
		if(results.size() > 0) {
			Map<String,Object> map = sm.getmap(paging, results, page);
			sm.sendType(map, response, type, true);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
