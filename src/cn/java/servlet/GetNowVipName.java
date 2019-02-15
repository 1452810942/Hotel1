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

import cn.java.bean.Vip;
import cn.java.db.Get_Information;
import cn.java.service.SendMessage;


//@WebServlet("/GetNowVipName")
public class GetNowVipName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tel = (String) request.getSession().getAttribute("usertel");
		boolean type = true;
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(null == tel || "".equals(tel)) {
			type = false;
		}else {
			List<Vip> listv = null;
			try {
				listv = Get_Information.getVipByTel(tel);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(listv.size() == 0) {
				map.put("vname", null);
				type = false;
			}else {
				Vip vip = listv.get(0);
				map.put("vname", vip.getVname());
				map.put("vid", vip.getVid());
			}
		}
		SendMessage<Vip> sm = new SendMessage<Vip>();
		sm.sendType(map, response, type, false);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
