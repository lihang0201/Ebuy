<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加商品</title>


    <style type="text/css">
        body {
            background: rgb(254, 238, 189);
        }
    </style>
</head>

<body>
<h1>添加商品</h1>
<p style="font-weight: 900; color: red">${msg }</p>
<form action="<c:url value="/admin/AdminAddGoodsServlet"/>" method="post" enctype="multipart/form-data">
    商品名称：<input style="width: 150px; height: 20px;" type="text" name="gname"/><br/>
    图片：<input style="width: 223px; height: 20px;" type="file" name="gimage"/><br/>
    单价：<input style="width: 150px; height: 20px;" type="text" name="gprice"/><br/>
    分类：
    <select name="cid" style="width: 150px; height: 20px;" >
        <c:forEach items="${categoryList}" var="c">
            <option value="${c.cid}">${c.cname}</option>
        </c:forEach>
    </select>
    <br/>
    <input type="submit" value="添加商品"/>
</form>
</body>
</html>
