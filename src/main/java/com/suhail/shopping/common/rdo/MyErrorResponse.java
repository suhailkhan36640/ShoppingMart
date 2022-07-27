/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.common.rdo;

public class MyErrorResponse {

    private int status;

    private String message;

    private String detail;

    public MyErrorResponse() {

    }

    public MyErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
