package cn.java.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//@WebFilter("/EncodeFilter")
public class EncodeFilter implements Filter {
	private String encode;
   
    public EncodeFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println(encode);
		request.setCharacterEncoding(encode);
		response.setCharacterEncoding(encode);
		response.setContentType("text/html;charset="+this.encode);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String paramEncode = fConfig.getInitParameter("encode").trim();
		if(paramEncode != null && !"".equals(paramEncode) ) {
			this.encode = paramEncode;
		}
	}

}
