package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.java.bean.Staff;
import cn.java.db.Get_Information;
import cn.java.service.Paging;
import cn.java.service.SendMessage;


//@WebServlet("/GetStaff")
public class GetStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		List<Staff> list = null;
		try {
			list = Get_Information.getStaff();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Paging<Staff> Paging = new Paging<Staff>();
		
		SendMessage<Staff> sm = new SendMessage<Staff>();
		sm.send(Paging, response, list, page);
	}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
