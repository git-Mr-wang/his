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
                location.href="${path}/jsp/doctorMenu/add.jsp";
             })
            $(".update").click(function () {
                var menuId = $(this).attr("name");
                location.href="${path}/doctorMenu/load.action?menuId="+menuId;
             })
            $(".delete").click(function () {
                var menuId = $(this).attr("name");
                location.href="${path}/doctorMenu/delete.action?menuId="+menuId;
             })
            $("#search").click(function () {
                var menuName = $("#menuName").val();
                location.href = "${path}/doctorMenu/search.action?menuName="+menuName;
             })
        })
    </script>
</head>
<body class="main">
    <div class="search">
        <span>
            套餐名称：<input type="text" id="menuName" value="${searchObject.menuName}">
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
            <td>套餐名称</td>
            <td>详情</td>
            <td>用户</td>
            <td>套餐描述</td>
            <td>套餐类型</td>
            <td>编辑</td>
            <td>删除</td>
        </thead>
        <c:forEach items="${list}" var="doctorMenu" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${doctorMenu.menuName}</td>
                <td><a href="${path}/jsp/doctorMenu/distribute.jsp?menuId=${doctorMenu.menuId}">查看详情</a></td>
                <td>${doctorMenu.baseUser.userName}</td>
                <td>${doctorMenu.description}</td>
                <td>${doctorMenu.typeEsc}</td>
                <%--<c:if test="${doctorMenu.type==1}">--%>
                    <%--<td>套餐仅自己可用</td>--%>
                <%--</c:if>--%>
                <%--<c:if test="${doctorMenu.type==2}">--%>
                    <%--<td>套餐全科室都可用</td>--%>
                <%--</c:if>--%>
                <%--<c:if test="${doctorMenu.type==3}">--%>
                    <%--<td>套餐所有医生都可用</td>--%>
                <%--</c:if>--%>
                <%--<td>${doctorMenu.type}</td>--%>
                <td><img src="${path}/images/edit.gif" class="update" name="${doctorMenu.menuId}"></td>
                <td><img src="${path}/images/del.gif" class="delete" name="${doctorMenu.menuId}"></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html> 
