package com.iss.cnaf.manager.user.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RegisterHistory {
	
	private Integer autoId; //主键
	private String userId; //员工编号
	private String carId; //车辆编号
	
	private String username;
	private String carname;
	
	private String time; //时间段

	private Integer airportId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date reDate; //借车时间
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime; //创建时间
	
	private String status; //是否暂停的状态位
	
	private String stopTime; //暂停时长
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date backTime; //还车日期
	
	
	public String getFormattedCreatetime(){
		 
		if(null != getCreateTime()) {
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		return df.format(getCreateTime());
    	}
    	return "";
	}
	
	public String getFormattedReDate(){
		
		if(null != getReDate()) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(getReDate());
		}
		return "";
	}
	public String getFormattedBackTime(){
		
		if(null != getBackTime()) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(getBackTime());
		}
		return "";
	}

	public Integer getAutoId() {
		return autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getReDate() {
		return reDate;
	}

	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public Integer getAirportId() {
		return airportId;
	}

	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}
	
}
