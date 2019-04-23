<%--
  Created by IntelliJ IDEA.
  User: Mr.wang
  Date: 2018/11/26
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
    <script>
        $(function () {

        })
    </script>

</head>

<body class="main">
<h1>修改用户</h1>
<form action="${path}/baseRole/update.action">
    <input type="hidden" name="rid" value="${baseRole.rid}">
    <div class="update">
        <div class="left">
            <span>角色名称</span>
            <input type="text" name="rname" value="${baseRole.rname}">
        </div>
        <div class="right">

        </div>
        <div id="error"></div>
        <div class="buttons">
            <input type="submit" value="提交">
            <input type="button" onclick="history.back()" value="返回">
        </div>
    </div>
</form>
</body>

</html>
