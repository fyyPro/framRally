<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>宿舍管理中心</title>
	<link rel="shortcut icon" href="../../images/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="../../css/pintuer.css">
	<link rel="stylesheet" type="text/css" href="../../css/admin.css">
	<script type="text/javascript" charset="utf-8" src="../../js/jquery-1.7.js"></script>
  </head>
  
  <body style="background-color:#f2f9fd;">
  	<div class="header bg-main">
  		<div class="logo margin-big-left fadein-top">
  			<h1>
  				<img src="../../images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />
  				宿舍管理中心
  			</h1>
  		</div>
  		<div class="head-l">
  		</div>
  	</div>
  	
  	<div class="leftnav">
  		<div class="leftnav-title">
  			<strong><span class="icon-list"></span>菜单列表</strong>
  		</div>
  		<h2><span class="icon-user"></span>基本设置</h2>
  		<ul style="display:block">
  			<li><a href="/userList" target="right"><span class="icon-caret-right"></span>用户列表</a></li>
  			<li><a href="/pageList" target="right"><span class="icon-caret-right"></span>用户列表</a></li>
  		</ul>
  		<h2><span class="icon-file-o"></span>文件管理</h2>
  		<ul>
  			<li><a href="/file/file1" target="right"><span class="icon-caret-right"></span>单文件上传</a></li>
  			<li><a href="/file/file2" target="right"><span class="icon-caret-right"></span>多文件上传</a></li>
  			<li><a href="/file/filelist" target="right"><span class="icon-caret-right"></span>文件下载</a></li>
  		</ul>
  	</div>
  	
  	<ul class="bread">
  		<li><a href="##" id="a_leader_txt" class="icon-home">&nbsp;网站信息</a></li>
  	</ul>
  	
  	<div class="admin">
  		<iframe src="/userList" name="right" width="100%" height="100%"></iframe>
  	</div>
  	
  	<script type="text/javascript">
	  	$(function(){
	  	  $(".leftnav h2").click(function(){
	  		  $(this).next().slideToggle(200);	
	  		  $(this).toggleClass("on"); 
	  	  });
	  	  $(".leftnav ul li a").click(function(){
	  		    $("#a_leader_txt").text($(this).text());
	  	  		$(".leftnav ul li a").removeClass("on");
	  			$(this).addClass("on");
	  	  });
	  	});
  	</script>
  </body>
</html>
