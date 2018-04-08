package com.iss.cnaf.manager.role.vo;

import javax.persistence.Transient;

public class Role {

	private Integer id;
	
	private String roleName;//角色名称
	
	private String description;//描述
	
	@Transient
	private String roleId;
	
	@Transient
	private String powerId;
	
	@Transient
	private Integer rolePowerId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPowerId() {
		return powerId;
	}

	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}

	public Integer getRolePowerId() {
		return rolePowerId;
	}

	public void setRolePowerId(Integer rolePowerId) {
		this.rolePowerId = rolePowerId;
	}

}
