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
                location.href="${path}/jsp/medicinePurchaseInfo/mpiApp/add.jsp";
             })
            $(".update").click(function () { 
                var pchId = $(this).attr("name");
                location.href="${path}/medicinePurchaseInfo/mpiApp/load.action?pchId="+pchId;
             })
            $(".delete").click(function () { 
                var pchId = $(this).attr("name");
                location.href="${path}/medicinePurchaseInfo/mpiApp/delete.action?pchId="+pchId;
             })
            $("#search").click(function () { 
                var medicineCodeid = $("#medicineCodeid").val();
                location.href = "${path}/medicinePurchaseInfo/mpiApp/search.action?medicineCodeid="+medicineCodeid;
             })
            $(".statusTrue").click(function () {
                var pchId = $(this).attr("name");
                if(confirm("是否确认更改状态？")){
                    location.href="${path}/medicinePurchaseInfo/mpiApp/statusTrue.action?pchId="+pchId;
                }

            })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            药品：<input type="text" id="medicineCodeid" value="${searchObject.medicineCodeid}"> 
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
            <td>供应商</td> 
            <td>采购数量</td> 
            <td>采购单价</td> 
            <td>采购总价</td> 
            <td>状态</td> 
            <td>汇总人</td> 
            <td>汇总日期</td> 
            <td>审批人</td> 
            <td>审批日期</td> 
            <td>审批</td>
            <td>编辑</td>
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="medicinePurchaseInfo" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${medicinePurchaseInfo.medicineCodeid}</td> 
                <td>${medicinePurchaseInfo.manCode}</td> 
                <td>${medicinePurchaseInfo.pchAmt}</td> 
                <td>${medicinePurchaseInfo.pchPrice}</td> 
                <td>${medicinePurchaseInfo.pchTotal}</td> 
                <td>
                    <c:if test="${medicinePurchaseInfo.status==1}">
                        采购未审批
                    </c:if>
                    <c:if test="${medicinePurchaseInfo.status==2}">
                        采购已审批
                    </c:if>
                </td>
                <td>${medicinePurchaseInfo.pchUserid}</td> 
                <td>${medicinePurchaseInfo.pchDate}</td> 
                <td>${medicinePurchaseInfo.apprvUserid}</td> 
                <td>${medicinePurchaseInfo.apprvDate}</td>
                <td><img src="${path}/images/distribute.gif" class="statusTrue" name="${medicinePurchaseInfo.pchId}"></td>
                <td><img src="${path}/images/edit.gif" class="update" name="${medicinePurchaseInfo.pchId}"></td>
                <td><img src="${path}/images/del.gif" class="delete" name="${medicinePurchaseInfo.pchId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
