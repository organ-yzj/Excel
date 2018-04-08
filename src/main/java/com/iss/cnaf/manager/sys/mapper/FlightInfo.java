package com.iss.cnaf.manager.sys.mapper;

import java.util.Date;

public class FlightInfo {
	private Integer autoId;

    private String flid;

    private String flno;

    private String alcd;

    private Date scat;

    private Date scdt;

    private String stnd;

    private Date fint;

    private String reno;

    private String acft;

    private String rout1;

    private String rout2;

    private String rout3;

    private String flty;

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public String getFlid() {
        return flid;
    }

    public void setFlid(String flid) {
        this.flid = flid == null ? null : flid.trim();
    }

    public String getFlno() {
        return flno;
    }

    public void setFlno(String flno) {
        this.flno = flno == null ? null : flno.trim();
    }

    public String getAlcd() {
        return alcd;
    }

    public void setAlcd(String alcd) {
        this.alcd = alcd == null ? null : alcd.trim();
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

    public Date getFint() {
        return fint;
    }

    public void setFint(Date fint) {
        this.fint = fint;
    }

    public String getReno() {
        return reno;
    }

    public void setReno(String reno) {
        this.reno = reno == null ? null : reno.trim();
    }

    public String getAcft() {
        return acft;
    }

    public void setAcft(String acft) {
        this.acft = acft == null ? null : acft.trim();
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

    public String getFlty() {
        return flty;
    }

    public void setFlty(String flty) {
        this.flty = flty == null ? null : flty.trim();
    }
}
