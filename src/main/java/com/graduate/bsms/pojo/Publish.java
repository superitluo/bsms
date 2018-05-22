package com.graduate.bsms.pojo;

import java.io.Serializable;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 创建时间：2018年3月28日 下午7:00:09
 * 项目名称：bsms
 *
 * @author luomingjian
 * @version 1.0
 * @since JDK 1.6.0_21
 * 文件名称：Booktype.java
 * 类说明：  图书类型类
 */
public class Publish implements Serializable {
    private static final long serialVersionUID = 1L;

    private int publishId;

    private Date addTime;

    private String publishName;

    private Date removeTime;

    private int state;

    public Publish() {
        super();
    }

    public Publish(int publishId, Date addTime, String publishName, Date removeTime, int state) {
        super();
        this.publishId = publishId;
        this.addTime = addTime;
        this.publishName = publishName;
        this.removeTime = removeTime;
        this.state = state;
    }

    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public Date getRemoveTime() {
        return removeTime;
    }

    public void setRemoveTime(Date removeTime) {
        this.removeTime = removeTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Publish [publishId=" + publishId + ", addTime=" + addTime + ", publishName=" + publishName
                + ", removeTime=" + removeTime + ", state=" + state + "]";
    }


}