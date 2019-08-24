<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/5/13
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>管理员登录</title>


</head>

<body>
<h1>登录</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/admin/AdminServlet?method=login'/>" method="post">
    用户名：<input type="text" name="aname"/><br/>
    密　码：<input type="password" name="apassword"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
