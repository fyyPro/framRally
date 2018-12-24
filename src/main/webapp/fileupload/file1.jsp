<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<title>单文件上传</title>
  </head>
  
  <body>
    <div style="margin: 0px auto;width: 100%;">
    	<form action="/file/fileupload1" method="post" enctype="multipart/form-data">
    		<input type="file" name="file" />
    		<input type="submit" value="上传" />
    	</form>
    </div>
    <div>
    	<span>回显结果</span><br>
    	<img src="${filepath}">
    </div>
  </body>
</html>
