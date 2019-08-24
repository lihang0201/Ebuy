<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    <base target="body"/>

	<style type="text/css">
		*{
			font-size:10pt;
			text-align: center;
		}
		div {
			background: #fa3346;
			margin: 3px; 
			padding: 3px;
		}
		a {
			text-decoration: none;
		}
	</style>
  </head>
  
  <body>
<div>
	<a href="<c:url value='/GoodsServlet?method=findAll'/>"><h4>随便逛逛</h4></a>
</div>

<div>
    <a href="<c:url value='/GoodsServlet?method=findByCategory&cid=1'/>">服装</a>
</div>

<div>
    <a href="<c:url value='/GoodsServlet?method=findByCategory&cid=2'/>">食品</a>
</div>

<div>
    <a href="<c:url value='/GoodsServlet?method=findByCategory&cid=3'/>">电器</a>
</div>

<div>
    <a href="<c:url value='/GoodsServlet?method=findByCategory&cid=4'/>">百货</a>
</div>

  </body>
</html>
