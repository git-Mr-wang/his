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
            $.get("${path}/baseModule/baseModuleList.action",function (data) {
                $(data).each(function () {
                    $("select").append('<option value="'+this.mid+'">'+this.mname+'</option>');
                })
                $("select").val("${baseFunction.mid}")
            },"json")
        })
    </script>

</head>

<body class="main">
<h1>修改用户</h1>
<form action="${path}/baseFunction/update.action">
    <input type="hidden" name="fid" value="${baseFunction.fid}">
    <div class="update">
        <div class="left">
            <span>功能名称</span>
            <input type="text" name="fname" value="${baseFunction.fname}">
        </div>
        <div class="right">
            <span>模块名称</span>
            <select name="mid">

            </select>
        </div>
        <div class="left">
            <span>URl</span>
            <input type="text" name="url" value="${baseFunction.url}">
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
