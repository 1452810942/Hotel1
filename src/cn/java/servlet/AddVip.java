package cn.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Vip;
import cn.java.service.SendMessage;
import cn.java.service.VipService;
import net.sf.json.JSONObject;


//@WebServlet("/AddVip")
public class AddVip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vname = request.getParameter("name");
		String vgender = request.getParameter("sex");
		String vnumber = request.getParameter("idCard");
		String vtel = request.getParameter("tel");
		String vpassword = request.getParameter("password");
		System.out.println(vname);
		System.out.println(vgender);
		System.out.println(vnumber);
		System.out.println(vtel);
		System.out.println(vpassword);
		boolean type = true;
		VipService vs =new VipService();
		try {
			type = vs.addVip(vname, vgender, vnumber, vtel, vpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("type="+type);
		Map<String,Object> map = new HashMap<String, Object>();
		SendMessage<Vip> sm = new SendMessage<Vip>();
		sm.sendType(map, response, type, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
