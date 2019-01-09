package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
  
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String name;
    private String password;
    private String phone;
    private String adrr;
    private String yjphone;
    private Date intime;
    
    public User(){
    	super();
    }
    public User(Integer id,String name,
    		String password,String phone,
    		String adrr,String yjphone,Date intime){
    	super();
    	this.id = id;
    	this.adrr = adrr;
    	this.intime = intime;
    	this.name = name;
    	this.password = password;
    	this.phone = phone;
    	this.yjphone = yjphone;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAdrr() {
        return adrr;
    }
    public void setAdrr(String adrr) {
        this.adrr = adrr == null ? null : adrr.trim();
    }

    public String getYjphone() {
        return yjphone;
    }
    public void setYjphone(String yjphone) {
        this.yjphone = yjphone == null ? null : yjphone.trim();
    }

    public Date getIntime() {
        return intime;
    }
    public void setIntime(Date intime) {
        this.intime = intime;
    }
    
    public String toString(){
    	return "用户名：" + this.name 
    			+ "密码：" + this.password
    			+ "电话：" + this.phone
    			+ "地址：" + this.adrr
    			+ "应急号码：" + this.yjphone
    			+ "入库时间：" + this.intime
    			+ "用户ID：" + this.id;
    }
    
    
}