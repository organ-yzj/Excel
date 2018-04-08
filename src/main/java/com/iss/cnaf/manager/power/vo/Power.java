package com.iss.cnaf.manager.power.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_power")
public class Power {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="url")
	private String url;//url
	
	private String powerName;
	
	@Column(name="description")
	private String description;//描述
	
	@Column(name="tree_code")
	private Integer treeCode;//树节点code
	
	@Column(name="parent_code")
	private Integer parentCode;//父节点code
	
	@Column(name="tree_level")
	private Integer level;//树深度
	
	public Integer getTreeCode() {
		return treeCode;
	}

	public Integer getParentCode() {
		return parentCode;
	}

	public Integer getLevel() {
		return level;
	}

	public void setTreeCode(Integer treeCode) {
		this.treeCode = treeCode;
	}

	public void setParentCode(Integer parentCode) {
		this.parentCode = parentCode;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
