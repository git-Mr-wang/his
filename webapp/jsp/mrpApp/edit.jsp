<%-- 
  Created by IntelliJ IDEA. 
  2018/12/03 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
    <script>

        $(function () {

            $.get("${path}/medicineCode/ajaxList.action",function (data) {

                var $medicineCodeid = $("#medicineCodeid");
                $(data).each(function () {
                    var $option = $("<option value='"+this.codeId+"'>"+this.medicineName+"</option>")
                    $medicineCodeid.append($option)
                })
                $("#medicineCodeid").val("${medicineReqPlan.medicineCodeid}");

            },"json")

        })

    </script>
</head> 

<body class="main"> 
<form action="${path}/medicineReqPlan/mrpApp/update.action">
    <h1>修改药品审批表</h1> 
    <input type="hidden" name="reqplnno" value="${medicineReqPlan.reqplnno}"> 
    <div class="update"> 
        <div class="left"> 
            <span>药品</span> 
            <input type="text" name="medicineCodeid" value="${medicineReqPlan.medicineCodeid}">
            <select name="medicineCodeid" id="medicineCodeid">

            </select>
        </div> 
        <div class="right"> 
            <span>需求数量</span> 
            <input type="text" name="reqamt" value="${medicineReqPlan.reqamt}"> 
        </div> 
        <div class="left"> 
            <span>申请人</span> 
            <input type="text" name="appUserid" value="${medicineReqPlan.appUserid}"> 
        </div> 
        <div class="right"> 
            <span>申请日期</span> 
            <input type="date" name="appDate" value="${medicineReqPlan.appDate}"> 
        </div> 
        <div class="left"> 
            <span>用途</span> 
            <input type="text" name="purpose" value="${medicineReqPlan.purpose}"> 
        </div> 
        <div class="right"> 
            <span>状态</span> 
            <input type="text" name="status" value="${medicineReqPlan.status}" readonly="readonly">
        </div> 
        <div class="left"> 
            <span>审批人</span> 
            <input type="text" name="apprvUserid" value="${medicineReqPlan.apprvUserid}" readonly="readonly">
        </div> 
        <div class="right"> 
            <span>审批日期</span> 
            <input type="date" name="apprvDate" value="${medicineReqPlan.apprvDate}" readonly="readonly">
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
 
