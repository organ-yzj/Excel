package com.iss.cnaf.manager.sys.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:RouteRangeModel	任务串model
 *
 * @author 李丛阳
 * @Date 2015    2015年7月27日		下午2:05:09
 * @see
 * @since Ver 1.1
 */
public class RouteRangeModel {

    public RouteRangeModel() {
        // TODO Auto-generated constructor stub
    }

    /**
     * flight_info表自增主键，关联t_flight_info
     */
    private Long id;

    /**
     * 航班日期
     */
    private Date flyDate;

    /**
     * 下一個航班
     */
    private String nextFly;
    /**
     * 航班号
     */
    private String flight;

    private String routeId;

    private String car_Id;
    private Integer carModel;
    private String startTime;

    private String endTime;

    private String oilStartTime;

    private String oilEndTime;

    private int oilTimes;

    private String scheduledTime;

    private String stnd;

    private String status;
    private String userName;

    private String statuName;

    private Date felt;
    private Date fplt;
    private Date frlt;

    private Date fett;

    private Date scdt;

    private String userId;

    private Integer flightAutoId;

    private String airport;

    private byte missionPro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public Integer getFlightAutoId() {
        return flightAutoId;
    }

    public void setFlightAutoId(Integer flightAutoId) {
        this.flightAutoId = flightAutoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStnd() {
        return stnd;
    }

    public void setStnd(String stnd) {
        this.stnd = stnd;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getOilStartTime() {
        return oilStartTime;
    }

    public void setOilStartTime(String oilStartTime) {
        this.oilStartTime = oilStartTime;
    }

    public String getOilEndTime() {
        return oilEndTime;
    }

    public void setOilEndTime(String oilEndTime) {
        this.oilEndTime = oilEndTime;
    }

    public Date getFlyDate() {
        return flyDate;
    }

    public String getFormattedFlyDate() {
        if (null != getFlyDate()) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.format(getFlyDate());
        }
        return "";
    }

    public void setFlyDate(Date flyDate) {
        this.flyDate = flyDate;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }


    public String getNextFly() {
        return nextFly;
    }

    public void setNextFly(String nextFly) {
        this.nextFly = nextFly;
    }


    public String getCar_Id() {
        return car_Id;
    }

    public void setCar_Id(String car_Id) {
        this.car_Id = car_Id;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {

        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatuName() {
        return statuName;
    }

    public void setStatuName(String statuName) {
        this.statuName = statuName;
    }

    public Date getFelt() {
        return felt;
    }

    public String getFeltStr() {
        if (null != getFelt()) {
            DateFormat df = new SimpleDateFormat("HH:mm");
            return df.format(getFelt());
        }
        return "";
    }

    public void setFelt(Date felt) {
        this.felt = felt;
    }

    public String getFpltStr() {
        if (null != getFplt()) {
            DateFormat df = new SimpleDateFormat("HH:mm");
            return df.format(getFplt());
        }
        return "";
    }

    public Date getFplt() {
        return fplt;
    }

    public void setFplt(Date fplt) {
        this.fplt = fplt;
    }

    public String getFrltStr() {
        if (null != getFrlt()) {
            DateFormat df = new SimpleDateFormat("HH:mm");
            return df.format(getFrlt());
        }
        return "";
    }

    public Date getFrlt() {
        return frlt;
    }

    public void setFrlt(Date frlt) {
        this.frlt = frlt;
    }

    public Date getFett() {
        return fett;
    }

    public String getFettStr() {
        if (null != getFett()) {
            DateFormat df = new SimpleDateFormat("HH:mm");
            return df.format(getFett());
        }
        return "";
    }

    public void setFett(Date fett) {
        this.fett = fett;
    }

    public Date getScdt() {
        return scdt;
    }

    public String getScdtStr() {
        if (null != getScdt()) {
            DateFormat df = new SimpleDateFormat("HH:mm");
            return df.format(getScdt());
        }
        return "";
    }

    public void setScdt(Date scdt) {
        this.scdt = scdt;
    }

    public byte getMissionPro() {
        return missionPro;
    }

    public void setMissionPro(byte missionPro) {
        this.missionPro = missionPro;
    }

    public int getOilTimes() {
        return oilTimes;
    }

    public void setOilTimes(int oilTimes) {
        this.oilTimes = oilTimes;
    }

    public Integer getCarModel() {
        return carModel;
    }

    public void setCarModel(Integer carModel) {
        this.carModel = carModel;
    }
}
