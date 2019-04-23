<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    
    <title>登录</title>
    <link  href="${path}/css/index.css" rel="stylesheet">
    <script type="text/javascript">
        $(function () {
            $(document).attr("title","登录");

            $("#login").click(function () {
                var username = $("#username").val();
                var password = $("#password").val();
                if(!username){
                    $("#error").html("用户名不能为空!");
                    return false;
                }
                if(!password){
                    $("#error").html("密码不能为空!");
                    return false;
                }
                location.href="${path}/baseUser/login.action?userName="+username+"&password="+password;
            })
            $("body").keydown(function (a) {
                if (a.keyCode==13){
                    var username = $("#username").val();
                    var password = $("#password").val();
                    if(!username){
                        $("#error").html("用户名不能为空!");
                        return false;
                    }
                    if(!password){
                        $("#error").html("密码不能为空!");
                        return false;
                    }
                    location.href="${path}/baseUser/login.action?userName="+username+"&password="+password;
                }

            })

        })
    </script>
</head>

<body>
<div class="login">
    <!--图片 -->
    <div class="photo"></div>
    <span>用户登录</span>
    <div class="form">
        <div class="content">
            <span>用户名：</span>
            <input type="text" id="username" value="">
        </div>
        <div class="content">
            <span>密码：</span>
            <input type="password" id="password" value="">
        </div>
        <!--错误提示 -->
        <div id="error">${error}</div>
        <!-- 按钮-->
        <div class="btn">
            <button id="login">登录</button>
        </div>
    </div>
</div>
</body>
</html>
