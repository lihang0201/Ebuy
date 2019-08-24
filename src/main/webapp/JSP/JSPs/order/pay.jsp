<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>pay.jsp</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>

    <script type="text/javascript">
        //����ÿ��5�뷢��һ������
        window.onload = function () {
            alert("aaa");
            setInterval(checkStatus, 10 * 1000);
        };
        var goon = true;

        function checkStatus() {
            //����ʱ�� 5-��  1000-����  �����������Լ���Ҫ��ʱ��
            if (goon == false) {
                clearInterval(checkStatus);
                return
            }
            $.ajax({
                url: "<c:url value="/OrderServlet?method=callBack"/>",
                data: {"orderNo": ${order.oid}},
                success: function (result) {
                    if (result.data == true) {
                        alert("֧���ɹ�!");
                        goon = false;
                    }
                }
            });
        }
    </script>
</head>

<body>
<div class="divContent">
    <span class="spanPrice">֧����</span><span class="price_t">&yen;${order.total }</span>
    <span class="spanOid">��ţ�${order.oid }</span>
</div>


<input type="hidden" name="oid" id="oid" value="${order.oid }"/>
<div class="divBank">
    <div class="divText">��ɨ��֧��${requestScope.order.total}Ԫ</div>
    <div style="margin-left: 20px;">
        <img align="top" src="<c:url value='/code_img/${requestScope.filePath}'/>" class="img_image_w"/>
    </div>
</div>
</body>
</html>
