package cn.java.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 防止直接复制网址接入后台
 * @author 1
 *
 */
//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String tel = (String) session.getAttribute("usertel");
		String a=req.getRequestURI();
		if(tel == null && !a.contains(".css") && !a.contains(".js") && !a.contains(".png") && !a.contains(".jpg")) {
			HttpServletResponse rep = (HttpServletResponse)response;
			String rpath = req.getContextPath();
			rep.sendRedirect(rpath+"/hotel/index.html");
		}else {
			chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
