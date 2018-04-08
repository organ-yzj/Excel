package com.iss.cnaf.manager.user.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 上班登记表
 *
 * @author David
 */
public class Register {

    private Integer autoId;
    private String userId;
    private String carId;
    private String padId;
    private String carModel;
    private String time;
    private String status;
    /**
     * 暂停时长
     */
    private String stopTime;

    private Integer airportId;
    /**
     * 已加油架次
     */
    private int refuelNum;

    private String statusName;

    private String userName;

    private String carName;
    /**
     * 连续执行任务数
     */
    private Integer conCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date backTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastMissionTime;

    private int st;
    private int et;

    private String preStatus;

    private String preStatusName;

    public Integer getConCount() {
        return conCount;
    }

    public void setConCount(Integer conCount) {
        this.conCount = conCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getReDate() {
        return reDate;
    }

    public void setReDate(Date reDate) {
        this.reDate = reDate;
    }

    public String getFormattedReDate() {

        if (null != getReDate()) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(getReDate());
        }
        return "";
    }

    public Date getLastMissionTime() {
        return lastMissionTime;
    }

    public String getLastMissionTimeStr() {
        if (null != getLastMissionTime()) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(getLastMissionTime());
        }
        return "";
    }

    public void setLastMissionTime(Date lastMissionTime) {
        this.lastMissionTime = lastMissionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public String getFormattedCreateTime() {
        if (null != getCreateTime()) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(getCreateTime());
        }
        return "";
    }

    public String getFormattedBackTime() {
        if (null != getBackTime()) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(getBackTime());
        }
        return "";
    }


    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getEt() {
        return et;
    }

    public void setEt(int et) {
        this.et = et;
    }

    public Integer getAirportId() {
        return airportId;
    }

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public int getRefuelNum() {
        return refuelNum;
    }

    public void setRefuelNum(int refuelNum) {
        this.refuelNum = refuelNum;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(String preStatus) {
        this.preStatus = preStatus;
    }

    public String getPadId() {
        return padId;
    }

    public void setPadId(String padId) {
        this.padId = padId;
    }

    public String getPreStatusName() {
        return preStatusName;
    }

    public void setPreStatusName(String preStatusName) {
        this.preStatusName = preStatusName;
    }
}
