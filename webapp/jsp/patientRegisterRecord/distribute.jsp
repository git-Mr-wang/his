<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/29 0029
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>下拉框</title>
    <style type="text/css">
        body{
            background-color: #A6FFA6;
        }
        select{
            width: 300px;
            height: 450px;
            padding: 10px;
            font-size: 14px;
            background-color: #bfbf2b;color: white;
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
            width: 45%;
            font-size: 30px;text-align: center;
            padding: 20px 0px;
        }
        #left{
            margin-left: 100px;
        }
        #right{
            margin-left: 20px;
        }
        .buttons{
            display: inline-block;height: 450px;width: 260px;
            vertical-align: top;
            text-align: center;
        }
        .buttons button{
            text-align: center;
            width: 160px;
            height: 40px;
            border-radius: 5px;
            margin-top: 50px;
            background-color: #00EC00;color: white;border: 0px;
        }
        .search{
            height: 50px;
            /*border: 1px solid #ff5700;*/
            text-align: center;
            margin-left: -100px;
        }
        .search button{
            width: 50px;
            height: 30px;
            border-radius: 5px;
            background-color: #00EC00;border: 0px;
        }
        #result{
            margin-left: 100px;
            color: #ec0031;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            var patientId="";
            $(".buttons button:eq(0)").click(function(){
                var $selected = $("#left option:selected");
                $selected.remove();
                var $right = $("#right");
                $selected.appendTo($right);
            })
            $(".buttons button:eq(1)").click(function(){
                var $selected = $("#left option");
                $selected.remove();
                var $right = $("#right");
                $selected.appendTo($right);
            })
            $(".buttons button:eq(2)").click(function(){
                var $selected = $("#right option:selected");
                $selected.remove();
                var $left = $("#left");
                $selected.appendTo($left);
            })
            $(".buttons button:eq(3)").click(function(){
                var $selected = $("#right option");
                $selected.remove();
                var $left = $("#left");
                $selected.appendTo($left);
            })
            $(".buttons button:eq(4)").click(function(){
                var result = $("#result").html();
                if (result=='查无此人,不可挂号'||result==''){
                    alert("请正确操作就诊卡信息");
                }else {
                    var left = $("#left").val();
                    var rigtht = $("#right").val();
                    if (left==''||rigtht==''){
                        alert("请选择科室和相应的医生");
                    }else {
                        $.get("${path}/patientRegisterRecord/insert.action?deptId="+left+"&userId="+rigtht+"&patientId="+patientId,function (data) {
                            if (data==true){
                                alert("挂号成功！！！");
                                $("#patientName").val("");
                                $("#personid").val("");
                                $("#right").html("");
                            }
                        },"json")
                    }
                }
                var url = "${path}/baseRole/distributeUpdate.action?rid=${rid}";
                $("#right option").each(function () {
                    url+="&fid="+$(this).val();
                })
                // alert(url);
                // location.href=url;
            })
            $(".search button").click(function () {
                var val = $("#patientName").val();
                var val1 = $("#personid").val();
                $.get("${path}/basePatientInfo/ajaxSearch.action",{patientName:val,personid:val1},function (data) {
                    if (data==null){
                        $("#result").html("查无此人,不可挂号");
                    } else {
                        patientId=data.patientId;
                        $("#result").html("就诊卡信息    姓名:"+data.patientName+",        " +
                            "出生日期:"+data.birth+",       性别:"+data.sex+",        家庭住址:"
                            +data.address+",        电话号码:"+data.phonenum+"      身份证号:"+data.personid);
                    }
                },"json")
            })
            $.get("${path}/baseDept/ajaxList.action",function (data) {
                $(data).each(function () {
                    $("#left").append('<option value="'+this.deptId+'">'+this.deptName+'</option>');
                })
            },"json")
            $("#left").dblclick(function () {
                var option = $(this).val();
                // alert(option)
                $.get("${path}/baseUser/ajaxSearch.action?deptId="+option,function (data) {
                    $("#right").html("");
                    $(data).each(function () {
                        $("#right").append('<option value="'+this.userId+'">'+this.cname+'</option>');
                        // alert(this.userName);
                    })
                },"json")
            })
        })

    </script>
</head>
<body>
<div class="search">
    <span>
        请输入就诊卡信息<br>
        姓名：<input type="text" value="" id="patientName">身份证号：<input type="text" id="personid" value="" style="width: 200px">
    </span>
    <button>查询</button>
</div>
<div>
    <span class="title">请选择科室</span>
    <span class="title">请选择医生</span>
</div>
<select multiple="multiple" id="left" >
    <%--<c:forEach items="${leftList}" var="baseFunction">--%>
        <%--<option value="${baseFunction.fid}">${baseFunction.fname}</option>--%>
    <%--</c:forEach>--%>
</select>
<div class="buttons">
    <button>></button>
    <button>>></button>
    <button><</button>
    <button><<</button>
    <button>提交</button>
</div>
<select multiple="multiple" id="right" >
    <%--<c:forEach items="${rightList}" var="baseFunction">--%>
        <%--<option value="${baseFunction.fid}">${baseFunction.fname}</option>--%>
    <%--</c:forEach>--%>
</select><br><br><br>
<span id="result"></span>

</body>
</html>
