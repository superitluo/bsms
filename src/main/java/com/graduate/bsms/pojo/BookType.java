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
public class BookType implements Serializable {
    private static final long serialVersionUID = 1L;

    private int bookTypeId;

    private Date addTime;

    private String bookTypeName;

    private Date removeTime;

    private int state;

    public BookType() {
    }

    public BookType(int bookTypeId, Date addTime, String bookTypeName, Date removeTime, int state) {
        super();
        this.bookTypeId = bookTypeId;
        this.addTime = addTime;
        this.bookTypeName = bookTypeName;
        this.removeTime = removeTime;
        this.state = state;
    }

    public int getBookTypeId() {
        return this.bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "G+8")
    public Date getAddTime() {
        return this.addTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getBookTypeName() {
        return this.bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "G+8")
    public Date getRemoveTime() {
        return this.removeTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setRemoveTime(Date removeTime) {
        this.removeTime = removeTime;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BookType [bookTypeId=" + bookTypeId + ", addTime=" + addTime + ", bookTypeName=" + bookTypeName
                + ", removeTime=" + removeTime + ", state=" + state + "]";
    }

}