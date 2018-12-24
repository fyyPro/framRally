package com.ssm.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.pagehelper.PagedResult;
import com.ssm.service.UserServer;

@Controller
public class UserController extends BaseController{

	private static ModelAndView model = null;
	@Resource
	private UserServer userServer;
	
	@RequestMapping("/userList")
	public ModelAndView getUserList(){
		model = new ModelAndView(); 
		List<Map<String,String>> userList = userServer.findUserList();
		model.addObject("userlist", userList);
		model.setViewName("/page/user/user_list");
		return model;
	}
	
	@RequestMapping("/userRoleList")
	public ModelAndView getUserRoleList(){
		model = new ModelAndView();
		List<Map<String,String>> userList = userServer.findUserRoleList();
		model.addObject("userlist", userList);
		model.setViewName("/page/user/user_list");
		return model;
	}
	
	@RequestMapping("/pageList")
	public ModelAndView getUserPageList(Integer pageNo){
		PagedResult<Map<String,String>> rs = userServer.queryUserList(pageNo, 1);
		JSONObject obj = responseSuccess(rs);
		
		String pages = obj.getString("pages");
		String total = obj.getString("total");
		model.addObject("pageurl","/pageList");
		model.addObject("pages", pages);
		model.addObject("total", total);
		model.addObject("userlist", obj);
		model.setViewName("/page/user/list_page");
		return model;
	}
	
	
}
