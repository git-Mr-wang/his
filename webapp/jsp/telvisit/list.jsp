<%-- 
  Created by IntelliJ IDEA. 
  2018/12/24 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/telvisit/add.jsp";
             })
            $(".update").click(function () { 
                var tvid = $(this).attr("name");
                location.href="${path}/telvisit/load.action?tvid="+tvid;
             })
            $(".delete").click(function () { 
                var tvid = $(this).attr("name");
                location.href="${path}/telvisit/delete.action?tvid="+tvid;
             })
            $("#search").click(function () { 
                var telname = $("#telname").val();
                location.href = "${path}/telvisit/search.action?telname="+telname;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            回访人姓名：<input type="text" id="telname" value="${searchObject.telname}"> 
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
            <td>回访人姓名</td> 
            <td>回访时间</td> 
            <td>回访分类</td> 
            <td>回访结果</td> 
            <td>回访方式</td> 
            <td>所属公司编号</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="telvisit" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${telvisit.telname}</td> 
                <td>${telvisit.teltime}</td> 
                <td>${telvisit.visitreason}</td> 
                <td>${telvisit.visitreturn}</td> 
                <td>${telvisit.visittype}</td> 
                <td>${telvisit.cid}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${telvisit.tvid}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${telvisit.tvid}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
