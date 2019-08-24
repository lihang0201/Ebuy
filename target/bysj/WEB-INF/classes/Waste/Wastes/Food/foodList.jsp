<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/5/1
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>食品列表</title>
</head>

<style type="text/css">
    body {
        font-size: 10pt;
    }
    .icon {
        margin:10px;
        border: solid 2px gray;
        width: 185px;
        height: 250px;
        text-align: center;
        float: left;
    }
    .img{
        width: 185px;
        height: 200px;
    }
</style>
</head>

<body>
<c:forEach items="${foodList }" var="f">
    <div class="icon">
        <a href="<c:url value='/FoodServlet?method=Load&fid=${f.fid }'/>"><img class="img" src="<c:url value='/${f.fimage }'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/FoodServlet?method=Load&fid=${f.fid }'/>">${f.fname }</a>
    </div>
</c:forEach>



<%--

<!--食品-->
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Food/desc.jsp'/>"><img class="img" src="<c:url value='/img/food/fresh/meishi2.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Food/desc.jsp'/>">生鲜</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Food/desc.jsp'/>"><img class="img" src="<c:url value='/img/food/cate/meihsi3.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Food/desc.jsp'/>">美食</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Food/desc.jsp'/>"><img class="img" src="<c:url value='/img/food/snacks/meishi.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Food/desc.jsp'/>">零食</a>
</div>
--%>

</body>
</html>