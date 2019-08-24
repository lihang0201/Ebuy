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
    <title>百货列表</title>
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
<c:forEach items="${othersList }" var="o">
    <div class="icon">
        <a href="<c:url value='/OthersServlet?method=Load&fid=${o.oid }'/>"><img class="img" src="<c:url value='/${o.oimage }'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/OthersServlet?method=Load&oid=${o.oid }'/>">${f.fname }</a>
    </div>
</c:forEach>


<%--

<!--其他杂类-->
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Others/desc.jsp'/>"><img class="img" src="<c:url value='/img/others/furniture/jiaju.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Others/desc.jsp'/>">家具</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Others/desc.jsp'/>"><img class="img" src="<c:url value='/img/others/department/baihuo.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Others/desc.jsp'/>">百货</a>
</div>
--%>

</body>
</html>
