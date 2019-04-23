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
            $.get("${path}/baseManufacturer/ajaxList.action",function (data) {
                $(data).each(function () {
                    $("#manCode").append('<option value="'+this.manCode+'">'+this.manChnName+'</option>');
                })
                <%--alert("${medicinePurchaseInfo.manCode}");--%>
                $("#manCode").val("${medicinePurchaseInfo.manCode}");
            },"json")
        })
    </script>
</head> 

<body class="main"> 
<form action="${path}/medicinePurchaseInfo/update.action"> 
    <h1>修改采购信息表</h1> 
    <input type="hidden" name="pchId" value="${medicinePurchaseInfo.pchId}"> 
    <div class="update"> 
        <%--<div class="left"> --%>
            <%--<span>药品</span> --%>
            <input type="hidden" name="medicineCodeid" value="${medicinePurchaseInfo.medicineCodeid}">
        <%--</div> --%>
        <div class="right"> 
            <span>供应商</span>
            <select name="manCode" id="manCode">

            </select>
            <%--<input type="text" name="manCode" value="${medicinePurchaseInfo.manCode}"> --%>
        </div> 
        <div class="left"> 
            <span>采购数量</span>
            <input type="text" name="pchAmt" value="${medicinePurchaseInfo.pchAmt}">
        </div> 
        <div class="right"> 
            <span>采购单价</span> 
            <input type="text" name="pchPrice" value="${medicinePurchaseInfo.pchPrice}"> 
        </div> 
        <%--<div class="left"> --%>
            <%--<span>采购总价</span> --%>
            <input type="hidden" name="pchTotal" value="${medicinePurchaseInfo.pchAmt*medicinePurchaseInfo.pchPrice}">
        <%--</div> --%>
        <%--<div class="right"> --%>
            <%--<span>状态</span> --%>
            <input type="hidden" name="status" value="${medicinePurchaseInfo.status}">
        <%--</div> --%>
        <%--<div class="left"> --%>
            <%--<span>汇总人</span> --%>
            <input type="hidden" name="pchUserid" value="${medicinePurchaseInfo.pchUserid}">
        <%--</div> --%>
        <%--<div class="right"> --%>
            <%--<span>汇总日期</span> --%>
            <input type="hidden" name="pchDate" value="${medicinePurchaseInfo.pchDate}">
        <%--</div> --%>
        <%--<div class="left"> --%>
            <%--<span>审批人</span> --%>
            <input type="hidden" name="apprvUserid" value="${medicinePurchaseInfo.apprvUserid}">
        <%--</div> --%>
        <%--<div class="right"> --%>
            <%--<span>审批日期</span> --%>
            <input type="hidden" name="apprvDate" value="${medicinePurchaseInfo.apprvDate}">
        <%--</div> --%>
        <div id="error"></div> 
        <div class="buttons"> 
            <input type="submit" value="提交"> 
            <input type="button" onclick="history.back()" value="返回"> 
        </div> 
    </div> 
</form> 
</body> 
</html> 
 
