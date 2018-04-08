package com.iss.cnaf.manager.sys.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.cnaf.manager.power.service.PowerService;
import com.iss.cnaf.manager.power.service.impl.PowerServiceImpl;
import com.iss.cnaf.manager.power.vo.Power;
import com.iss.cnaf.manager.sys.model.SessionUser;

public class SecurityFilter implements Filter {

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse =  (HttpServletResponse) response;
            if(httpRequest.getRequestURI().contains("systemController/loginByAdmin.do")){
    			
    			chain.doFilter(request, response);
    		}
    		else if(httpRequest.getRequestURI().contains("systemController/logoutByAdmin.do")){
    			
    			chain.doFilter(request, response);
    		}
    		else if(httpRequest.getRequestURI().contains("app")){
    			
    			chain.doFilter(request, response);
    		}
    		else{
    			/*超时  非法*/
    			SessionUser user = (SessionUser) httpRequest.getSession().getAttribute("sessionInfo");
    			if(user == null){
    				//未登录
    				httpRequest.setAttribute("message", "请登录！！！");
    	          	httpServletResponse.sendRedirect(httpRequest.getContextPath()+"/login.jsp");
    	              return;
    			}
    			else{
    				chain.doFilter(request, response);
    			}
    		}
            }
        	


	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
