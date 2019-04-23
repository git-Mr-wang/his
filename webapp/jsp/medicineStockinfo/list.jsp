<%-- 
  Created by IntelliJ IDEA. 
  2018/12/11 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/medicineStockinfo/add.jsp";
             })
            $(".update").click(function () { 
                var stockinfoId = $(this).attr("name");
                location.href="${path}/medicineStockinfo/load.action?stockinfoId="+stockinfoId;
             })
            $(".delete").click(function () { 
                var stockinfoId = $(this).attr("name");
                location.href="${path}/medicineStockinfo/delete.action?stockinfoId="+stockinfoId;
             })
            $("#search").click(function () { 
                var medicinecodeId = $("#medicinecodeId").val();
                location.href = "${path}/medicineStockinfo/search.action?medicinecodeId="+medicinecodeId;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            药品：<input type="text" id="medicinecodeId" value="${searchObject.medicinecodeId}"> 
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
            <td>药品</td> 
            <td>库存数量</td> 
            <td>库存单价</td> 
            <td>销售单价(库存单价*1.5)</td> 
            <td>库存总金额(库存单价*数量)</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="medicineStockinfo" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${medicineStockinfo.medicinecodeId}</td> 
                <td>${medicineStockinfo.amt}</td> 
                <td>${medicineStockinfo.unitprc}</td> 
                <td>${medicineStockinfo.saleunitprc}</td> 
                <td>${medicineStockinfo.zje}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${medicineStockinfo.stockinfoId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${medicineStockinfo.stockinfoId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
