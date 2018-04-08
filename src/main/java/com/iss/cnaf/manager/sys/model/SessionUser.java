package com.iss.cnaf.manager.sys.model;

import java.io.Serializable;
import java.util.List;

import com.iss.cnaf.manager.power.vo.Power;

public class SessionUser implements Serializable{


	private static final long serialVersionUID = 5599054731462434728L;

	private String userId; //当前登录人id
	private String loginName; //当前登录人
	private String ip; //当前登录人
	private String role; //当前登录角色
	private String photo ; //当前登录人图片
	private Integer airportId; //当前登录人所属机场id

	private List<Power> powers;

	public SessionUser() {
	}

	public List<Power> getPowers() {
		return powers;
	}

	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getAirportId() {
		return airportId;
	}

	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}


	
	
}

