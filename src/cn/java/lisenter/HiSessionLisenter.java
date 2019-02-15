package cn.java.lisenter;


import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HiSessionLisenter
 *
 */
@WebListener
public class HiSessionLisenter implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public HiSessionLisenter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	//arg0.getSession().setMaxInactiveInterval(5);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	 String usertel = arg0.getSession().getAttribute("usertel").toString();
         
         if(usertel != null) {
         	 Map<String, Object> userMap = (Map<String, Object>) arg0.getSession().getServletContext().getAttribute("user");
         	 userMap.remove(usertel);
         	 arg0.getSession().getServletContext().setAttribute("user", userMap);
         	
         
         }
    }
	
}
