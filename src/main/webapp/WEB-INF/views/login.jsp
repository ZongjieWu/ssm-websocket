<%--
  Created by IntelliJ IDEA.
  User: Zachary
  Date: 2018/10/16
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%String path=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Hello World!</h2>
<body>
<!-- ship是我的项目名-->
<form action="<%=path%>/login">
    登录名：<input type="text" id="username" name="username"/>
    <input type="submit" value="登录"/>
</form>
</body>
</body>
</html>
