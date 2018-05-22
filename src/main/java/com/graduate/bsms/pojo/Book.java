package com.graduate.bsms.pojo;

import
        java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 创建时间：2018年3月31日 上午11:05:50
 * 项目名称：bsms
 *
 * @author luomingjian
 * @version 1.0
 * @since JDK 1.6.0_21
 * 文件名称：Book.java
 * 类说明：  图书类
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookId;

    private Date addTime;

    private String author;

    private String blurb;

    private String bookName;

    private double bookPrice;

    private String imageUrl1;

    private String imageUrl2;

    private String imageUrl3;

    private String isbn;

    private int publishId;

    private Date removeTime;

    private int state;

    private int typeId;

    public Book() {
    }

    public Book(String bookId, Date addTime, String author, String blurb, String bookName, double bookPrice,
                String imageUrl1, String imageUrl2, String imageUrl3, String isbn, int publishId, Date removeTime,
                int state, int typeId) {
        super();
        this.bookId = bookId;
        this.addTime = addTime;
        this.author = author;
        this.blurb = blurb;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.imageUrl3 = imageUrl3;
        this.isbn = isbn;
        this.publishId = publishId;
        this.removeTime = removeTime;
        this.state = state;
        this.typeId = typeId;
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "G+8")
    public Date getAddTime() {
        return this.addTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlurb() {
        return this.blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return this.bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getImageUrl1() {
        return this.imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getImageUrl2() {
        return this.imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getImageUrl3() {
        return this.imageUrl3;
    }

    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishId() {
        return this.publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
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

    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", addTime=" + addTime + ", author=" + author + ", blurb=" + blurb
                + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", imageUrl1=" + imageUrl1 + ", imageUrl2="
                + imageUrl2 + ", imageUrl3=" + imageUrl3 + ", isbn=" + isbn + ", publishId=" + publishId
                + ", removeTime=" + removeTime + ", state=" + state + ", typeId=" + typeId + "]";
    }

}