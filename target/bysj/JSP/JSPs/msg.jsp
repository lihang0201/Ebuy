<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎光临</title>
    


  </head>
  
  <body>
<h1>${msg }</h1>
<ul>
  <li><a href="<c:url value='/index.jsp'/>">主页</a></li>
  <li><a href="<c:url value='/JSP/Login.jsp'/>">登陆</a></li>
  <li><a href="<c:url value='/JSP/Register.jsp'/>">注册</a></li>
</ul>
  </body>
</html>
