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
            margin: 20px;
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
    <img class="img" src="<c:url value='/${Goods.gimage}'/>" border="0"/>
</div>
<ul>
    <li>${Goods.gname}</li>
    <li>单价：${Goods.gprice}元</li>
    <li><select name="size" id="size">
        <option value="M">M</option>
        <option value="M">L</option>
        <option value="M">XL</option>
        <option value="M">XXL</option>
        <option value="M">XXXL</option>
        <option value="M">XXXXL</option>
    </select> </li>

</ul>
<form id="form" action="<c:url value='/CartServlet'/>" method="post">
    <input type="hidden" name="method" value="add">
    <input type="hidden" name="gid" value="${Goods.gid}">
    输入您要购买的数量：<input type="text" size="3" name="count" value="1"/>
</form>
<a href="javascript:document.getElementById('form').submit();"></a></br>

该商品评价：${Goods.evaluate}
</body>
</html>
