<%--
  Created by IntelliJ IDEA.
  User: Mr.wang
  Date: 2018/11/29
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        select{
            width: 300px;
            height: 500px;
            padding: 10px;
            font-size: 14px;
        }
        select option{
            height: 30px;
            line-height: 30px;
            vertical-align: middle;
            padding-left: 10px;
            padding-top: 10px;
        }
        .title{
            display: inline-block;
             width: 48%;
            font-size: 30px;text-align: center;
            padding: 20px 0px;
        }
        #left{
            margin-left: 180px;
        }
        #right{
            margin-left: 20px;
        }
        .buttons{
            display: inline-block;height: 500px;width: 260px;
            vertical-align: top;
            text-align: center;
        }
        .buttons button{
            text-align: center;
            width: 160px;
            height: 40px;
            border-radius: 5px;
            margin-top: 50px;
        }
    </style>
    <script>
        $(function () {
            $(".buttons button:eq(0)").click(function() {
                var $left=$("#left option:selected");
                $left.remove();
                $("#right").append($left);

            });
            $(".buttons button:eq(1)").click(function() {
                var $left=$("#left option");
                $left.remove();
                $("#right").append($left);

            });

            $(".buttons button:eq(2)").click(function() {
                var $right=$("#right option:selected");
                $right.remove();
                $("#left").append($right);

            });

            $(".buttons button:eq(3)").click(function() {
                var $right=$("#right option");
                $right.remove();
                $("#left").append($right);

            });
        })
    </script>
    <script>
        $(function () {
            var url=window.location.search; //获取url中"?"符后的字符串  
            var userId=0;
            if(url.indexOf("?")!=-1){
                userId = url.substr(url.indexOf("=")+1);
            }
            $.get("${path}/baseUserRole/notIn.action",{userId:userId},function (data) {
               $(data.notIn).each(function () {
                    $("#left").append('<option value="'+this.rid+'">'+this.rname+'</option>');
               })
                $.get("${path}/baseUserRole/yes.action",{userId:userId},function (data) {
                    $(data.yes).each(function () {
                        $("#right").append('<option value="'+this.rid+'">'+this.rname+'</option>');
                    })
                },"json")
            },"json")
            $(".buttons button:eq(4)").click(function () {
                var option="";
                $("#right option").each(function () {
                    option+=$(this).val()+",";
                })
                $.get("${path}/baseUserRole/detailsUpdate.action",{uid:userId,rid:option},function (data) {
                    if (data.flag){
                        alert("提交成功")
                        window.close();
                    }else {
                        alert("未知错误")
                        window.close();
                    }
                },"json")
            })
        })
    </script>
</head>
<body class="main">
    <h1>用户详情</h1>
    <div>
        <span class="title">未拥有角色</span>
        <span class="title">已拥有角色</span>
    </div>
    <select multiple="multiple" id="left" >
        <%--<option value="1">医生</option>--%>
        <%--<option value="2">医生主任</option>--%>
        <%--<option value="3">护士</option>--%>
        <%--<option value="4">护士长</option>--%>
        <%--<option value="5">医生副主任</option>--%>
        <%--<option value="6">副护士长</option>--%>
        <%--<option value="7">药房管理员</option>--%>
    </select>
    <div class="buttons">
        <button>></button>
        <button>>></button>
        <button><</button>
        <button><<</button>
        <button>提交</button>
    </div>
    <select multiple="multiple" id="right" >
        <%--<option value="8">药房主管</option>--%>
        <%--<option value="9">副院长</option>--%>
        <%--<option value="10">院长</option>--%>
        <%--<option value="11">医务科科长</option>--%>
        <%--<option value="12">医务科科员</option>--%>
        <%--<option value="13">收费员</option>--%>
        <%--<option value="14">收费科科长</option>--%>
    </select>

</body>
</html>
