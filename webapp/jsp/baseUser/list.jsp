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
            $(".xq").click(function () {
                window.parent.open('${path}/jsp/baseUserRole/details.jsp?userId='+$(this).attr("name"),
                                    "角色详情",'height=700, width=1200, top=50, left=100')
            })

            $("#search").click(function () {
                var cname = $("#cname").val();
                var sex = $("#sex").val();
                location.href = "${path}/baseUser/query.action?cname="+cname+"&sex="+sex;
            })

        })
    </script>
</head>
<body class="main">
    <div class="search">
        <span>
            中文名字：<input type="text" id="cname" value="${cname}">
        </span>
        <span>
            性别：<input type="text" id="sex" value="${sex}">
        </span>
        <span>
            <button id="search">查询</button>
        </span>

        <a href="${path}/jsp/baseUser/add.jsp">
            <span>
            <button>增加</button>
        </span>
        </a>

    </div>

<table cellspacing="0">
    <thead>
    <td>序号</td>
    <td>用户名</td>
    <td>用户角色</td>
    <td>中文名字</td>
    <td>性别</td>
    <td>部门</td>
    <td>岗位</td>
    <td>编辑</td>
    <td>删除</td>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="list" varStatus="b">
        <tr>
            <td>${b.index+1}</td>
            <td>${list.userName}</td>
            <td><a href="#" name="${list.userId}" class="xq">查看详情</a></td>
            <td>${list.cname}</td>
            <td>${list.sex}</td>
            <td>${list.baseDept.deptName}</td>
            <td></td>
                <td>
                    <a href="${path}/baseUser/load.action?userId=${list.userId}">
                        <img src="${path}/images/edit.gif" class="edit">
                    </a>
                </td>
                <td>
                    <a href="${path}/baseUser/delete.action?userId=${list.userId}">
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
