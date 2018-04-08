package com.iss.cnaf.manager.user.controller;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.iss.cnaf.manager.sys.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.cnaf.manager.user.service.UserService;
import com.iss.cnaf.manager.user.vo.Register;
import com.iss.cnaf.manager.user.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping("/getServerTime")
	@ResponseBody
	public SystemicInfo getServerTime() {
		SystemicInfo systemicInfo = new SystemicInfo();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		systemicInfo.setSuccess(true);
		systemicInfo.setMessage(simpleDateFormat.format(new Date()));
		return systemicInfo;
	}

	/**
	 * 
	 * queryUser:分页查询用户信息
	 * 
	 * @author 李云萍
	 * @param param
	 * @param grid
	 * @return
	 * @since 　Ver 1.1
	 */
	@RequestMapping("/queryUser")
	@ResponseBody
	public CnafGrid queryUser(QueryParam param, CnafGrid grid, HttpServletRequest request) {

		SessionUser session = (SessionUser) request.getSession().getAttribute("sessionInfo");
		userServiceImpl.doQueryUsers(param, grid, session.getAirportId());

		return grid;
	}

	/**
	 * 
	 * userIndex:
	 * 
	 * @author 李云萍
	 * @return
	 * @since 　Ver 1.1
	 */
	@RequestMapping("/userIndex")
	public String userIndex() {

		return "cnaf/user/userManager";
	}

	/**
	 * 
	 * saveCar:添加用户信息
	 * 
	 * @author 李云萍
	 * @param system
	 * @param user
	 * @return
	 * @since 　Ver 1.1
	 */
	@RequestMapping("/saveUser")
	@ResponseBody
	public SystemicInfo saveUser(SystemicInfo system, User user, HttpServletRequest request) {
		List<User> result = userServiceImpl.checkUser(user,request);
		if(null == result || 0 == result.size()){
			userServiceImpl.saveUser(user,request);
			system.setSuccess(true, "添加成功");
		}else{
			system.setSuccess(false,"您的编号或用户名输入有重复，请重新输入");
		}
		return system;
	}

	/**
	 * 
	 * updateUser:修改用户信息
	 * 
	 * @author 李云萍
	 * @param system
	 * @param user
	 * @return
	 * @since 　Ver 1.1
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public SystemicInfo updateUser(SystemicInfo system, User user, Integer autoId) {
		user.setAutoId(autoId);
		userServiceImpl.updateUser(user);
		system.setSuccess(true, "修改成功");  
		return system;

	}

	/**
	 * 
	 * deleteUser:删除用户信息
	 * 
	 * @author 李云萍
	 * @param system
	 * @param user
	 * @return
	 * @since 　Ver 1.1
	 */
	@RequestMapping("/deleteUser")
	@ResponseBody
	public SystemicInfo deleteUser(SystemicInfo system, User user) {
		userServiceImpl.deleteUser(user.getAutoId());
		system.setSuccess(true, "删除成功");
		return system;

	}
	/**
	 * 
	 * checkByUserid:验证用户编号是否重复
	 * 
	 * @author 李云萍
	 * @param system
	 * @param user
	 * @return
	 * @since 　Ver 1.1
	 */
	@RequestMapping("/checkUser")
	@ResponseBody
	public SystemicInfo checkByUserid(SystemicInfo system, User user, HttpServletRequest request){
		SessionUser session = (SessionUser) request.getSession().getAttribute("sessionInfo");
		user.setAirportId(session.getAirportId());
		List<User> result=userServiceImpl.selectByUserid(user);
		if(null == result || 0 == result.size()) {

			 system.setSuccess(true, "您的修改已成功");
		} else {

			 system.setSuccess(false,"您的编号或用户名输入有重复,请重新输入");
		}
		 return system;
	}
	
	@RequestMapping("/updateUserPass")
	@ResponseBody
	public SystemicInfo updateUserpassword(SystemicInfo system, User user){
		userServiceImpl.updateUserpass(user);
		system.setSuccess(true, "修改成功");
		return system;
	}
     
	
	
	/**********                注册表模块                                                          ***************/
	
	@RequestMapping("/registryIndex")
	public String registryIndex(){
		return "cnaf/user/registryManager";
	}
	
	@RequestMapping("/queryRegister")
	@ResponseBody
	public CnafGrid queryRegister(QueryParam param, CnafGrid grid, HttpServletRequest request) {

		userServiceImpl.doQueryRegister(param, grid, request);

		return grid;
	}
	
	@RequestMapping("/queryWorkByCar")
	@ResponseBody
	public List<GasMember> queryWorkByCar(HttpServletRequest request,Register registry){
		
		return userServiceImpl.queryWorkByCar(request,registry);
		
	}

	@RequestMapping("/queryAllWorkByCar")
	@ResponseBody
	public List<GasMember> queryAllWorkByCar(HttpServletRequest request,Register registry){

		return userServiceImpl.queryAllWorkByCar(request,registry);

	}
	
	@RequestMapping("/queryCarByWorker")
	@ResponseBody
	public GasCar queryCarByWorker(HttpServletRequest request, Register registry){
		
		return userServiceImpl.queryCarByWorker(request, registry);
		
	}


	/**
	 *预排暂停可选
	 * @param request
	 * @param registry
	 * @return
	 */
	@RequestMapping("/queryCarPrepare")
	@ResponseBody
	public GasCar queryCarPrepare(HttpServletRequest request, Register registry){

		return userServiceImpl.queryCarPrepare(request, registry);

	}
	@RequestMapping("/queryPadByWorker")
	@ResponseBody
	public GasPad queryPadByWorker(HttpServletRequest request, Register registry){

		return userServiceImpl.queryPadByWorker(request, registry);

	}


	@RequestMapping("/queryPreprocePadByWorker")
	@ResponseBody
	public GasPad queryPreprocePadByWorker(HttpServletRequest request, Register registry){

		return userServiceImpl.queryPreprocePadByWorker(request, registry);


	}


	/**
	 * 修改状态，暂停/註銷
	 * @param system
	 * @param register
	 * @return
	 */
	@RequestMapping("/updateRegistryStatus")
	@ResponseBody
	public SystemicInfo updateRegistry(SystemicInfo system, Register register) {
		userServiceImpl.updateRegisterStatus(register);
		system.setSuccess(true,"操作成功");
		return system;
	}
	
	

	
	@RequestMapping("/deleteRegisterById")
	@ResponseBody
	public SystemicInfo deleteRegisterById(SystemicInfo system, Register registry){
		userServiceImpl.deleteRegisterById(registry);
		system.setSuccess(true, "还车成功");
		return system;
	}
	
	
	@RequestMapping("/assignRole")
	@ResponseBody
	public SystemicInfo assignRole(SystemicInfo system , User user ){
		userServiceImpl.assignRole(user);
		system.setSuccess(true, "分配成功");
		return system;
	}

	/**
	 * 登记表清零操作
	 * @param system
	 * @param registry
	 * @return
	 */
	@RequestMapping("/toZero")
	@ResponseBody
	public SystemicInfo toZero(SystemicInfo system , Register registry ){
		userServiceImpl.toZero(registry);
		system.setSuccess(true, "清零成功");
		return system;
	}
	
	/**
	 * 更新register表状态
	 * @param system
	 * @param register
	 * @return
	 */
	@RequestMapping("/updaStatus")
	@ResponseBody
	public SystemicInfo updaStatus(SystemicInfo system, Register register) {
		userServiceImpl.updaStatus(register);
		system.setSuccess(true,"操作成功");
		return system;
	}


	@RequestMapping("/queryRegisterList")
	@ResponseBody
	public CnafGrid queryRegisterList(QueryParam param, CnafGrid grid, HttpServletRequest request) {
		param.setPage(1);
		param.setRows(100);
		userServiceImpl.doQueryRegister(param, grid, request);

		return grid;
	}


	/**
	 * 查询全部状态
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryStatusList")
	@ResponseBody
	public List<GasMember> queryStatusList( HttpServletRequest request) {

		return userServiceImpl.queryStatusList(request);
	}


	/**
	 * 重置实排任务状态
	 * @param system
	 * @param register
	 * @return
	 */
	@RequestMapping("/resetStatus")
	@ResponseBody
	public SystemicInfo resetStatus(SystemicInfo system, Register register) {
		userServiceImpl.updaStatusByAutoId(register);
		system.setSuccess(true,"操作成功");
		return system;
	}

	
}
