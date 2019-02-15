package cn.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import cn.java.bean.Staff;
import cn.java.bean.Vip;
import cn.java.db.Get_Information;



/*
//_oo0oo_
//o8888888o
//88" . "88
//(| -_- |)
//0\  =  /0
//___/`---'\___
//.' \\|     |// '.
/// \\|||  :  |||// \
/// _||||| -:- |||||- \
//|   | \\\  -  /// |   |
//| \_|  ''\---/''  |_/ |
//\  .-\__  '-'  ___/-. /
//___'. .'  /--.--\  `. .'___
//."" '<  `.___\_<|>_/___.' >' "".
//| | :  `- \`.;`\ _ /`;.`/ - ` : | |
//\  \ `_.   \_ __\ /__ _/   .-` /  /
//=====`-.____`.___ \_____/___.-`___.-'=====
//`=---='
//
//
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//���汣��         ����BUG
*/


public class Login extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//����˺�����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		//���session
		HttpSession session = request.getSession();
		//��÷�װjavabean��list
		List<Staff> list = null;
		List<Vip> listb = null;
		//json����
		JSONObject jsonObject = null;
		if("1".equals(usertype)) {
			try {
				//���list
				listb = Get_Information.getVip();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//����list
			for(Vip vip : listb) {
				if( vip.getVtel().equals(username) && vip.getVpassword().equals(password)) {
					jsonObject = new JSONObject("{flag:true,yy:1}");
					
					//��usermap���Ѿ����и��û���telʱ����ǰ�˷�������
					if(checkLogin(session,username)) {
						jsonObject = new JSONObject("{flag:have}");
						break;
					}
					session.setAttribute("usertel", username);
					addUsernameToMap(session,username);
					break;
				}else {
				jsonObject = new JSONObject("{flag:false}");
				}
			}
		}else {
			if("2".equals(usertype)) {
				if("123".equals(username) && "123".equals(password)){
					jsonObject = new JSONObject("{flag:true,yy:2}");
					if(checkLogin(session,username)) {
						jsonObject = new JSONObject("{flag:have}");
						
					}else {
						session.setAttribute("usertel", username);
						addUsernameToMap(session,username);
					}
					
				}else{
					//�����¼ʧ�ܣ����ǰ̨html��������
					jsonObject = new JSONObject("{flag:false}");
				}
			}else {
				if("3".equals(usertype)) {
					try {
						//���list
						list = Get_Information.getStaff();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//����list�����Ƿ��и��û�,�������ݿ����Ƿ��и��û�
					for(Staff staff : list) {
						if( staff.getStel().equals(username) && staff.getSpassword().equals(password)) {
							jsonObject = new JSONObject("{flag:true,yy:3}");
							if(checkLogin(session,username)) {
								jsonObject = new JSONObject("{flag:have}");
								break;
							}
							session.setAttribute("usertel", username);
							addUsernameToMap(session,username);
							break;
						}else {
						jsonObject = new JSONObject("{flag:false}");
						}
					}
					
				}
			}
		}
		//��ǰ�ϴ������ݲ��رմ�ӡ��
		PrintWriter out =response.getWriter();
		out.write(jsonObject.toString());
		out.flush();
		out.close();
	}
	/**
	 * ����ǰδ��¼���û���SEESION���뵽servletcontex��map��
	 * @param session
	 * @param username
	 */
	public void addUsernameToMap(HttpSession session,String username) {
		Map<String, Object> userMap =(Map<String, Object>) session.getServletContext().getAttribute("user");
		 userMap.put(username, session.getId());
		 session.getServletContext().setAttribute("user", userMap);
	}
	/**
	 * ���servletcontex���Ƿ��е�ǰ�û���session��ʹ���û���tel���жϣ���ΪtelΨһ
	 * @param session
	 * @param username
	 * @return
	 */
	public boolean checkLogin(HttpSession session,String username) {
		 Map<String, Object> userMap = (Map<String, Object>) session.getServletContext().getAttribute("user");
		 Set<String> set = userMap.keySet();
		 for(String user : set) {
			 if(user.equals(username)) {
				 return true;
			 }
		 }
		return false;
	}
}
