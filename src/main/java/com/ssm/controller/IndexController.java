package com.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
		if(user != null){
			request.getSession().setAttribute("user", user);
			model.setViewName("page/index/index");
			return model;
		}else{
			model.addObject("message","用户名、密码错误");
			model.setViewName("login");
			return model;
		}
	}
	
}
