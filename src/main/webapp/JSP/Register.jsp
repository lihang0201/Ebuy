<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/4/18
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="req" value="${pageContext.request }"/>
<c:set var="base" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath }/"/>
<%--
<html>
<head>
    <base href="${base }">

    <title>注册</title>

</head>
<body>

<p style="color: red;font-weight: 900">${msg}</p>
<form action="<c:url value="/UserServlet"/>" method="post">
    <input type="hidden" name="method" value="regist"/>
    用户名：<input type="text" name="username" value="${form.username}"/>
    <span style="color:red;font-weight: 900">${error.username}</span><br/>
    密  码：<input type="password" name="password" value="${form.password}"/>
    <span style="color:red;font-weight: 900">${error.password}</span><br/>
    邮  箱：<input type="text" name="email" value="${form.email}"/>
    <span style="color:red;font-weight: 900">${error.email}</span><br/>
    <input type="submit" value="注册"/>

</form>
</body>
</html>
--%>




<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>易购电子商城注册</title>



    <link rel="stylesheet" href="style/style.css">


</head>

<body>

<h2><font color="white">易购电子商城  新用户注册</font> </h2>

<div id="clouds">
    <div class="cloud x1"></div>
    <!-- Time for multiple clouds to dance around -->
    <div class="cloud x2"></div>
    <div class="cloud x3"></div>
    <div class="cloud x4"></div>
    <div class="cloud x5"></div>
</div>

<div class="container">


    <div id="login">

        <form action="<c:url value="/UserServlet"/> " method="post">

            <fieldset class="clearfix">
                <%--<p style="color: red;font-weight: 900">${msg}</p>--%>
                <input type="hidden" name="method" value="regist"/>
                <p><span>用户名</span><input type="text" name="username" value="${form.username}"/></p> <br/>
                    <div>${error.username}</div><br/>
                <span>密码</span><input type="password" name="password" value="${form.password}"/></p> <br/>
                    <div>${error.password}</div> <br/>
                <p><span>邮箱</span><input type="text" name="email" value="${form.email}"/><br/>
                    <div>${error.email}</div><br/>
                <p><input type="submit" value="注册"/></p>

            </fieldset>

        </form>


    </div>

</div>




</body>

</html>
