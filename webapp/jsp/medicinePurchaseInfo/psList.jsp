<%-- 
  Created by IntelliJ IDEA. 
  2018/12/04 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/medicinePurchaseInfo/add.jsp";
             })
            $(".update").click(function () { 
                var pchId = $(this).attr("name");
                location.href="${path}/medicinePurchaseInfo/load.action?pchId="+pchId;
             })
            $(".delete").click(function () { 
                var pchId = $(this).attr("name");
                location.href="${path}/medicinePurchaseInfo/delete.action?pchId="+pchId;
             })
            $("#search").click(function () { 
                var medicineCodeid = $("#medicineCodeid").val();
                location.href = "${path}/medicinePurchaseInfo/search.action?medicineCodeid="+medicineCodeid;
             })
            $("#collectBtn").click(function () {
                location.href = "${path}/medicinePurchaseInfo/collect.action";
            })
            $(".radio").click(function () {
                if ($(this).is(":checked")){
                    $(".checkbox").attr("checked",true);
                } else {
                    $(".checkbox").attr("checked",false);
                }
            })
            $("#Approval").click(function () {
                var checked=[];
                $(".checkbox:checked").each(function (i) {
                    checked[i]=$(this).val();
                })
                if (checked.length>0){
                    location.href = "${path}/medicinePurchaseInfo/purchase.action?checked="+checked;
                }else {
                    alert("请至少选中一个进行采购")
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
        <span>
            <button id="collectBtn">汇总</button>
        </span>
        <span>
            <button id="Approval">采购</button>
        </span>
    </div> 
    <table> 
        <thead> 
            <td><input type="checkbox" name="radio" class="radio"></td>
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
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="medicinePurchaseInfo" varStatus="status"> 
            <tr>
                <c:choose>
                    <c:when test="${medicinePurchaseInfo.status==1}">
                        <td><input type="checkbox" name="cc" class="checkbox" value="${medicinePurchaseInfo.pchId}"></td>
                    </c:when>
                    <c:otherwise>
                        <td></td>
                    </c:otherwise>
                </c:choose>
                <td>${status.index+1}</td> 
                <td>${medicinePurchaseInfo.medicineCode.medicineName}</td>
                <td>${medicinePurchaseInfo.manCode}</td> 
                <td>${medicinePurchaseInfo.pchAmt}</td> 
                <td>${medicinePurchaseInfo.pchPrice}</td> 
                <td>${medicinePurchaseInfo.pchTotal}</td>
                <%--<c:choose>--%>
                    <%--<c:when test="${medicinePurchaseInfo.status==1}">--%>
                        <%--<td>采购未审批</td>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<td>采购已审批</td>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
                <c:if test="${medicinePurchaseInfo.status==1}">
                    <td>采购未审批</td>
                </c:if>
                <c:if test="${medicinePurchaseInfo.status==2}">
                    <td>采购已审批</td>
                </c:if>
                <c:if test="${medicinePurchaseInfo.status==3}">
                    <td>采购已入库</td>
                </c:if>
                <td>${medicinePurchaseInfo.pchUserid}</td> 
                <td>${medicinePurchaseInfo.pchDate}</td> 
                <td>${medicinePurchaseInfo.apprvUserid}</td> 
                <td>${medicinePurchaseInfo.apprvDate}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${medicinePurchaseInfo.pchId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${medicinePurchaseInfo.pchId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
