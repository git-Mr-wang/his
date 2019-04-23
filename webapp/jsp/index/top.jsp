
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
    <script type="text/javascript">
        $(function () {
            //baseModule表遍历
            $.get("${path}/baseModule/baseModuleList.action",{},function (data) {
                var nav = $(".nav");
                $(data).each(function () {
                    nav.append('<a href="#" target="_self"><span class=STYLE2 name="'+this.mid+'">'+this.mname+'</span></a>');
                })
                $(".nav span").click(function () {
                    $(".nav span").css("background","#bf0007");
                    $(this).css("background","#390019");
                    window.parent.leftFrame.location.href
                        ="${path}/jsp/index/left.jsp?mid="+$(this).attr("name");
                        <%--= "${path}/baseFunction/findByMid.action?mid="+$(this).attr("name");--%>
                })
            },"json")

            //退出
            $("#remove").click(function () {
                window.parent.location.href="${path}/baseUser/removeSession.action";
            })

            //修改密码
            $("#changePassword").click(function () {
                window.parent.open('${path}/jsp/baseUser/changePassword.jsp', "修改密码", 'height=300, width=800, top=150, left=350')
            })
        })

        //js实时北京12小时时间，秒级
        function showtime() {
            var date = new Date();
            year=date.getFullYear();
            month=date.getMonth()+1;
            dates= date.getDate();
            $("#s1").html(year+"年"+month+"月"+dates+"日     "+date.toLocaleTimeString());
        }
        setInterval("showtime()",1000);
    </script>
</head>

<body>
<div class="page">
        <div class="nav">
                <%--<a href="#"  target="_self"><SPAN class=STYLE2>收费管理</SPAN></a>--%>
        </div>
</div>
<div class="userInfo">
    <span id="baseUserName">${baseUserLogin.cname}</span>  <span id="s1"></span>
    <a href="#" id="changePassword">修改密码</a>
    <a href="#" id="remove">退出</a>
</div>

</body>

</html>
