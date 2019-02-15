package cn.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Liveroom;
import cn.java.db.Get_Information;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//@WebServlet("/GetLiveRoomByVid")
public class GetLiveRoomByVid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vid = request.getParameter("ID");
		//String vid = "23";
		if(vid == null || "".equals(vid)) {
			System.out.println("null");
		}else {
			System.out.println(vid);
		}
		List<Liveroom> listl = null;
		try {
			listl = Get_Information.getLiveroomByVid(Integer.parseInt(vid));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jb = JSONArray.fromObject(listl);
		PrintWriter pw = response.getWriter();
		pw.write(jb.toString());
		pw.flush();
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
