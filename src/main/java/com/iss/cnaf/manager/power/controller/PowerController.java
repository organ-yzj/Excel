package com.iss.cnaf.manager.power.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.iss.cnaf.manager.power.vo.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.cnaf.manager.power.service.PowerService;
import com.iss.cnaf.manager.sys.model.CnafGrid;
import com.iss.cnaf.manager.sys.model.QueryParam;
import com.iss.cnaf.manager.sys.model.SessionUser;

@Controller
@RequestMapping("/power")
public class PowerController {

	@Autowired
	private PowerService powerService;
	
	
	/**
	 * 跳转菜单资源管理页面
	 * @author: yangzhaojun
	 * @email: 1192590834@qq.com 
	 * @date 2017年3月13日 下午4:11:33
	 * @version V1.0
	 * @return
	 */
	@RequestMapping("/powerIndex")
	public String userIndex() {

		return "cnaf/power/powerList";
	}
	
	/**
	 * 查询菜单列表
	 * @author: yangzhaojun
	 * @email: 1192590834@qq.com 
	 * @date 2017年3月13日 下午4:10:51
	 * @version V1.0
	 * @param param
	 * @param grid
	 * @return
	 */
	@RequestMapping("/queryPowers")
	@ResponseBody
	public CnafGrid queryPowers(QueryParam param ,CnafGrid grid){
		
		powerService.queryPowers(param,grid);
		
		return grid;
	}
	
	
	
	@RequestMapping("/admin/menu")
	@ResponseBody
	public List<Map<String, Object>> menu(HttpServletRequest request){
		SessionUser user = (SessionUser) request.getSession().getAttribute("sessionInfo");
		return powerService.queryMenu(user.getUserId());
	}

	
	@RequestMapping("/queryPowerList")
	@ResponseBody
	public List<Power> queryPowerList(String roleId){
		return powerService.queryPowerList(roleId);
	}
	
	@RequestMapping("/queryRightPowerList")
	@ResponseBody
	public List<Power> queryRightPowerList(String roleId){
		return powerService.queryRightPowerList(roleId);
	}
}
