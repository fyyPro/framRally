<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<title>单文件上传</title>
	<link rel="stylesheet" type="text/css" href="../../css/pintuer.css">
	<script type="text/javascript" charset="utf-8" src="../../js/jquery-1.7.js"></script>
	<script type="text/javascript" charset="utf-8" src="../../js/pintuer.js"></script>
  </head>
  
  <body>
    <div style="margin: 0px auto;width: 100%;">
    	<form action="/file/fileupload2" method="post" enctype="multipart/form-data">
    		<input type="file" name="file" /><br>
    		<input type="file" name="file" /><br>
    		<input type="file" name="file" /><br>
    		<input type="submit" value="上传" />
    	</form>
    </div>
    <div>
    	<span>回显结果</span><br>
    	
    	<div class="banner">
    		<div class="carousel">
    			<c:forEach begin="0" items="${filelist}" var="list">
    			<div class="item">
    				<img src="${list}">
    			</div>
    			</c:forEach>
    		</div>
    	</div>
    </div>
  </body>
</html>
