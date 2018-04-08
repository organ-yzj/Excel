package com.iss.cnaf.manager.sys.mapper;

import java.util.Date;

public class Workorder {
    private Integer autoId;

    private String flno;

    private Date scat;

    private Date scdt;

    private String stnd;

    private String acft;

    private String alcd;

    private String rout1;

    private String rout2;

    private String rout3;

    private String carId;

    private String workerId;

    private String oilMass;

    private Date arriveTime;

    private String picUrl;

    private Integer status;

    private Date overTime;

    private Date createTime;

    private Date oilStartime;

    private Date oilEndtime;

    private String gaswellId;

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno == null ? null : flno.trim();
    }

    public Date getScat() {
        return scat;
    }

    public void setScat(Date scat) {
        this.scat = scat;
    }

    public Date getScdt() {
        return scdt;
    }

    public void setScdt(Date scdt) {
        this.scdt = scdt;
    }

    public String getStnd() {
        return stnd;
    }

    public void setStnd(String stnd) {
        this.stnd = stnd == null ? null : stnd.trim();
    }

    public String getAcft() {
        return acft;
    }

    public void setAcft(String acft) {
        this.acft = acft == null ? null : acft.trim();
    }

    public String getAlcd() {
        return alcd;
    }

    public void setAlcd(String alcd) {
        this.alcd = alcd == null ? null : alcd.trim();
    }

    public String getRout1() {
        return rout1;
    }

    public void setRout1(String rout1) {
        this.rout1 = rout1 == null ? null : rout1.trim();
    }

    public String getRout2() {
        return rout2;
    }

    public void setRout2(String rout2) {
        this.rout2 = rout2 == null ? null : rout2.trim();
    }

    public String getRout3() {
        return rout3;
    }

    public void setRout3(String rout3) {
        this.rout3 = rout3 == null ? null : rout3.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId == null ? null : workerId.trim();
    }

    public String getOilMass() {
        return oilMass;
    }

    public void setOilMass(String oilMass) {
        this.oilMass = oilMass == null ? null : oilMass.trim();
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOilStartime() {
        return oilStartime;
    }

    public void setOilStartime(Date oilStartime) {
        this.oilStartime = oilStartime;
    }

    public Date getOilEndtime() {
        return oilEndtime;
    }

    public void setOilEndtime(Date oilEndtime) {
        this.oilEndtime = oilEndtime;
    }

    public String getGaswellId() {
        return gaswellId;
    }

    public void setGaswellId(String gaswellId) {
        this.gaswellId = gaswellId == null ? null : gaswellId.trim();
    }
}