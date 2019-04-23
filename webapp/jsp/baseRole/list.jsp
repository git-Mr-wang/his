<%--
  Created by IntelliJ IDEA.
  User: Mr.wang
  Date: 2018/11/26
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/common.jsp"%>
<html>
<head>
    <title></title>
    <script>
        $(function () {

            $("#search").click(function () {
                var rname = $("#rname").val();
                location.href = "${path}/baseRole/query.action?rname="+rname;
            })
            $(".distribute").click(function () {
                var rid = $(this).attr("name");
                location.href="${path}/baseRole/distributeLoad.action?rid="+rid;
            })

        })
    </script>
</head>
<body class="main">
    <div class="search">
        <span>
            角色名称：<input type="text" id="rname" value="${rname}">
        </span>
        <span>
            <button id="search">查询</button>
        </span>

        <a href="${path}/jsp/baseRole/add.jsp">
            <span>
            <button>增加</button>
        </span>
        </a>

    </div>

<table cellspacing="0">
    <thead>
    <td>序号</td>
    <td>角色名称</td>
    <td>编辑</td>
    <td>删除</td>
    <td>授权</td>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="list" varStatus="b">
        <tr>
            <td>${b.index+1}</td>
            <td>${list.rname}</td>
                <td>
                    <a href="${path}/baseRole/load.action?rid=${list.rid}">
                        <img src="${path}/images/edit.gif" class="edit">
                    </a>
                </td>
                <td>
                    <a href="${path}/baseRole/delete.action?rid=${list.rid}">
                        <img src="${path}/images/del.gif" class="del">
                    </a>
                </td>
            <td><img src="${path}/images/distribute.gif" class="distribute" name="${list.rid}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
