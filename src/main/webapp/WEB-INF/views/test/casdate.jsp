<%--
  Created by IntelliJ IDEA.
  User: Zachary
  Date: 2018/9/20
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path=request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/lay1/layui/css/layui.css"/>
    <style>body{padding:20px;}</style>
</head>
<body>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item"></div>
    <div class="layui-form-item test-region"></div>
    <div class="layui-form-item test-region1"></div>
    <div class="layui-form-item test-region2"></div>
    <div class="layui-form-item test-region3"></div>
</form>

<script type="text/javascript" src="<%=path%>/static/lay1/layui/layui.js"></script>
<script type="text/javascript">
    var data='${list}';
    layui.config({
        base: '<%=path%>/static/lay1/js/',
    })
    layui.use(['interact'],function(){
        var interact = layui.interact;
        alert(data);
        interact.render({
            elem : '.test-region',
            title : '选择联动',
            data : data,
            name : 'region',
        });
        alert("============================");
        interact.render({
            elem : '.test-region1',
            title : '选择省市区',
            data : data,
            name : 'region1',
            hint : ['请选择省份','请选择城市','请选择县/区'],
        });
        alert("============================");
        interact.render({
            elem : '.test-region2',
            title : '选择联动',
            data : data,
            name : 'region1',
            hint : ['第一级','第二级','第三级'],
        });
        alert("============================");
        interact.render({
            elem : '.test-region3',
            title : '选择联动',
            data : data,
            name : 'region1',
            selected : [1,4,11],
            hint : ['第一级','第二级','第三级'],
        });
        alert("============================");
    })
</script>
</body>
</html>
