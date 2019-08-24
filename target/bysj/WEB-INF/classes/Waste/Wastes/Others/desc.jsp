<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/5/1
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>商品详细</title>

    <style type="text/css">
        body {
            font-size: 10pt;
        }
        div {
            margin:20px;
            border: solid 2px gray;
            width: 150px;
            height: 150px;
            text-align: center;
        }
        li {
            margin: 10px;
        }
        a {
            background: url(<c:url value='/JSP/img/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -70px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }
        a:HOVER {
            background: url(<c:url value='/JSP/img/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -106px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }
        .img{
            width: 150px;
            height: 150px;
        }
    </style>
</head>

<body>
<div>
    <img class="img" src="<c:url value='/${Others.oimage}'/>" border="0"/>
</div>
<ul>
    <li>${Others.oname}</li>
    <li>单价：${Others.oprice}</li>
</ul>
<form id="form" action="<c:url value='/JSP/JSPs/cart/list.jsp'/>" method="post">
    <input type="text" size="3" name="count" value="1"/>
</form>
<a href="javascript:document.getElementById('form').submit();"></a>
</body>
</html>
