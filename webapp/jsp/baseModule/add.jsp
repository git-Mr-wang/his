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
    <style>
        span{
            display: inline-block;
            width: 30%;
        }
        input[type='text'],input[type='datetime']{
            margin-top: 10px;
        }
    </style>
</head>

<body class="main">
<h1>添加模块</h1>
<form action="${path}/baseModule/insert.action">
    <div class="update">
        <div class="left">
            <span>模块名称</span>
            <input type="text" name="mname">
        </div>
        <div class="right">
        </div>
        <div id="error"></div>
        <div class="buttons">
            <input type="submit" value="提交" id="submit">
            <input type="button" onclick="history.back()" value="返回">
        </div>
    </div>
</form>
</body>

</html>
