package com.graduate.bsms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Logs implements Serializable {
    private Integer logid;

    private String operationtype;

    private String operationresult;

    private String operationuserid;

    private String ip;

    private Date operationdate;

    private static final long serialVersionUID = 1L;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype == null ? null : operationtype.trim();
    }

    public String getOperationresult() {
        return operationresult;
    }

    public void setOperationresult(String operationresult) {
        this.operationresult = operationresult == null ? null : operationresult.trim();
    }

    public String getOperationuserid() {
        return operationuserid;
    }

    public void setOperationuserid(String operationuserid) {
        this.operationuserid = operationuserid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "G+8")
    public Date getOperationdate() {
        return operationdate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setOperationdate(Date operationdate) {
        this.operationdate = operationdate;
    }
}