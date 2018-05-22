package com.graduate.bsms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    private Long id;

    private String rolecode;

    private String rolename;

    private String createdby;

    private Date creationdate;

    private String modifyby;

    private Date modifydate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "G+8")
    public Date getCreationdate() {
        return creationdate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getModifyby() {
        return modifyby;
    }

    public void setModifyby(String modifyby) {
        this.modifyby = modifyby;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "G+8")
    public Date getModifydate() {
        return modifydate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
}