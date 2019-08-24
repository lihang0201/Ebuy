<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户中心</title>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <style>
        .middle {
            width: 100%;
            height: 50px;
            background-color: #f2f2f2;
        }

        .middleContent {
            width: 595px;
            height: 50px;
            line-height: 50px;
            text-align: center;
            color: #888;
            font-size: 16px;
        }

        .userInfo {
            width: 100%;
            height: 500px;
            background-color: #f6f6f6;
        }

        .left {
            width: 136px;
            height: 300px;
            margin-left: 242px;
            padding-top: 13px;
        }

        .left a {
            display: block;
            font-size: 14px;
            width: 63px;
            margin-bottom: 10px;
        }

        .right span {
            font-size: 14px;
            width: 79px;
            display: inline-block;
            margin-left: 10px;
            margin-top: 10px;
        }
    </style>
    <style>
        table {
            border-collapse: collapse;
            width: 70%;
        }

        tr {
            text-align: center;
            height: 100px;
            border: lightgray solid 1px;
        }

        tr.head {
            background-color: #eee;
            height: 40px;
            font-weight: bold;
            line-height: 40px;
        }

        .deleteCart {
            color: #999;
        }
    </style>
    <script>
        //假设每隔5秒发送一次请求
        window.onload = function () {
            setInterval(checkStatus, 20 * 1000);
        };
        var goon = true;

        function checkStatus() {
            //设置时间 5-秒  1000-毫秒  这里设置你自己想要的时间
            if (goon == false) {
                clearInterval(checkStatus);
                return
            }
            $.ajax({
                url: "<c:url value="/OrderServlet?method=check&oid=${requestScope.order.oid}"/>",
                success: function (result) {
                    if (result === "true") {
                        alert("支付成功!");
                        goon = false;
                    } else {
                        alert("支付失败!");
                    }
                }
            });
        }
    </script>
</head>
<body>
<div style="width: 100%;height: 2px;background-color: #C40000;"></div>

<div style="background-color: #f6f6f6;height: 500px">
    <div style="width: 1052px;margin: 0 auto;height: 395px;">
        <div style="font-size: 18px;font-weight: bold;color: #666;text-align: center;padding-top: 30px;background-color: white">
            订单提交成功，请您尽快支付！ 订单号：${requestScope.order.oid}
            <br>
            <span style="margin-top: 10px;display: inline-block;color: #c60023;margin-top: 20px">请使用支付宝扫描如下二维码进行支付：</span>
            <br>
            <img src="http://localhost:8080/code_img/${requestScope.filePath}" alt=""
                 style="border: 1px solid #ddd;width: 300px;height: 300px;margin-top: 10px">
        </div>
    </div>
</div>
</html>

