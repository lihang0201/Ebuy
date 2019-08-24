<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>易购商城提示</title>

  </head>
  
  <body>
<h1>${msg }</h1>
<ul>
<c:forEach items="${links }" var="link">
  <li>${link }</li>
</c:forEach>
</ul>
  </body>
</html>
