<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>删除分类</title>

<style type="text/css">
	body {background: rgb(254,238,189);}
</style>
  </head>
  
  <body>
    <h1>删除分类</h1>
    <form action="<c:url value="/admin/AdminCategoryServlet"/>" method="post">
    	<input type="hidden" name="method" value="delete" />
    	分类名称：<input type="text" name="cid" value="${category.cid}" disabled="disabled"/>
    	<input type="submit" value="删除分类"/>
    </form>
  </body>
</html>
