package com.ssm.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.ssm.domain.User;
import com.ssm.service.UserServer;

public class ShiroRealm extends AuthorizingRealm{

	@Resource
	private UserServer userServer;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection prinColl) {
		
		Set<String> roles = new HashSet<String>(); //用户角色
		Set<String> perms = new HashSet<String>(); //用户权限
		
		roles.add("admin");
		perms.add("/userList");
		
		// 权限信息对象,用来存放查出的用户的所有的角色及权限
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roles);
		info.setStringPermissions(perms);
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authToken) throws AuthenticationException {
		String username = (String) authToken.getPrincipal();
		User user = null;
		
		if(username != null){
			user = userServer.getUser(username);
		}
		
		if(user != null){
			return new SimpleAuthenticationInfo(username,user.getPassword(),getName());
		}
		
		return null;
	}
	

}
