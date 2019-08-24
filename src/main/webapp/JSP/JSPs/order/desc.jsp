<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单详细</title>

<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px gray;
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#pay {
		background: url(<c:url value='/JSP/img/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -412px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#pay:HOVER {
		background: url(<c:url value='/JSP/img/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -448px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>当前订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">
	<tr bgcolor="gray" bordercolor="gray">
		<td colspan="6">
			订单编号：${order.oid}　成交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.ordertime}"/>　金额：<font color="red"><b>${order.total}元</b></font>
		</td>
	</tr>

	<c:forEach items="${order.orderItemList}" var="orderItem">
		<tr bordercolor="gray" align="center">
			<td width="15%">
				<div><img src="<c:url value='${orderItem.goods.gimage}'/>" height="75"/></div>
			</td>
			<td>商品：${orderItem.goods.gname}</td>
			<td>单价：${orderItem.goods.gprice}</td>
			<td>数量：${orderItem.count}</td>
			<td>小计：${orderItem.subtotal}</td>
		</tr>
	</c:forEach>


</table>
<br/>
<form method="post" action="javascript:alert('支付功能暂未实现');" id="form" target="_parent">
	收货地址：<input type="text" name="address" size="50" value="河南理工大学兰园五号628郦杭收"/><br/>

</form>
<a id="pay" href="<c:url value="/OrderServlet?method=pay&oid=${requestScope.order.oid}"/>"></a>

  </body>
</html>

