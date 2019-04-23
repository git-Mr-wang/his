<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/3 0003
  Time: 15:20
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
    <script>
        $(function () {
            $("#oldPassword").blur(function () {
                var oldPassword= $(this).val();
                $.get("${path}/baseUser/findByPassword.action",{password:oldPassword,UserId:"${baseUserLogin.userId}"},function (data) {
                    if (data=='Y'){
                        $("#oldPasswordError").html("");
                    } else {
                        $("#oldPasswordError").html("您输入的旧密码有误").css("color","red");
                    }
                })
            })
            $("#repeatPassword").blur(function () {
                if ($(this).val()!=$("#password").val()){
                    $("#repeatPasswordError").html("两次密码不一致").css("color","red");
                }else {
                    $("#repeatPasswordError").html("");
                }
            })
            $("#submit").click(function () {
                var oldPassword = $("#oldPassword").val();
                var oldPasswordError = $("#oldPasswordError").html();
                var repeatPassword = $("#repeatPassword").val();
                var repeatPasswordError = $("#repeatPasswordError").html();
                if (oldPassword==""||repeatPassword==""||oldPasswordError!=""||repeatPasswordError!=""){
                    alert("您输入的内容未通过验证");
                } else {
                    $.get("${path}/baseUser/updatePassword.action",{password:repeatPassword,userId:"${baseUserLogin.userId}"},function (data) {
                        if (data=="Y"){
                            alert("密码修改成功");
                            window.close();
                            window.opener.location.href="${path}/jsp/index/login.jsp";
                        } else {
                            alert("不可能");
                        }

                    })
                }
            })
        })
    </script>
</head>

<body class="main">
    <h1>修改密码</h1>
    <%--<form action="${path}/baseUser/updatePassword.action">--%>
        <div class="update">
            <div class="left">
                <span>请输入旧密码</span>
                <input type="text" id="oldPassword">
            </div>
            <div class="right" id="oldPasswordError">
            </div>
            <div class="left">
                <span>新密码</span>
                <input type="password" name="password" id="password">
            </div>
            <div class="right"></div>
            <div class="left">
                <span>确认密码</span>
                <input type="password" id="repeatPassword">
            </div>
            <div class="right" id="repeatPasswordError">
            </div>
            <div class="buttons">
                <input type="submit" value="提交" id="submit">
                <input type="button" onclick="history.back()" value="返回">
            </div>
        </div>
</body>

</html>
