<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul class="pager border-red float-right" >
    <li><a href="${pageurl}?pageNo=1" style="padding: 1px 7px;">首页</a></li>
    
    <c:if test="${pages -1 <= 0}">
    	<li><a href="${pageurl}?pageNo=1" style="padding: 1px 7px;">上一页</a></li>
    </c:if>
    <c:if test="${pages -1 > 0}">
    	<li><a href="${pageurl}?pageNo=${pages - 1}" style="padding: 1px 7px;">上一页</a></li>
    </c:if>
    
    <c:if test="${pages + 1 >= total}">
    	<li><a href="${pageurl}?pageNo=${total}" style="padding: 1px 7px;">下一页</a></li>
    </c:if>
    <c:if test="${pages + 1 < total}">
    	<li><a href="${pageurl}?pageNo=${pages + 1}" style="padding: 1px 7px;">下一页</a></li>
    </c:if>
    
    <li><a href="${pageurl}?pageNo=${total}" style="padding: 1px 7px;">尾页</a></li>
    <li><a href="#" style="padding: 1px 7px;">共${total}页</a></li>
</ul>