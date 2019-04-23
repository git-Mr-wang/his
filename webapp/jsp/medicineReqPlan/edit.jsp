<%-- 
  Created by IntelliJ IDEA. 
  2018/12/04 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
    <script>
        $(function () {
//            给药品下拉框填充数据
            $.get("${path}/medicineCode/ajaxList.action",function (data) {
                var $select = $("#medicineCodeid");
                $(data).each(function () {
                    var $option=$("<option value='"+this.codeId+"'>"+this.medicineName+"</option>");
                    $option.appendTo($select);
                })
                $select.val("${medicineReqPlan.medicineCodeid}");
            },"json")
        })
    </script>
</head> 

<body class="main"> 
<form action="${path}/medicineReqPlan/update.action"> 
    <h1>修改需求计划表</h1> 
    <input type="hidden" name="reqplnno" value="${medicineReqPlan.reqplnno}"> 
    <div class="update">
        <div class="left">
            <span>药品</span>
            <select name="medicineCodeid" id="medicineCodeid"></select>
        </div>
        <%--<div class="left"> --%>
            <%--<span>药品</span> --%>
            <%--<input type="text" name="medicineCodeid" value="${medicineReqPlan.medicineCodeid}"> --%>
        <%--</div> --%>
        <div class="right"> 
            <span>需求数量</span> 
            <input type="text" name="reqamt" value="${medicineReqPlan.reqamt}"> 
        </div> 
        <%--<div class="left"> --%>
            <%--<span>申请人</span> --%>
            <input type="hidden" name="appUserid" value="${medicineReqPlan.appUserid}">
        <%--</div> --%>
        <div class="right"> 
            <span>申请日期</span> 
            <input type="date" name="appDate" value="${medicineReqPlan.appDate}"> 
        </div> 
        <div class="left"> 
            <span>用途</span> 
            <input type="text" name="purpose" value="${medicineReqPlan.purpose}"> 
        </div> 
        <%--<div class="right"> --%>
            <%--<span>状态</span> --%>
            <input type="hidden" name="status" value="${medicineReqPlan.status}">
        <%--</div> --%>
        <%--<div class="left"> --%>
            <%--<span>审批人</span> --%>
            <input type="hidden" name="apprvUserid" value="${medicineReqPlan.apprvUserid}">
        <%--</div> --%>
        <div class="right">
            <span>审批日期</span>
            <input type="date" name="apprvDate" value="${medicineReqPlan.apprvDate}">
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
 
