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
                location.href="${path}/jsp/basePatientInfo/add.jsp";
             })
            $(".update").click(function () { 
                var patientId = $(this).attr("name");
                location.href="${path}/basePatientInfo/load.action?patientId="+patientId;
             })
            $(".delete").click(function () { 
                var patientId = $(this).attr("name");
                location.href="${path}/basePatientInfo/delete.action?patientId="+patientId;
             })
            $("#search").click(function () { 
                var patientName = $("#patientName").val();
                location.href = "${path}/basePatientInfo/search.action?patientName="+patientName;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            病人姓名：<input type="text" id="patientName" value="${searchObject.patientName}"> 
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
            <td>病人姓名</td> 
            <td>出生日期</td> 
            <td>性别</td> 
            <td>家庭住址</td> 
            <td>电话号码</td> 
            <td>身份证号</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="basePatientInfo" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${basePatientInfo.patientName}</td> 
                <td>${basePatientInfo.birth}</td> 
                <td>${basePatientInfo.sex}</td> 
                <td>${basePatientInfo.address}</td> 
                <td>${basePatientInfo.phonenum}</td> 
                <td>${basePatientInfo.personid}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${basePatientInfo.patientId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${basePatientInfo.patientId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
