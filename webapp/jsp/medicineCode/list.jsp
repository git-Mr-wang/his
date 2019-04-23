<%-- 
  Created by IntelliJ IDEA. 
  2018/12/03 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/medicineCode/add.jsp";
             })
            $(".update").click(function () { 
                var codeId = $(this).attr("name");
                location.href="${path}/medicineCode/load.action?codeId="+codeId;
             })
            $(".delete").click(function () { 
                var codeId = $(this).attr("name");
                location.href="${path}/medicineCode/delete.action?codeId="+codeId;
             })
            $("#search").click(function () { 
                var medicineName = $("#medicineName").val();
                location.href = "${path}/medicineCode/search.action?medicineName="+medicineName;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            药品名：<input type="text" id="medicineName" value="${searchObject.medicineName}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span> 
    </div> 
    <table> 
        <thead> 
            <td>序号</td> 
            <td>药品名</td> 
            <td>别名名称</td> 
            <td>规格</td>
            <td>生产厂商名称</td> 
            <td>药品分类名称</td>
            <td>库存单位</td> 
            <td>零售价</td> 
            <td>库存平均价</td>
            <td>用药注意事项</td> 
            <td>药袋说明</td> 
            <td>药品外形说明</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="medicineCode" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${medicineCode.medicineName}</td> 
                <td>${medicineCode.aliasName}</td> 
                <td>${medicineCode.specification}</td>
                <td>${medicineCode.manChnName}</td>
                <td>${medicineCode.typeName}</td>
                <td>${medicineCode.stockUnit}</td> 
                <td>${medicineCode.retailPrice}</td> 
                <td>${medicineCode.stockPrice}</td> 
                <td>${medicineCode.drugNotesPatient}</td> 
                <td>${medicineCode.drugNote}</td> 
                <td>${medicineCode.drugForm}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${medicineCode.codeId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${medicineCode.codeId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
