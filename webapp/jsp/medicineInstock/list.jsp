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
            <%--$("addBtn").click(function () { --%>
                <%--location.href="${path}/jsp/medicineInstock/add.jsp";--%>
             <%--})--%>
            $(".update").click(function () { 
                var instockId = $(this).attr("name");
                location.href="${path}/medicineInstock/load.action?instockId="+instockId;
             })
            $(".delete").click(function () { 
                var instockId = $(this).attr("name");
                location.href="${path}/medicineInstock/delete.action?instockId="+instockId;
             })
            $("#search").click(function () { 
                var invno = $("#invno").val();
                location.href = "${path}/medicineInstock/search.action?invno="+invno;
             })
            $(".radio").click(function () {
                if ($(this).is(":checked")){
                    $(".checkbox").attr("checked",true);
                } else {
                    $(".checkbox").attr("checked",false);
                }
            })


            $("#addBtn").click(function () {
                var text=[];
                var checked=[];
                var flag=true;
                $(".checkbox:checked").each(function (i) {
                    checked[i]=$(this).val();
                })
                $('input.checkbox:checked').each(function(i){
                    var s=$(this).parent().siblings().find('input').val();
                    if (s=='请输入发票号'||s==''){
                        flag=false;
                        return false;
                    }else {
                        text[i]=s;
                    }
                })
                if (flag){
                    if (checked.length>0){
                        // alert(checked);alert(text);
                        location.href = "${path}/medicineInstock/insert.action?checked="+checked+"&text="+text;
                    }else {
                        alert("请至少选中一个进行入库")
                    }
                }else {
                    alert("请输入发票号，必填");
                }
            })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            发票号：<input type="text" id="invno" value="${searchObject.invno}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">入库</button>
        </span>
    </div> 
    <table> 
        <thead> 
            <td><input type="checkbox" name="radio" class="radio"></td>
            <td>序号</td>
            <td>药品</td>
            <td>入库数量</td>
            <td>入库单价</td>
            <td>入库总金额</td>
            <%--<td>入库人</td> --%>
            <%--<td>入库日期</td> --%>
            <td>供应商</td>
            <td>发票号</td>
        </thead>
        <c:forEach items="${list}" var="MedicinePurchaseInfo" varStatus="status">
            <tr>
                <td><input type="checkbox" name="cc" class="checkbox" value="${MedicinePurchaseInfo.pchId}"></td>
                <td>${status.index+1}</td>
                <td>${MedicinePurchaseInfo.medicineCode.medicineName}</td>
                <td>${MedicinePurchaseInfo.pchAmt}</td>
                <td>${MedicinePurchaseInfo.pchPrice}</td>
                <td>${MedicinePurchaseInfo.pchTotal}</td>
                <%--<td><input type="text" value="入库人"></td>--%>
                <%--<td></td>--%>
                <td>${MedicinePurchaseInfo.manCode}</td>
                <%--<td><img src="${path}/images/edit.gif" class="update" name="${medicineInstock.instockId}"></td>--%>
                <%--<td><img src="${path}/images/del.gif" class="delete" name="${medicineInstock.instockId}"></td> --%>
                <td><input type="text" value="请输入发票号"></td>
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
