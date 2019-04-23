<%--
  Created by IntelliJ IDEA.
  User: Mr.wang
  Date: 2019/1/8
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css" media="screen">
        div{
            border: 1px solid;
        }
        .left{
            display:inline-block;
            width: 15%;
            height: 600px;
            text-align: center;
            position:absolute;
            /*border: 0px;*/
        }
        .right{
            display:inline-block;
            width: 79%;
            height: 600px;
            margin-left: 16%;
            position:absolute;
        }
        .right_top{
            height: 100px;
            width: 100%;
        }
        .right_middle{
            height: 300px;
            width: 100%;
        }
    </style>
    <script>
        $(function () {
            $.get("${path}/patientRegisterRecord/ajaxFindList.action",function (data) {

            },"json");
        })
    </script>
</head>
<body>
<div class="left">
    <h4>待就诊病人</h4>


</div>
    <div class="right">
        <div class="right_top">
            <%--111--%>
            <%--<h4>111</h4>--%>

        </div>
        <div class="right_middle">

        </div>
    </div>

</body>
</html>
