package com.iss.cnaf.manager.sys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * ClassName:SyFilter  安全过滤
 *
 * @author   李丛阳
 * @version  
 * @since    Ver 1.1
 * @Date	 2015	2015年7月20日		下午3:29:59
 *
 * @see
 */
public class SyFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;
        
		if(httpRequest.getRequestURI().contains("systemController/loginByAdmin.do")){
			
			chain.doFilter(request, response);
		}
		else if(httpRequest.getRequestURI().contains("systemController/logoutByAdmin.do")){
			
			chain.doFilter(request, response);
		}
		else if(httpRequest.getRequestURI().contains("index.jsp")){
			
			chain.doFilter(request, response);
		}else{
			/*超时  非法*/
			Object user = httpRequest.getSession().getAttribute("sessionInfo");
			if(user == null){
				httpresponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");  
				return ;
			}
			else{
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
