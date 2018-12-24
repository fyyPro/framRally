<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
    <title>宿舍管理中心</title>
	<link rel="stylesheet" type="text/css" href="../../css/pintuer.css">
	<link rel="stylesheet" type="text/css" href="../../css/admin.css">
	<script type="text/javascript" charset="utf-8" src="../../js/jquery-1.7.js"></script>
	<script type="text/javascript" charset="utf-8" src="../../js/pintuer.js"></script>
  </head>
  
  <body>
    <div class="panel admin-panel">
    	<div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    	<table class="table table-hover text-center">
    		<tr>
		      <th width="5%">ID</th>
		      <th width="20%">用户名</th>
		      <th width="15%">用户权限</th>
		      <th width="15%">联系方式</th>
		      <th width="20%">住址</th>
		      <th width="10%">紧急电话</th>
		      <th width="15%">入库时间</th>
		    </tr>
		    <c:forEach begin="0" items="${userlist.dataList}" var="user" varStatus="vs">
		    <tr>
		    	<td>${vs.index+1}</td>
		    	<td>${user.name}</td>
		    	<td>
			    	<c:if test="${user.rolename != ''}">
			    		${user.rolename}
			    	</c:if>
		    	</td>
		    	<td>${user.phone}</td>
		    	<td>${user.adrr}</td>
		    	<td>${user.yjphone}</td>
		    	<td>
		    		${user.intime}
		    	</td>
		    </tr>
		    </c:forEach>
		    <tr>
		    	<td colspan="7" style="text-align: right;">
		    		<jsp:include page="../page.jsp"></jsp:include>
		    	</td>
		    </tr>
    	</table>
    </div>
  </body>
</html>
