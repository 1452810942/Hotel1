package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.java.bean.Vip;
import cn.java.db.Get_Information;
import cn.java.service.Paging;
import cn.java.service.SendMessage;

/**
 * 向前台返回数据
 * @author 1
 *
 */
//@WebServlet("/GetVip")
public class GetVip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String page = request.getParameter("page");
		List<Vip> list = null;
		try {
			list = Get_Information.getVip();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Paging<Vip> Paging = new Paging<Vip>();
	
		SendMessage<Vip> sm = new SendMessage<Vip>();
		sm.send(Paging, response, list, page);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
