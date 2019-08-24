<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>left</title>



    <script type="text/javascript" src="<c:url value='/JSP/admin/menu/mymenu.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/JSP/admin/menu/mymenu.css'/>" type="text/css" media="all">
    <script language="javascript">
        /*
         * bar1：必须与对象名相同
           易购电子商城：大标题
         */
        var bar1 = new Q6MenuBar("bar1", "易购电子商城");

        function load() {
            /*
            设置本色方案！
            配置方案一共4种：0、1、2、3
            */
            bar1.colorStyle = 2;
            /*
            指定图片目录
            */
            bar1.config.imgDir = "<c:url value='/JSP/admin/menu/img/'/>";
            /*
            菜单之间是否相互排斥
            */
            bar1.config.radioButton = true;
            /*
            分类管理：指定要添加的菜单名称（如果这个名称的菜单已经存在，不会重复添加）
            查看分类：指定要添加的菜单项名称
	        */
            bar1.add("分类管理", "查看分类", "<c:url value='/admin/AdminCategoryServlet?method=findAll'/>", "body");
            bar1.add("分类管理", "添加分类", "<c:url value='/JSP/admin/admin/category/add.jsp'/>", "body");

            bar1.add("商品管理", "查看商品", "<c:url value='/admin/AdminGoodsServlet?method=findAll'/>", "body");
            bar1.add("商品管理", "添加商品", "<c:url value='/admin/AdminGoodsServlet?method=addPre'/>", "body");

            bar1.add("订单管理", "所有订单", "<c:url value='/admin/AdminOrderServlet?method=findAll'/>", "body");
            bar1.add("订单管理", "未付款订单", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=1'/>", "body");
            bar1.add("订单管理", "已付款订单", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=2'/>", "body");
            bar1.add("订单管理", "未收货订单", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=3'/>", "body");
            bar1.add("订单管理", "已完成订单", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=4'/>", "body");

            // 获取div元素
            var d = document.getElementById("menu");
            // 把菜单对象转换成字符串，赋给<div>元素做内容
            d.innerHTML = bar1.toString();
        }
    </script>
</head>

<body onload="load()" style="margin: 0px; background: rgb(254,238,189);">
<div id="menu"></div>

</body>
</html>
