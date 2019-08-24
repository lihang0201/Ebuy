
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <title>top</title>


    <style>
        body{
            font-size: 12px;
            font-family: Arial;
        }
        a{
            color:#999;
        }
        .redColor{
            color: #C40000 !important;
        }
        nav.top{
            background-color: #f2f2f2;
            padding-top: 5px;
            padding-bottom: 5px;
            border-bottom:1px solid  #e7e7e7;
        }
        nav.top span, nav.top a{
            color: #999;
            margin: 0px 10px 0px 10px;
        }
        nav.top a:hover{
            color: #C40000;
            text-decoration: none;
        }
    </style>
</head>

<body>
<h1 style="text-align: center;">易购电子商城</h1>

<c:choose>
    <c:when test="${empty sessionScope.session_user }">
        <nav class="top ">
            <a href="<c:url value='All.jsp'/>">
                <span class="glyphicon glyphicon-home redColor"></span>
                易购首页
            </a>

            <span>欢迎来到易购商城</span>
            <a href="<c:url value='/JSP/Login.jsp'/>">请登录</a>
            <a href="<c:url value='/JSP/Register.jsp'/>">免费注册</a>

        </nav>
        <%--

                    <a href="<c:url value='/JSP/Login.jsp'/>" target="_parent">登录</a> |&nbsp;
                    <a href="<c:url value='/JSP/Register.jsp'/>" target="_parent">注册</a>--%>
    </c:when>
    <c:otherwise>
        <nav class="top ">
				<span class="pull-right">
					您好：${sessionScope.session_user.username }
					<a href="<c:url value='/OrderServlet?method=myOrders'/>">我的订单</a>
					<a href="<c:url value='/JSP/JSPs/cart/list.jsp'/>">
					<span class=" glyphicon glyphicon-shopping-cart redColor" ></span>
					购物车</a>
				</span>
        </nav>
        <%--
                    &nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="<c:url value='/JSP/JSPs/cart/list.jsp'/>" target="body">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="<c:url value='/OrderServlet?method=myOrders'/>" target="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">退出</a>--%>
    </c:otherwise>
</c:choose>
<div class="homepageDiv">
<div class="categoryWithCarouse">
    <div class="head " style="margin-left: 162.5px;">

        <span style="margin-left:10px" class="glyphicon glyphicon-th-list"></span>
        <span style="margin-left:10px">商品分类</span>

    </div>
    <div style="position: relative">


        <div class="categoryMenu" style="left: 142.5px;">
            <c:forEach items="${categoryList}" var="c">
                <div cid=${c.cid} class="eachCategory" style="background-color: rgb(226, 226, 227);">
                    <span class="glyphicon glyphicon-link"></span>
                    <a href="/CategoryServlet?method=findBycid&cid=1" style="color: rgb(0, 0, 0);">
                        ${c.cname}
                    </a>
                </div>
            </c:forEach>


        </div>
    </div>
</div>


</div>

</body>
</html>
