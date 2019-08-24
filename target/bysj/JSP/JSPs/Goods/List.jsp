<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/5/1
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
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
<c:forEach items="${goodsList }" var="go">
    <div class="icon">
        <a href="<c:url value='/GoodsServlet?method=Load&gid=${go.gid }'/>"><img class="img" src="<c:url value='/${go.gimage }'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/GoodsServlet?method=Load&gid=${go.gid }'/>">${go.gname }</a>
    </div>
</c:forEach>





</body>
</html>
