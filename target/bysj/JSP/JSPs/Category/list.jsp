<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>随便逛逛</title>

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
  <c:forEach items="${goodsList }" var="g">
      <div class="icon">
          <a href="<c:url value='/GoodsServlet?method=findAll&gid=${g.gid }'/>"><img class="img" src="<c:url value='/${g.gimage }'/>" border="0"/></a>
          <br/>
          <a href="<c:url value='/GoodsServlet?method=findAll&gid=${g.gid }'/>">${g.gname }</a>
      </div>
  </c:forEach>


  </body>
 
</html>

