<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/5/5
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>订单详细</title>

</head>

<body>
<div class="divOrder">
		<span>订单号：${order.oid }
<c:choose>
    <c:when test="${order.state eq 1 }">(等待付款)</c:when>
    <c:when test="${order.state eq 2 }">(准备发货)</c:when>
    <c:when test="${order.state eq 3 }">(等待确认)</c:when>
    <c:when test="${order.state eq 4 }">(交易成功)</c:when>
</c:choose>
		　　　下单时间：${order.ordertime }
		</span>
</div>
<div class="divRow">
    <div class="divContent">
        <dl>
            <dt>收货人地址</dt>
            <dd>${order.address }</dd>
        </dl>
    </div>
    <div class="divContent">
        <dl>
            <dt>商品清单</dt>
            <dd>
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th class="tt">商品名称</th>
                        <th class="tt" align="left">单价</th>
                        <th class="tt" align="left">数量</th>
                        <th class="tt" align="left">小计</th>
                    </tr>


                    <c:forEach items="${order.orderItemList }" var="orderItem">
                        <tr style="padding-top: 20px; padding-bottom: 20px;">
                            <td class="td" width="400px">
                                <div class="bookname">
                                    <img align="middle" width="70" src="<c:url value='/${orderItem.goods.gimage }'/>"/>
                                        ${orderItem.goods.gname }
                                </div>
                            </td>
                            <td class="td">
                                <span>&yen;${orderItem.goods.gprice }</span>
                            </td>
                            <td class="td">
                                <span>${orderItem.count }</span>
                            </td>
                            <td class="td">
                                <span>&yen;${orderItem.subtotal }</span>
                            </td>
                        </tr>
                    </c:forEach>


                </table>
            </dd>
        </dl>
    </div>
    <div class="divBtn">
        <span class="spanTotal">合　　计：</span>
        <span class="price_t">&yen;${order.total }</span><br/>


            <a id="deliver" href="<c:url value='/admin/AdminOrderServlet?method=deliver&oid=${order.oid }'/>">发　　货</a>


            <a id="cancel" href="<c:url value='/admin/AdminOrderServlet?method=cancel&oid=${order.oid }'/>">取　　消</a>

    </div>
</div>
</body>
</html>

