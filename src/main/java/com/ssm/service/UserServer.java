package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.domain.User;
import com.ssm.pagehelper.PagedResult;

public interface UserServer {

	public User getUser(String username,String password);
	
	public User getUser(String username);
	
	public List<Map<String,String>> findUserList();
	
	public List<Map<String,String>> findUserRoleList();
	
	PagedResult<Map<String,String>> queryUserList(Integer pageNo,Integer pageSize);
	
}
