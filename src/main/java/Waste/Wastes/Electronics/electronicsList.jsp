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
    <title>电器列表</title>
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
<c:forEach items="${electronicsList }" var="ele">
    <div class="icon">
        <a href="<c:url value='/ElectronicsServlet?method=Load&eid=${ele.eid }'/>"><img class="img" src="<c:url value='/${ele.eimage }'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/ElectronicsServlet?method=Load&eid=${ele.eid }'/>">${ele.ename }</a>
    </div>
</c:forEach>

<%--

<!--家电-->
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Electronics/desc.jsp'/>"><img class="img" src="<c:url value='/img/electronics/appliance/jiadian.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Electronics/desc.jsp'/>">电器</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Electronics/desc.jsp'/>"><img class="img" src="<c:url value='/img/electronics/phone/shouji.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Electronics/desc.jsp'/>">电器</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Electronics/desc.jsp'/>"><img class="img" src="<c:url value='/img/electronics/numerical/shuma.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Electronics/desc.jsp'/>">电器</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Electronics/desc.jsp'/>"><img class="img" src="<c:url value='/img/electronics/appliance/jiadian.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Electronics/desc.jsp'/>">电器</a>
</div>
--%>

</body>
</html>
