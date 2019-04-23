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
            },"json")
        })
    </script>
</head> 

<body class="main"> 
<form action="${path}/medicineReqPlan/insert.action"> 
    <h1>添加需求计划表</h1> 
        <div class="update">
        <div class="left">
            <span>药品</span>
            <select name="medicineCodeid" id="medicineCodeid"></select>
        </div>
        <div class="right"> 
            <span>需求数量</span> 
            <input type="text" name="reqamt" value=""> 
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
 
