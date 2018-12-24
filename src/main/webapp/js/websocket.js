$(function(){
	var websocket;
	
	//是否支持websocket
	if("WebSocket" in window) {
		websocket = new WebSocket("ws://"+window.location.host+"/shushe/websocket");
	}else if("MozWebSocket" in window) {
		websocket = new WebSocket("ws://"+window.location.host+"/shushe/websocket");
	}else{
		websocket = new SockJS("http://"+window.location.host+"/shushe/sockjs/websocket");
	}
	
	websocket.onopen = function(evnt) {
        console.log("websocket.onopen");
    };
    
    websocket.onmessage = function(evnt) {
    	$("#msg").append("<p><font color='red'>" + evnt.data + "</font></p>");
        console.log("websocket.onmessage");
    };
	
    websocket.onerror = function(evnt) {
        console.log("  websocket.onerror  ");
    };
    
    websocket.onclose = function(evnt) {
        console.log("  websocket.onclose  ");
    };
    
    $("#TXBTN").click(function(){
    	var text = $("#tx").val();
    	
    	if(text == null || text == ""){
    		 alert(" content  can not empty!!");
    		 return false;
    	}
    	
    	websocket.send(text);
    	
    });
    
    
});