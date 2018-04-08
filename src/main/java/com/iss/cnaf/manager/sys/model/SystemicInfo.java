/**
 * SystemicInfo.java
 * com.xfxmcy.spouse.model
 * <p>
 * Function： model conform to Json
 * <p>
 * ver     date      		author
 * ──────────────────────────────────
 * 2014年1月7日 		cy
 * <p>
 * Copyright (c) 2014, xfxmcy All Rights Reserved.
 */

package com.iss.cnaf.manager.sys.model;

/**
 * ClassName:SystemicInfo
 * Function: model conform to Json
 * Reason:	 model conform to Json
 *
 * @author cy
 * @version
 * @since Ver 1.1
 * @Date 2014年1月7日        下午2:35:43
 *
 * @see
 */

public class SystemicInfo {


    private boolean success = false;

    private String message = "";

    private Object result = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setSuccess(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public SystemicInfo() {

        // TODO Auto-generated constructor stub

    }


}

