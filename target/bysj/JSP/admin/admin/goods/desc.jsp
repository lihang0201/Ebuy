<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品列表</title>

<style type="text/css">
	body {
		font-size: 10pt;
		background: rgb(254,238,189);
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 185px;
		height: 200px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	.img{
		width: 185px;
		height: 200px;
	}
</style>
      <script type="text/javascript">
            function setMethod(method) {
                var ele = document.getElementById("method");
                ele.value = method;
            }
      </script>
  </head>
  
  <body>
  <div>
    <img class="img" src="<c:url value='/${goods.gimage}'/>" border="0"/>
  </div>
  <form style="margin:20px;" id="form" action="<c:url value="/admin/AdminGoodsServlet"/>" method="post">
      <input type="hidden" name="method" value="" id="method"/>
      <input type="hidden" name="gid" value="${goods.gid}"/>
      <input type="hidden" name="gimage" value="${goods.gimage}"/>
  	商品名称：<input type="text" name="gname" size="60" value="${goods.gname}"/><br/>
  	单价：<input type="text" name="gprice" value="${goods.gprice}"/>元<br/>
  	分类：<select style="width: 150px; height: 20px;" name="cid">
	  <c:forEach items="${categoryList}" var="c">
		  <option value="${c.cid }" <c:if test="${c.cid eq goods.category.cid }">selected="selected"</c:if>  >${c.cname }</option>
	  </c:forEach>
    	</select><br/>
  	<input type="submit" value="删除" onclick="setMethod('delete')"/>
  	<input type="submit" value="修改" onclick="setMethod('change')"/>
  </form>
  </body>
</html>
