<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%String path=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<form>
    请输入：<input type="text" id="inputMsg" name="inputMsg">
    <button onclick="doSend();">发送</button>
</form>
<script src="<%=path%>/static/js/jquery.min.js"></script>
<script src="<%=path%>/static/js/sockjs.min.js"></script>
<script type="text/javascript">

    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/websocket/socketServer");
    }
    else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://localhost:8080/websocket/socketServer");
    }
    else {
        websocket = new SockJS("http://localhost:8080/sockjs/socketServer");
    }
    websocket.onopen = onOpen;
    websocket.onmessage = onMessage;
    websocket.onerror = onError;
    websocket.onclose = onClose;

    function onOpen(openEvt) {
        alert("打开");
    }

    function onMessage(evt) {
        alert("接收消息");
    }
    function onError() {
        alert("错误");
    }
    function onClose() {
        alert("关闭");
    }
//在此记录一个问题，发送消息后页面会自动刷新一次，可能导致当前用户退出，null用户登入
    function doSend() {
        if (websocket.readyState == websocket.OPEN) {
            var msg = $("#inputMsg").val();
            alert(msg);
            websocket.send(msg);//调用后台handleTextMessage方法(发送消息给后台)
            alert("发送成功!消息为"+msg);
        } else {
            alert("连接失败!");
        }
    }
    window.close=function()
    {
        websocket.onclose();
    }

</script>
</body>
</html>
