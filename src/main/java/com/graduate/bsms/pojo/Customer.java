package com.graduate.bsms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private String id;

    private String name;

    private Integer gender;

    private String phone;

    private String address;

    private Date birthday;

    private String cardnumber;

    private String cardtypeid;

    private String creatuserid;

    private Date creattime;

    private String updateuserid;

    private Date updatetime;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "G+8")
    public Date getBirthday() {
        return birthday;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber == null ? null : cardnumber.trim();
    }

    public String getCardtypeid() {
        return cardtypeid;
    }

    public void setCardtypeid(String cardtypeid) {
        this.cardtypeid = cardtypeid == null ? null : cardtypeid.trim();
    }

    public String getCreatuserid() {
        return creatuserid;
    }

    public void setCreatuserid(String creatuserid) {
        this.creatuserid = creatuserid == null ? null : creatuserid.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "G+8")
    public Date getCreattime() {
        return creattime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getUpdateuserid() {
        return updateuserid;
    }

    public void setUpdateuserid(String updateuserid) {
        this.updateuserid = updateuserid == null ? null : updateuserid.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "G+8")
    public Date getUpdatetime() {
        return updatetime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}