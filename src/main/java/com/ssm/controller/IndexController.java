package com.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ssm.domain.User;
import com.ssm.service.UserServer;

@Controller
public class IndexController {

	private static ModelAndView model = null;
	@Resource
	private UserServer userServer;
	
	@RequestMapping("/login")
	public ModelAndView indexJsp(HttpServletRequest request){
		model = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userServer.getUser(username, password);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		
		//认证
		subject.login(token);
		
		//subject.logout(); //退出
		
		if(user != null){
			request.getSession().setAttribute("user", user);
			model.setViewName("page/index/index");
			return model;
		}else{
			model.setViewName("login");
			return model;
		}
	}
	
}
