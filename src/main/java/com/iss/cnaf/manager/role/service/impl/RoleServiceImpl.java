package com.iss.cnaf.manager.role.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.iss.cnaf.manager.role.dao.RoleMapper;
import com.iss.cnaf.manager.role.service.RoleService;
import com.iss.cnaf.manager.role.vo.Role;
import com.iss.cnaf.manager.sys.model.GasMember;
import com.iss.cnaf.manager.sys.model.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iss.cnaf.manager.sys.model.CnafGrid;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public CnafGrid queryRoles(QueryParam param, CnafGrid grid) {
		PageHelper.startPage(param.getPage(), param.getRows());
		Page<Role> page = roleMapper.queryRoles(param);
		grid.setGrid(page.getTotal(), page.getResult());
		return grid;
	}

	@Override
	public void addRole(Role role) {
		roleMapper.insertSelective(role);
		
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateByPrimaryKey(role);
		
	}

	@Override
	public void deleteRole(int id) {
		roleMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<GasMember> queryRoleList() {
		List<Role> role = roleMapper.queryRoleList();
		ArrayList<GasMember> comboboxModel = new ArrayList<GasMember>();
		for (Role r : role) {
			GasMember m = new GasMember();
			m.setId(r.getId().toString());
			m.setText(r.getRoleName());
			comboboxModel.add(m);
		}
		return comboboxModel;
	}

	@Override
	public void insertPower(Role role) {
		roleMapper.deleteRolePower(role.getRoleId());
		String[] powerId = role.getPowerId().split(",");
		for (int i = 0; i < powerId.length; i++) {
			role.setPowerId(powerId[i]);
			roleMapper.insertRolePower(role);
		}
		
	}

	@Override
	public List<Role> checkRoles(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.checkRoles(role);
	}

}
