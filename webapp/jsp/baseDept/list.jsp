<%-- 
  Created by IntelliJ IDEA. 
  2018/12/19 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/baseDept/add.jsp";
             })
            $(".update").click(function () { 
                var deptId = $(this).attr("name");
                location.href="${path}/baseDept/load.action?deptId="+deptId;
             })
            $(".delete").click(function () { 
                var deptId = $(this).attr("name");
                location.href="${path}/baseDept/delete.action?deptId="+deptId;
             })
            $("#search").click(function () { 
                var deptName = $("#deptName").val();
                location.href = "${path}/baseDept/search.action?deptName="+deptName;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            部门名称：<input type="text" id="deptName" value="${searchObject.deptName}"> 
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
            <td>部门名称</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="baseDept" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${baseDept.deptName}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${baseDept.deptId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${baseDept.deptId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
