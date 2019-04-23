<%-- 
  Created by IntelliJ IDEA. 
  2018/12/26 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/patientRegisterRecord/distribute.jsp";
             })
            $(".update").click(function () { 
                var registerId = $(this).attr("name");
                location.href="${path}/patientRegisterRecord/load.action?registerId="+registerId;
             })
            $(".delete").click(function () { 
                var registerId = $(this).attr("name");
                location.href="${path}/patientRegisterRecord/delete.action?registerId="+registerId;
             })
            $("#search").click(function () { 
                var patientId = $("#patientId").val();
                location.href = "${path}/patientRegisterRecord/search.action?patientId="+patientId;
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
            <button id="addBtn">增加</button> 
        </span> 
    </div> 
    <table> 
        <thead> 
            <td>序号</td> 
            <td>病人</td> 
            <td>部门</td> 
            <td>挂号时间</td> 
            <td>挂号人</td> 
            <td>医生</td> 
            <td>状态</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="patientRegisterRecord" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${patientRegisterRecord.basePatientInfo.patientName}</td>
                <td>${patientRegisterRecord.baseDept.deptName}</td>
                <td>${patientRegisterRecord.registerDate}</td> 
                <td>${patientRegisterRecord.baseUser.cname}</td>
                <td>${patientRegisterRecord.baseUser2.cname}</td>
                <c:if test="${patientRegisterRecord.status==1}">
                    <td>已挂号</td>
                </c:if>
                <c:if test="${patientRegisterRecord.status==2}">
                    <td>就诊中</td>
                </c:if>
                <c:if test="${patientRegisterRecord.status==3}">
                    <td>已就诊</td>
                </c:if>

                <td><img src="${path}/images/edit.gif" class="update" name="${patientRegisterRecord.registerId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${patientRegisterRecord.registerId}"></td> 
            </tr>
        </c:forEach> 
    </table> 
</body> 
</html> 
