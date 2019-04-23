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
                var mname = $("#mname").val();
                location.href = "${path}/baseModule/query.action?mname="+mname;
            })

        })
    </script>
</head>
<body class="main">
    <div class="search">
        <span>
            模块名称：<input type="text" id="mname" value="${mname}">
        </span>
        <span>
            <button id="search">查询</button>
        </span>

        <a href="${path}/jsp/baseModule/add.jsp">
            <span>
            <button>增加</button>
        </span>
        </a>

    </div>

<table cellspacing="0">
    <thead>
    <td>序号</td>
    <td>模块名称</td>
    <td>编辑</td>
    <td>删除</td>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="list" varStatus="b">
        <tr>
            <td>${b.index+1}</td>
            <td>${list.mname}</td>
                <td>
                    <a href="${path}/baseModule/load.action?mid=${list.mid}">
                        <img src="${path}/images/edit.gif" class="edit">
                    </a>
                </td>
                <td>
                    <a href="${path}/baseModule/delete.action?mid=${list.mid}">
                        <img src="${path}/images/del.gif" class="del">
                    </a>
                </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--<div class="page">--%>
    <%--<c:if test="${page.currentPage!=page.begin}">--%>
        <%--<span style="color: #333333">上</span>--%>
    <%--</c:if>--%>
    <%--<c:forEach begin="${page.begin}" end="${page.end}" var="i">--%>
        <%--<c:if test="${page.currentPage==i}">--%>
            <%--<span style="color: #333333;background-color: #FF2D2D">${i}</span>--%>
        <%--</c:if>--%>
        <%--<c:if test="${page.currentPage!=i}">--%>
            <%--<span style="color: #333333">${i}</span>--%>
        <%--</c:if>--%>
    <%--</c:forEach>--%>
    <%--<c:if test="${page.currentPage!=page.end}">--%>
        <%--<span style="color: #333333">下</span>--%>
    <%--</c:if>--%>
    <%--<label style="margin-left: 50px;font-size: 15px">--%>
        <%--每页显示--%>
        <%--<select style="width: 50px;height: 25px" id="select">--%>
            <%--<option value="5">5</option>--%>
            <%--<option value="10">10</option>--%>
            <%--<option value="20">20</option>--%>
            <%--<option value="50">50</option>--%>
        <%--</select>条信息--%>
    <%--</label>--%>
<%--</div>--%>
</body>
</html>
