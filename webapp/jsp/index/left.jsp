<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/29 0029
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <script>
        <%
              String mid = request.getParameter("mid");
              request.setAttribute("mid",mid);
         %>
    </script>
    <script type="text/javascript">
        $(function () {
            <%--$("li").click(function () {--%>
                <%--window.parent.mainFrame.location.href = "${path}/baseUser/list.action";--%>
            <%--})--%>

            $.get("${path}/baseFunction/baseFunctionList.action",{mid:"${mid}"},function (data) {
                var left_nav=$(".left_nav");
                $(data).each(function () {
                    left_nav.append('<li name="'+this.url+'">'+this.fname+'</li>');
                })
                $("li").click(function () {
                    $("li").css("background","#ec3f41");
                    $(this).css("background","#bfbf2b");
                    window.parent.mainFrame.location.href = "${path}"+$(this).attr("name");
                })
            },"json")
        })
    </script>
</head>
<body class="left">
<div class="page">
    <div class="margin_div">
        <div class="page_main">
            <ul class="left_nav">
                <%--<li name="/baseUser/list.action">用户管理</li>--%>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
