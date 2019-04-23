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
            <%--$("#addBtn").click(function () { --%>
                <%--location.href="${path}/jsp/companyinfo/add.jsp";--%>
             <%--})--%>
            $(".update").click(function () { 
                var cid = $(this).attr("name");
                location.href="${path}/companyinfo/load.action?cid="+cid;
             })
            $(".delete").click(function () { 
                var cid = $(this).attr("name");
                location.href="${path}/companyinfo/delete.action?cid="+cid;
             })
            $("#search").click(function () { 
                var compname = $("#compname").val();
                var ownername = $("#ownername").val();
                location.href = "${path}/companyinfo/search.action?compname="+compname+"&ownername="+ownername;
             })
            $("#add").click(function () {
                var cid=$("input[name='radio']:checked").val();
                if (cid){
                    location.href="${path}/telvisit/findByCid.action?cid="+cid;
                } else {
                    alert("请至少选择一个公司")
                }
            })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search">
        <span>
            公司名称：<input type="text" id="compname" value="${companyinfo.compname}">
            法人姓名：<input type="text" id="ownername" value="${companyinfo.ownername}">
        </span>
        <span>
            <button id="search">查询</button>
        </span>
        <%--<span>--%>
            <%--<button id="addBtn">增加</button>--%>
        <%--</span>--%>
        <span> 
            <button id="add" style="width: 200px">添加回访记录</button>
        </span> 
    </div> 
    <table> 
        <thead>
            <td></td>
            <td>序号</td> 
            <td>公司名称</td> 
            <td>法人姓名</td> 
            <td>法人电话</td> 
            <td>公司简介</td> 
            <td>编辑</td> 
            <td>删除</td> 
            <td></td>
        </thead>
        <c:forEach items="${list}" var="companyinfo" varStatus="status"> 
            <tr>
                <td><input type="radio" name="radio" value="${companyinfo.cid}"></td>
                <td>${status.index+1}</td> 
                <td>${companyinfo.compname}</td> 
                <td>${companyinfo.ownername}</td> 
                <td>${companyinfo.ownertel}</td> 
                <td>${companyinfo.compinfo}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${companyinfo.cid}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${companyinfo.cid}"></td> 
                <td><a href="${path}/telvisit/cid.action?cid=${companyinfo.cid}">查看所有回访</a></td>
            </tr>
        </c:forEach> 
    </table> 
</body> 
</html> 
