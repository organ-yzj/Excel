package com.iss.cnaf.manager.role.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iss.cnaf.manager.role.service.RoleService;
import com.iss.cnaf.manager.role.vo.Role;
import com.iss.cnaf.manager.sys.model.GasMember;
import com.iss.cnaf.manager.sys.model.QueryParam;
import com.iss.cnaf.manager.sys.model.SystemicInfo;
import com.iss.cnaf.manager.user.service.UserService;
import com.iss.cnaf.manager.user.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.cnaf.manager.sys.model.CnafGrid;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转角色信息页面
	 * @author: yangzhaojun
	 * @email: 1192590834@qq.com 
	 * @date 2017年3月13日 上午10:41:35
	 * @version V1.0
	 * @return
	 */
	@RequestMapping("/roleIndex")
	public String userIndex() {

		return "cnaf/role/roleList";
	}
	
	/**
	 * 查询角色列表
	 * @author: yangzhaojun
	 * @email: 1192590834@qq.com 
	 * @date 2017年3月13日 上午11:08:13
	 * @version V1.0
	 * @param param
	 * @param grid
	 * @return
	 */
	@RequestMapping("/queryRoles")
	@ResponseBody
	public CnafGrid queryRoles(QueryParam param , CnafGrid grid){
		
		roleService.queryRoles(param,grid);
		
		return grid;
	}
	
	/**
	 * 新增角色
	 * @author: yangzhaojun
	 * @email: 1192590834@qq.com 
	 * @date 2017年3月13日 下午1:35:07
	 * @version V1.0
	 * @param system
	 * @param worker
	 * @return
	 */
	@RequestMapping("/addRole")
	@ResponseBody
	public SystemicInfo addRole(SystemicInfo system , Role role, HttpServletRequest request){
		List<Role> list = roleService.checkRoles(role);
		if(null == list || 0 == list.size()){
			roleService.addRole(role);
			system.setSuccess(true, "添加成功");
		}else{
			system.setSuccess(false,"您的角色名称有重复，请重新输入");
		}
		return system;
	}
	
	/**
	 * 修改角色
	 * @author: yangzhaojun
	 * @email: 1192590834@qq.com 
	 * @date 2017年3月13日 下午2:38:42
	 * @version V1.0
	 * @param system
	 * @param worker
	 * @return
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	public SystemicInfo updateRole(SystemicInfo system , Role role, Integer id){
		role.setId(id);
		roleService.updateRole(role);
		system.setSuccess(true, "修改成功");
		return system;
	}
	
	/**
	 * 删除角色
	 * @author: yangzhaojun
	 * @email: 1192590834@qq.com 
	 * @date 2017年3月14日 上午8:46:33
	 * @version V1.0
	 * @param system
	 * @param role
	 * @return
	 */
	 @RequestMapping("/deleteRole")
	 @ResponseBody
	 public SystemicInfo deleteRole(SystemicInfo system ,  Role role){
		 User user = new User();
		 user.setRoleId(role.getId());
		 List<User> list = userService.checkRoleId(user);
		 if(null == list || 0 == list.size()){
				 roleService.deleteRole(role.getId());
				 system.setSuccess(true, "删除成功");
			}else{
				system.setSuccess(false,"该角色已绑定用户，不能删除");
			}
		return system;
	 }
	
	
	@RequestMapping("/assignPower")
	@ResponseBody
	public SystemicInfo assignPower(SystemicInfo system,Role role) {
		roleService.insertPower(role);
		system.setSuccess(true, "分配成功");
		return system;
	}
	

	@RequestMapping("/queryRoleList")
	@ResponseBody
	public List<GasMember> queryRoleList() {

		return roleService.queryRoleList();
	}
}
