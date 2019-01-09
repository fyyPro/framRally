<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="utf-8">
    <title>宿舍管理系统登录界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<link rel="stylesheet" type="text/css" href="./css/reset.css">
  </head>
  
  <body>
    <div id="particles-js">
    	<div class="login">
    		<form id="fromSub" action="/login" method="post">
	    		<div class="login-top">
	    			登录
	    		</div>
	    		<div class="login-center clearfix">
	    			<div class="login-center-img"><img src="./img/name.png"/></div>
	    			<div class="login-center-input">
	    				<input type="text" name="username" value="username" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
	    				<div class="login-center-input-text">用户名</div>
	    			</div>
	    		</div>
	    		<div class="login-center clearfix">
	    			<div class="login-center-img"><img src="./img/password.png"/></div>
	    			<div class="login-center-input">
	    				<input type="password" name="password" value="password" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
	    				<div class="login-center-input-text">密码</div>
	    			</div>
	    		</div>
	    		<div class="login-button">
	    			登录
	    		</div>
    		</form>
    	</div>
    	<div class="sk-rotating-plane"></div>
    </div>
    
    <script type="text/javascript" charset="utf-8" src="./js/jquery-1.7.js"></script>
    <script type="text/javascript" charset="utf-8" src="./js/particles.js"></script>
    <script type="text/javascript" charset="utf-8" src="./js/app.js"></script>
    <script type="text/javascript">
	    document.querySelector(".login-button").onclick = function(){
			addClass(document.querySelector(".login"), "active");
			setTimeout(function(){
				addClass(document.querySelector(".sk-rotating-plane"), "active");
				document.querySelector(".login").style.display = "none";
			},800);
			//登录请求
			$("#fromSub").submit();
		};
    </script>
  </body>
</html>
