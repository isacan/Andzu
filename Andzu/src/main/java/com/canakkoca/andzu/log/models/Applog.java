package com.canakkoca.andzu.log.models;

import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * Created by can.akkoca on 4/13/2017.
 */


public class AppLog implements Serializable {

    private static final long serialVersionUID = 12341L;

    private int id;
    private String priority;
    private String tag;
    private String message;
    private int created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }
}
