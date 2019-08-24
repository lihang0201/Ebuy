<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车列表</title>

<style type="text/css">
	* {
		font-size: 11pt;
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
	
	#buy {
		background: url(<c:url value='/JSP/img/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/JSP/img/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
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


<c:choose>
	<%--若购物车为空，即cart为空或cartitems长度为0--%>
	<c:when test="${empty sessionScope.cart or fn:length(sessionScope.cart.cartitems) eq 0}">
		<h2>购物车空空如也，快去选购吧</h2>
		<img src="<c:url value="/JSP/img/cart.jpg"/>"/>
	</c:when>
	<c:otherwise>
		<table border="1" width="100%" cellspacing="0" background="black">
			<tr>
				<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
					<a href="<c:url value="/CartServlet?method=clear"/>">清空购物车</a>
				</td>
			</tr>
			<tr>
				<th>图片</th>
				<th>名称</th>
				<th>单价</th>
				<th>数量</th>
				<th>小计</th>
				<th>操作</th>
			</tr>

			<c:forEach items="${sessionScope.cart.cartitems}" var="cartitem">
				<tr>
					<td><div><img class="img" src="<c:url value='/${cartitem.goods.gimage}'/>"/></div></td>
					<td>${cartitem.goods.gname}</td>
					<td>单价：${cartitem.goods.gprice}元</td>
					<td>共${cartitem.count}件</td>
					<td>共${cartitem.subtotal}元</td>
					<td><a href="<c:url value="/CartServlet?method=delete&gid=${cartitem.goods.gid}"/>">删除</a></td>
				</tr>

			</c:forEach>
			<tr>
				<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
					合计：${sessionScope.cart.total}元
				</td>
			</tr>
			<tr>
				<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
					<a id="buy" href="<c:url value='/OrderServlet?method=add'/>"></a>
				</td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>

  </body>
</html>
