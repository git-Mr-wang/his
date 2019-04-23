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
            $("select[name='sex']").val("${baseUser.sex}");
            $.get("${path}/baseDept/ajaxList.action",function (data) {
                $(data).each(function () {
                    $("#deptId").append('<option value="'+this.deptId+'">'+this.deptName+'</option>');
                })
                $("#deptId").val("${baseUser.baseDept.deptId}");
            },"json")
        })
    </script>

</head>

<body class="main">
<h1>修改用户</h1>
<form action="${path}/baseUser/update.action">
    <input type="hidden" name="userId" value="${baseUser.userId}">
    <div class="update">
        <div class="left">
            <span>用户名</span>
            <input type="text" name="userName" value="${baseUser.userName}">
        </div>
        <div class="right">
            <span>密码</span>
            <input type="text" name="password" value="${baseUser.password}">
        </div>
        <div class="left">
            <span>姓名</span>
            <input type="text" name="cname" value="${baseUser.cname}">
        </div>
        <div class="right">
            <span>性别</span>
            <select name="sex" style="background-color: #00EC00;color: #EFFFD7">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
            <%--<input type="text" name="sex" value="${baseUser.sex}">--%>
        </div>
        <div class="left">
            <span>部门</span>
            <select name="deptId" id="deptId">

            </select>
            <%--<input type="text" name="cname" value="${baseUser.cname}">--%>
        </div>
        <div class="right">
            <span>岗位</span>
            <%--<input type="text" name="cname" value="${baseUser.cname}">--%>
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
