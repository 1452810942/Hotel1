package cn.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.java.bean.Reservation;
import cn.java.db.Get_Information;
import cn.java.service.FaintSelect;
import cn.java.service.Paging;
import cn.java.service.SendMessage;
import net.sf.json.JSONObject;


//@WebServlet("/SelectReservation")
public class SelectReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String child = request.getParameter("message");
		String page = request.getParameter("page");
		
		boolean type = true;
		List<Reservation> list = null;
		List<Reservation> results = null;
		
			try {
				list = Get_Information.getReservation();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		FaintSelect faintSelect = new FaintSelect();
		results = faintSelect.faintSelectReservation(list, child);
		if(results.size() == 0) {
			type = false;
		}
		
		Paging<Reservation> paging = new Paging<Reservation>();
		SendMessage<Reservation> sm = new SendMessage<Reservation>();
		if(results.size() > 0) {
			Map<String,Object> map = sm.getmap(paging, results, page);
			sm.sendType(map, response, type, true);
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
