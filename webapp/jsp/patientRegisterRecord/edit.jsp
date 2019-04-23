<%-- 
  Created by IntelliJ IDEA. 
  2018/12/26 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/patientRegisterRecord/update.action"> 
    <h1>修改挂号功能</h1> 
    <input type="hidden" name="registerId" value="${patientRegisterRecord.registerId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>病人</span> 
            <input type="text" name="patientId" value="${patientRegisterRecord.patientId}"> 
        </div> 
        <div class="right"> 
            <span>部门</span> 
            <input type="text" name="deptId" value="${patientRegisterRecord.deptId}"> 
        </div> 
        <div class="left"> 
            <span>挂号时间</span> 
            <input type="date" name="registerDate" value="${patientRegisterRecord.registerDate}"> 
        </div> 
        <div class="right"> 
            <span>挂号人</span> 
            <input type="text" name="recordUser" value="${patientRegisterRecord.recordUser}"> 
        </div> 
        <div class="left"> 
            <span>医生</span> 
            <input type="text" name="doctorId" value="${patientRegisterRecord.doctorId}"> 
        </div> 
        <div class="right"> 
            <span>状态</span> 
            <input type="text" name="status" value="${patientRegisterRecord.status}"> 
        </div> 
        <div id="error"></div> 
        <div class="buttons"> 
            <input type="submit" value="提交"> 
            <input type="button" onclick="history.back()" value="返回"> 
        </div> 
    </div> 
</form> 
</body> 
</html> 
 
