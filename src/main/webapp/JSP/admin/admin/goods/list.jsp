<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品分类</title>
    

<style type="text/css">
	body {
		font-size: 10pt;
		background: rgb(254,238,189);
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 200px;
		height: 250px;
		text-align: center;
		float: left;
	}
    .img{
        width: 185px;
        height: 190px;
    }
</style>
  </head>
  
  <body>
  <c:forEach items="${goodsList}" var="goods">
       <div class="icon">
        <a href="<c:url value='/admin/AdminGoodsServlet?method=load&gid=${goods.gid}'/>"><img class="img" src="<c:url value='/${goods.gimage}'/>" border="0"/></a>
          <br/>
        <a href="<c:url value='/admin/AdminGoodsServlet?method=load&gid=${goods.gid}'/>">${goods.gname}</a>
       </div>
  </c:forEach>
  </body>
 
</html>

