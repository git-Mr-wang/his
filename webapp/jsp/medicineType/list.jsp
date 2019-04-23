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
                location.href="${path}/jsp/medicineType/add.jsp";
             })
            $(".update").click(function () { 
                var typeId = $(this).attr("name");
                location.href="${path}/medicineType/load.action?typeId="+typeId;
             })
            $(".delete").click(function () { 
                var typeId = $(this).attr("name");
                location.href="${path}/medicineType/delete.action?typeId="+typeId;
             })
            $("#search").click(function () { 
                var typeName = $("#typeName").val();
                location.href = "${path}/medicineType/search.action?typeName="+typeName;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            类别名称：<input type="text" id="typeName" value="${searchObject.typeName}"> 
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
            <td>类别名称</td> 
            <td>备注</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="medicineType" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${medicineType.typeName}</td> 
                <td>${medicineType.remark}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${medicineType.typeId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${medicineType.typeId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
