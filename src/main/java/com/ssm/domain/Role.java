package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{
   
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Integer role;
    private String rolename;
    private Date intime;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }
    public void setRole(Integer role) {
        this.role = role;
    }

    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Date getIntime() {
        return intime;
    }
    public void setIntime(Date intime) {
        this.intime = intime;
    }
}