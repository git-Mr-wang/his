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
            function formatDate(date) {
                var myDate = new Date(date),
                    month = '' + (myDate.getMonth() + 1),
                    day = '' + myDate.getDate(),
                    year = myDate.getFullYear();

                if (month.length < 2) month = '0' + month;
                if (day.length < 2) day = '0' + day;

                return [year, month, day].join('-');
            }
            var date = new Date();
            $("#pchDate").val(formatDate(date));

            $(".pchAmt").blur(function () {

                $(".pchTotal").val($(this).val()*$(".pchPrice").val())

            })
            $(".pchPrice").blur(function () {

                $(".pchTotal").val($(this).val()*$(".pchAmt").val())

            })

            $.get("${path}/medicineCode/ajaxList.action",function (data) {

                var $medicineCodeid = $("#medicineCodeid");
                $(data).each(function () {
                    alert(0)
                    var $option = $("<option value='"+this.codeId+"'>"+this.medicineName+"</option>")
                    $medicineCodeid.append($option)
                })

            },"json")


            $.get("${path}/baseManufacturer/ajaxList.action",function (data) {

                var $manCode = $("#manCode");
                $(data).each(function () {
                    alert(0)
                    var $option = $("<option value='"+this.manCode+"'>"+this.manChnName+"</option>")
                    $manCode.append($option)
                })

            },"json")

        })
    </script>
</head> 

<body class="main"> 
<form action="${path}/medicinePurchaseInfo/mpiApp/insert.action">
    <h1>添加药品采集</h1> 
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
            <input type="text" name="pchAmt" class="pchAmt" value="">
        </div> 
        <div class="right">
            <span>采购单价</span> 
            <input type="text" name="pchPrice" class="pchPrice" value="">
        </div> 
        <div class="left">
            <span>采购总价</span> 
            <input type="text" name="pchTotal" class="pchTotal" value="" readonly="readonly">
        </div>
        <div class="left">
            <span>汇总人</span> 
            <input type="text" name="pchUserid" value="${baseUser.userId}">
        </div> 
        <div class="right">
            <span>汇总日期</span> 
            <input type="date" name="pchDate" value="">
        </div> 
        <div class="left">
            <span>审批人</span> 
            <input type="text" name="apprvUserid" value="">
        </div> 
        <div class="right">
            <span>审批日期</span> 
            <input type="date" name="apprvDate" id="apprvDate" value="">
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
 
