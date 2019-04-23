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



            $.get("${path}/baseManufacturer/ajaxList.action",function (data) {

                var $manCode = $("#manCode");
                $(data).each(function () {
                    alert(0)
                    var $option = $("<option value='"+this.manCode+"'>"+this.manChnName+"</option>")
                    $manCode.append($option)
                })
                $("#manCode").val("${medicinePurchaseInfo.manCode}")

            },"json")
        })

    </script>
</head> 

<body class="main"> 
<form action="${path}/medicinePurchaseInfo/mpiApp/update.action">
    <h1>修改药品采集</h1> 
    <input type="hidden" name="pchId" value="${medicinePurchaseInfo.pchId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>药品</span> 
            <select name="medicineCodeid" id="medicineCodeid">

            </select>
        </div> 
        <div class="right"> 
            <span>供应商</span> 
            <select name="manCode" id="manCode">

            </select>
        </div> 
        <div class="left"> 
            <span>采购数量</span> 
            <input type="text" name="pchAmt" value="${medicinePurchaseInfo.pchAmt}"> 
        </div> 
        <div class="right"> 
            <span>采购单价</span> 
            <input type="text" name="pchPrice" value="${medicinePurchaseInfo.pchPrice}"> 
        </div> 
        <div class="left"> 
            <span>采购总价</span> 
            <input type="text" name="pchTotal" value="${medicinePurchaseInfo.pchTotal}"> 
        </div> 
        <div class="right"> 
            <span>状态</span> 
            <input type="text" name="status" value="${medicinePurchaseInfo.status}"> 
        </div> 
        <div class="left"> 
            <span>汇总人</span> 
            <input type="text" name="pchUserid" value="${medicinePurchaseInfo.pchUserid}"> 
        </div> 
        <div class="right"> 
            <span>汇总日期</span> 
            <input type="date" name="pchDate" value="${medicinePurchaseInfo.pchDate}"> 
        </div> 
        <div class="left"> 
            <span>审批人</span> 
            <input type="text" name="apprvUserid" value="${medicinePurchaseInfo.apprvUserid}"> 
        </div> 
        <div class="right"> 
            <span>审批日期</span> 
            <input type="date" name="apprvDate" value="${medicinePurchaseInfo.apprvDate}"> 
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
 
