package com.iss.cnaf.manager.role.service;

import java.util.List;

import com.iss.cnaf.manager.sys.model.QueryParam;
import com.iss.cnaf.manager.role.vo.Role;
import com.iss.cnaf.manager.sys.model.CnafGrid;
import com.iss.cnaf.manager.sys.model.GasMember;

public interface RoleService {

	/**
	 * 查询角色列表
	 * @author: yangzhaojun
	 * @param param
	 * @param grid
	 * @return
	 */
	public CnafGrid queryRoles(QueryParam param, CnafGrid grid);

	/**
	 * 新增角色
	 * @author: yangzhaojun
	 * @param role
	 */
	public void addRole(Role role);

	public void updateRole(Role role);

	public void deleteRole(int id);

	public List<GasMember> queryRoleList();

	public void insertPower(Role role);

	public List<Role> checkRoles(Role role);


}
