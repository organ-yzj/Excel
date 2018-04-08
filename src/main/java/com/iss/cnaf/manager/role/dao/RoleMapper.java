package com.iss.cnaf.manager.role.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.iss.cnaf.manager.role.vo.Role;
import com.iss.cnaf.manager.sys.model.QueryParam;

public interface RoleMapper {

	/**
	 * 查询角色列表
	 * @author: yangzhaojun
	 * @param param
	 * @return
	 */
	Page<Role> queryRoles(QueryParam param);

	/**
	 * 新增角色
	 * @author: yangzhaojun
	 * @param role
	 * @return
	 */
	int insertSelective(Role role);

	/**
	 * 修改角色
	 * @author: yangzhaojun
	 * @param role
	 * @return
	 */
	int updateByPrimaryKey(Role role);

	/**
	 * 删除角色
	 * @author: yangzhaojun
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	public List<Role> queryRoleList();

	void insertPower(String roleId, String powerId);

	Role queryRolePowerId(String roleId);

	int deleteRolePower(String id);

	int insertRolePower(Role role);

	List<Role> checkRoles(Role role);


}
