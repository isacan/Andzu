package com.canakkoca.andzu.base;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by can.akkoca on 4/12/2017.
 */

@Entity
public class NetworkLog  implements Serializable{

    private static final long serialVersionUID = 12331L;

    @Id
    private Long id;
    private String requestType;
    private String url;
    private Long date;
    private String headers;
    private String responseCode;
    private String responseData;
    private Double duration;
    private String errorClientDesc;
    private String postData;

    @Generated(hash = 1773455752)
    public NetworkLog(Long id, String requestType, String url, Long date,
            String headers, String responseCode, String responseData,
            Double duration, String errorClientDesc, String postData) {
        this.id = id;
        this.requestType = requestType;
        this.url = url;
        this.date = date;
        this.headers = headers;
        this.responseCode = responseCode;
        this.responseData = responseData;
        this.duration = duration;
        this.errorClientDesc = errorClientDesc;
        this.postData = postData;
    }

    @Generated(hash = 156192081)
    public NetworkLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getErrorClientDesc() {
        return errorClientDesc;
    }

    public void setErrorClientDesc(String errorClientDesc) {
        this.errorClientDesc = errorClientDesc;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(),
                "Request Type : %s \n" +
                        "Request Url : %s\n" +
                        "Request Date : %d\n" +
                        "Request Headers : %s\n" +
                        "Response Code : %s\n" +
                        "Response Data : %s\n" +
                        "Duration : %d\n" +
                        "Error Client Desc : %s\n" +
                        "Post Data : %s",requestType,url,date,headers,responseCode,responseData,
                (long)duration.doubleValue(),errorClientDesc,postData);
    }
}
