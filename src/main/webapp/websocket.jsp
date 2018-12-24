<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>WebSocket简单使用</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" charset="utf-8" src="./js/jquery-1.7.js"></script>
	<script type="text/javascript" charset="utf-8" src="https://cdn.bootcss.com/sockjs-client/1.3.0/sockjs.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="./js/websocket.js"></script>
  </head>
  
  <body>
    <div style="margin: 20px auto; border: 1px solid blue; width: 300px; height: 500px;">
    	
    	<div id="msg" style="width: 100%; height: 70%; border: 1px solid yellow;overflow: auto;"></div>
    	
    	<textarea id="tx" style="width: 100%; height: 20%;"></textarea>
    	
    	<button id="TXBTN" style="width: 100%; height: 8%;">发送数据</button>
    </div>
  </body>
</html>
