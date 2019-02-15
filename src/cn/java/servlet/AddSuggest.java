package cn.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Suggest;
import cn.java.db.Insert_Information;
import cn.java.service.GetNowtime;
import cn.java.service.SendMessage;


//@WebServlet("/AddSuggest")
public class AddSuggest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lid = request.getParameter("lid");
		String rid = request.getParameter("rid");
		String vid = request.getParameter("vid");
		String sudesc = request.getParameter("sudesc");
		System.out.println(lid);
		System.out.println(rid);
		System.out.println(vid);
		System.out.println(sudesc);
		boolean type = true;
		if(lid == null || rid == null || vid == null ||sudesc == null || "".equals(sudesc) || "".equals(vid) || "".equals(rid) || "".equals(lid)) {
			type = false;
		}else {
			Suggest suggest = new Suggest(Integer.parseInt(lid), Integer.parseInt(rid), Integer.parseInt(vid), sudesc, GetNowtime.getNowDate());
			try {
				Insert_Information.insertSuggest(suggest);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SendMessage<Suggest> sm = new SendMessage<Suggest>();
		sm.sendType(new HashMap<String,Object>(), response, type, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
