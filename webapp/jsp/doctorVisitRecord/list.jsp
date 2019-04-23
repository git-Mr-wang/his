<%-- 
  Created by IntelliJ IDEA. 
  2019/01/02 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/doctorVisitRecord/visit.jsp";
             })
            $(".update").click(function () { 
                var vrId = $(this).attr("name");
                location.href="${path}/doctorVisitRecord/load.action?vrId="+vrId;
             })
            $(".delete").click(function () { 
                var vrId = $(this).attr("name");
                location.href="${path}/doctorVisitRecord/delete.action?vrId="+vrId;
             })
            $("#search").click(function () { 
                var patientId = $("#patientId").val();
                location.href = "${path}/doctorVisitRecord/search.action?patientId="+patientId;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            病人：<input type="text" id="patientId" value="${searchObject.patientId}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">就诊</button>
        </span> 
    </div> 
    <table> 
        <thead> 
            <td>序号</td> 
            <td>病人</td> 
            <td>医生</td> 
            <td>就诊时间</td> 
            <td>症状</td> 
            <td>医生建议</td> 
            <td>就诊次数</td> 
            <td>状态(1:已就诊2:已缴费3:已领药)</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="doctorVisitRecord" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${doctorVisitRecord.patientId}</td> 
                <td>${doctorVisitRecord.doctorId}</td> 
                <td>${doctorVisitRecord.visitDate}</td> 
                <td>${doctorVisitRecord.symptom}</td> 
                <td>${doctorVisitRecord.advice}</td> 
                <td>${doctorVisitRecord.times}</td> 
                <td>${doctorVisitRecord.status}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${doctorVisitRecord.vrId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${doctorVisitRecord.vrId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
