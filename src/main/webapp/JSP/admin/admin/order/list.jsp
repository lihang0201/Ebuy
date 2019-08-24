<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>订单列表</title>


</head>

<body>
<p class="pLink">
	<a href="<c:url value='/admin/AdminOrderServlet?method=findByState&state=1'/>">未付款</a> |
	<a href="<c:url value='/admin/AdminOrderServlet?method=findByState&state=2'/>">已付款</a> |
	<a href="<c:url value='/admin/AdminOrderServlet?method=findByState&state=3'/>">已发货</a> |
	<a href="<c:url value='/admin/AdminOrderServlet?method=findByState&state=4'/>">交易成功</a> |
</p>
<div class="divMain">
	<div class="title">
		<div style="margin-top:7px;">
			<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
			<span style="margin-left: 40px;margin-right: 100px;">金额</span>
			<span style="margin-left: 50px;margin-right: 53px;">订单状态</span>
			<span style="margin-left: 100px;">操作</span>
		</div>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">
		<c:forEach items="${orderList }" var="order">

			<tr class="tt">
				<td width="320px">订单号：<a
						href="<c:url value='/admin/AdminOrderServlet?method=load&oid=${order.oid }'/>">${order.oid }</a>
				</td>
				<td width="200px">下单时间：${order.ordertime }</td>
				<td width="178px">&nbsp;</td>
				<td width="205px">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

			<tr style="padding-top: 10px; padding-bottom: 10px;">
				<td colspan="2">


					<c:forEach items="${order.orderItemList }" var="orderItem">
						<img border="0" width="70" src="<c:url value='/${orderItem.goods.gimage }'/>"/>
					</c:forEach>

				</td>
				<td style="padding-left: 0">
					<span class="price_t">&yen;${order.total }</span>
				</td>
				<td>
					<c:choose>
						<c:when test="${order.state eq 1 }">(等待付款)</c:when>
						<c:when test="${order.state eq 2 }">(准备发货)</c:when>
						<c:when test="${order.state eq 3 }">(等待确认)</c:when>
						<c:when test="${order.state eq 4 }">(交易成功)</c:when>
					</c:choose>
				</td>

				<td>
					<a href="<c:url value='/admin/AdminOrderServlet?method=load&oid=${order.oid }'/>">查看</a><br/>
					<c:if test="${order.state eq 1 }">
						<a href="<c:url value='/admin/AdminOrderServlet?method=cancel&oid=${order.oid }'/>">确认收货</a><br/>
					</c:if>
					<c:if test="${order.state eq 2 }">
						<a href="<c:url value='/admin/AdminOrderServlet?method=deliver&oid=${order.oid }'/>">发货</a><br/>
					</c:if>

				</td>
			</tr>
		</c:forEach>

	</table>
	<br/>

</div>
</body>
</html>
