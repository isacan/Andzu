package com.canakkoca.andzu.base;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * Created by can.akkoca on 4/13/2017.
 */
@Entity
public class AppLog implements Serializable {

    private static final long serialVersionUID = 1231L;

    @Id
    private Long id;
    private String priority;
    private String tag;
    private String message;
    private Long created_at;
    private String log_type;

    @Generated(hash = 1856639126)
    public AppLog(Long id, String priority, String tag, String message,
            Long created_at, String log_type) {
        this.id = id;
        this.priority = priority;
        this.tag = tag;
        this.message = message;
        this.created_at = created_at;
        this.log_type = log_type;
    }

    @Generated(hash = 365541855)
    public AppLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public String getLog_type() {
        return log_type;
    }

    public void setLog_type(String log_type) {
        this.log_type = log_type;
    }
}
