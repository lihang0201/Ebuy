
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>易购电子商城登陆</title>



    <link rel="stylesheet" href="style/style.css">


</head>

<body>
${msg}
<h2><font color="white">易购电子商城  用户登陆</font> </h2>
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

                    <input type="hidden" name="method" value="login"/>
                    <p><span>用户名</span><input type="text" name="username" required="" value="${form.username}"/></p> <br/>
                    <span>密码</span><input type="password" name="password" required="" value="${form.password}"/></p> <br/>
                    <span>验证码</span><input type="text" name="Vcode" required=""/><img id="img" src="<c:url value="/VerifyServlet"/>"/><br/>
                    <p><input type="submit" value="登陆"/></p>



            </fieldset>

        </form>


    </div>

</div>




</body>

</html>
