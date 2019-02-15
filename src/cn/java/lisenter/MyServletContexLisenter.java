package cn.java.lisenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.java.bean.Reservation;


@WebListener
public class MyServletContexLisenter implements ServletContextListener {
	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }

	/**
	 * servletcontex被创建时向其中加入一个map集合，存储当前已登录的用户tel
	 */
    public void contextInitialized(ServletContextEvent arg0)  { 
         Map<String, Object> userMap = new HashMap<String,Object>();
         ServletContext sc = arg0.getServletContext();
         sc.setAttribute("user", userMap);
         
       
    }
	
}
