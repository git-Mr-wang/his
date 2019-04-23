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
            $("#appDate").val(formatDate(date));
            
            $.get("${path}/medicineCode/ajaxList.action",function (data) {

                var $medicineCodeid = $("#medicineCodeid");
                $(data).each(function () {
                    var $option = $("<option value='"+this.codeId+"'>"+this.medicineName+"</option>")
                    $medicineCodeid.append($option)
                })
                
            },"json")
        })

    </script>
</head> 

<body class="main"> 
<form action="${path}/medicineReqPlan/mrpApp/insert.action">
    <h1>添加药品审批表</h1> 
    <div class="update">
        <div class="left">
            <span>药品</span>
            <select name="medicineCodeid" id="medicineCodeid">

            </select>
        </div> 
        <div class="right">
            <span>需求数量</span> 
            <input type="text" name="reqamt" value=""> 
        </div> 
        <div class="left">
            <span>申请人</span> 
            <input type="text" name="appUserid" value="${baseUser.userId}" readonly="readonly">
        </div> 
        <div class="right">
            <span>申请日期</span> 
            <input type="date" name="appDate" id="appDate" readonly="readonly"> 
        </div> 
        <div class="left">
            <span>用途</span> 
            <input type="text" name="purpose" value=""> 
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
 
