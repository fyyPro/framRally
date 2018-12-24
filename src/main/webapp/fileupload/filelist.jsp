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
    	<c:forEach items="${filelist}" var="map">
    		<c:url value="/file/fileDown" var="downFile">
    			<c:param name="filename" value="${map.key}" />
    		</c:url>
    		${map.value}&nbsp;&nbsp;
    		<a href="${downFile}" style="text-decoration: none;">下载</a>
    		<br>
    	</c:forEach>
    </div>
  </body>
</html>
