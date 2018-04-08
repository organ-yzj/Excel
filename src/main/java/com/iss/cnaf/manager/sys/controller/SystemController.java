 package com.iss.cnaf.manager.sys.controller;

import javax.servlet.http.HttpServletRequest;
import com.iss.cnaf.manager.sys.model.SessionUser;
import com.iss.cnaf.manager.sys.model.SystemicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.cnaf.manager.user.service.UserService;
import com.iss.cnaf.manager.user.vo.User;

@Controller
@RequestMapping("/systemController")
public class SystemController {
	
	@Autowired
	private UserService userServiceImpl;

	@RequestMapping("/loginByAdmin")
	@ResponseBody
	public SystemicInfo loginByAdmin(User user , SystemicInfo sysInfo , HttpServletRequest request){

		User result = userServiceImpl.doLogin(user);
		
		if(null != result){
			sysInfo.setSuccess(true,"欢迎您成功登陆"); 
			SessionUser userLogin = getSessionUser(result, request);
			request.getSession().setAttribute("sessionInfo", userLogin);
			sysInfo.setResult(userLogin); 
		}else{
			sysInfo.setSuccess(false,"密码错误");
		}
		return sysInfo;
	}

	@RequestMapping("/logoutByAdmin")
	@ResponseBody
	public  SystemicInfo logoutByAdmin(SystemicInfo info, HttpServletRequest request){
		info.setSuccess(true, "退出成功"); 
		request.getSession().removeAttribute("sessionInfo");
		return info;
	}


	public SessionUser getSessionUser(User user ,HttpServletRequest request){
		SessionUser sessionInfo = new SessionUser();
		sessionInfo.setUserId(user.getUserId());
		sessionInfo.setLoginName(user.getUsername());
		sessionInfo.setPowers(user.getPowers());
		sessionInfo.setAirportId(user.getAirportId());
		return sessionInfo;
	}
	
}
