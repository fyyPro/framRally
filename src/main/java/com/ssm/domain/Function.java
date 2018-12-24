package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class Function implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
    private String funname;
    private String funurl;
    private Integer funlevel;
    private Integer funfid;
    private Date intime;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunname() {
        return funname;
    }
    public void setFunname(String funname) {
        this.funname = funname == null ? null : funname.trim();
    }

    public String getFunurl() {
        return funurl;
    }
    public void setFunurl(String funurl) {
        this.funurl = funurl == null ? null : funurl.trim();
    }

    public Integer getFunlevel() {
        return funlevel;
    }
    public void setFunlevel(Integer funlevel) {
        this.funlevel = funlevel;
    }

    public Integer getFunfid() {
        return funfid;
    }
    public void setFunfid(Integer funfid) {
        this.funfid = funfid;
    }

    public Date getIntime() {
        return intime;
    }
    public void setIntime(Date intime) {
        this.intime = intime;
    }
    
}