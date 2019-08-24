<%--
  Created by IntelliJ IDEA.
  User: lihang
  Date: 2019/5/1
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>服装列表</title>
</head>

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
<c:forEach items="${clothesList }" var="cl">
    <div class="icon">
        <a href="<c:url value='/ClothesServlet?method=Load&clid=${cl.clid }'/>"><img class="img" src="<c:url value='/${cl.climage }'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/ClothesServlet?method=Load&clid=${cl.clid }'/>">${cl.clname }</a>
    </div>
</c:forEach>


<%--
<!-- 女士服装-->
<div class="icon">
    <a href="<c:url value='/GoodsServlet?method=findClothes&clid=${}'/>"><img class="img" src="<c:url value='/img/clothes/womenclothes/girlao1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">长款女士羽绒服</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/womenclothes/girldress1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">夏日薄纱连衣裙</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/womenclothes/girlfengyi1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">女士风衣</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/womenclothes/girlmaoyi1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">短款女士毛衣</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/womenclothes/girlniuzai1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">女士牛仔裤</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/womenclothes/girlqiuyi1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">女士秋衣</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/womenclothes/girlshort1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">夏日女士白色短袖</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/womenclothes/girlshort2.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">夏日女士黑色短袖</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/womenclothes/girlweiyi1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">女士卫衣</a>
</div>



<!-- 男士服装-->
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/manclothes/manao1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">男士羽绒袄</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/manclothes/manfengyi1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">男士风衣</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/manclothes/manlong1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">男士长袖</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/manclothes/manmaoyi1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">男士毛衣</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/manclothes/manniuzai1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">男士牛仔裤</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/manclothes/manpants1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">男士七分裤</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/manclothes/manqiuyi1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">男士秋衣</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/manclothes/manshort1.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">男士白色短袖</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/manclothes/manshort2.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">男士黑色短袖</a>
</div>


<!-- 儿童服装-->
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/childrenClothes/boy1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">儿童服装</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/childrenClothes/boy2.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">儿童服装</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/childrenClothes/boy4.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">儿童服装</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/childrenClothes/boy5.jpg'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">儿童服装</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/childrenClothes/girlao1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">儿童服装</a>
</div>
<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/childrenClothes/girlshort1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">儿童服装</a>
</div>

<div class="icon">
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>"><img class="img" src="<c:url value='/img/clothes/childrenClothes/gril1.png'/>" border="0"/></a>
    <br/>
    <a href="<c:url value='/JSP/JSPs/Goods/Goods/desc.jsp'/>">儿童服装</a>
</div>




--%>

</body>
</html>
