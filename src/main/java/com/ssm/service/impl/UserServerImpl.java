package com.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.UserDao;
import com.ssm.domain.User;
import com.ssm.pagehelper.PagedResult;
import com.ssm.service.UserServer;
import com.ssm.utils.BeanUtil;

@Service
public class UserServerImpl implements UserServer {

	@Resource
	private UserDao userDao;
	
	@Override
	public User getUser(String username, String password) {
		return userDao.selectUser(username, password);
	}

	@Override
	public List<Map<String,String>> findUserList() {
		return userDao.findUserList();
	}

	@Override
	public List<Map<String, String>> findUserRoleList() {
		return userDao.findUserRoleList();
	}

	@Override
	public PagedResult<Map<String, String>> queryUserList(Integer pageNo,
			Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(userDao.findUserList());
	}
	
}
