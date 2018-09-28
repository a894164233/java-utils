package com.baitao.javautils.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/1/13.
 */
public class BasicResultView implements Serializable {

    private int status;
    private String message;

    public BasicResultView(int status) {
        this.status = status;
        this.message = "";
    }

    public BasicResultView(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BasicResultView{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}