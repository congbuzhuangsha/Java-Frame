<%--
  Created by IntelliJ IDEA.
  User: yangxiaojie
  Date: 2020/3/8
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'MyJsp.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body>
<h3>入门程序</h3>
<%--<a href="hello">入门程序</a>--%>
<a href="userInfo/hello?username=1">RequestMapping注解</a><br/>

<form action="/userInfo/submit" method="post">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    用户名称：<input type="text" name="userInfo.uname"/><br/>
    用户年龄：<input type="text" name="userInfo.age"/><br/>
    用户日期：<input type="text" name="userInfo.date"/><br/>

    <%--用户名称：<input type="text" name="list[0].uname"/>
    用户年龄：<input type="text" name="list[0].age"/>
    用户名称：<input type="text" name="list[1].uname"/>
    用户年龄：<input type="text" name="list[1].age"/>

    用户名称：<input type="text" name="map[one].uname"/>
    用户年龄：<input type="text" name="map[one].age"/>
    用户名称：<input type="text" name="map[two].uname"/>
    用户年龄：<input type="text" name="map[two].age"/>--%>
    <input type="submit" value="提交"/><br/>
</form>
<a href="userInfo/testServlet">Servlet原生API</a><br/>
<%--*************************常用注解******************************************--%>
<a href="userInfo/requestParamTest?name=1">RequestParam注解</a><br/>
<form action="userInfo/requestBodyTest" method="post">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    <input type="submit" value="提交"/><br/>
</form>
<a href="userInfo/pathVariableTest/10">PathVariableTest注解</a><br/>
<form action="/userInfo/modelAttributeTest" method="post">
    用户名称：<input type="text" name="uname"/><br/>
    用户年龄：<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/><br/>
</form>
<a href="userInfo/sessionAttributes">sessionAttributesTest注解</a><br/>
</body>
</html>
