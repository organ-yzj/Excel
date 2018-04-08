package com.iss.cnaf.manager.sys.model;



/**
 * ClassName:MessageIgt	igt message
 *
 * @author 李丛阳
 * @Date 2015    2015年7月23日		下午3:57:34
 * @see
 * @since Ver 1.1
 */
public class MessageIgt {

    public MessageIgt() {
        // TODO Auto-generated constructor stub
    }


    private String clientId;

    private String title;

    private String content;

    private String workerId;

    private int taskId;

    private String temperature;

    private String fueldensity;

    private int cartype;

    /**
     * 任务类型，标识派工任务性质[mission_pro]:tinyint（1:预排/0:实派）
     */
    private byte missionPro;

    private String carId;

    private String earlyTime;


    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getFueldensity() {
        return fueldensity;
    }

    public void setFueldensity(String fueldensity) {
        this.fueldensity = fueldensity;
    }

    public int getCartype() {
        return cartype;
    }

    public void setCartype(int cartype) {
        this.cartype = cartype;
    }

    public byte getMissionPro() {
        return missionPro;
    }

    public void setMissionPro(byte missionPro) {
        this.missionPro = missionPro;
    }

    public String getEarlyTime() {
        return earlyTime;
    }

    public void setEarlyTime(String earlyTime) {
        this.earlyTime = earlyTime;
    }
}
