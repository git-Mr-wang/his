<%-- 
  Created by IntelliJ IDEA. 
  2019/01/02 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/doctorVisitRecord/update.action"> 
    <h1>修改医生就诊记录</h1> 
    <input type="hidden" name="vrId" value="${doctorVisitRecord.vrId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>病人</span> 
            <input type="text" name="patientId" value="${doctorVisitRecord.patientId}"> 
        </div> 
        <div class="right"> 
            <span>医生</span> 
            <input type="text" name="doctorId" value="${doctorVisitRecord.doctorId}"> 
        </div> 
        <div class="left"> 
            <span>就诊时间</span> 
            <input type="date" name="visitDate" value="${doctorVisitRecord.visitDate}"> 
        </div> 
        <div class="right"> 
            <span>症状</span> 
            <input type="text" name="symptom" value="${doctorVisitRecord.symptom}"> 
        </div> 
        <div class="left"> 
            <span>医生建议</span> 
            <input type="text" name="advice" value="${doctorVisitRecord.advice}"> 
        </div> 
        <div class="right"> 
            <span>就诊次数</span> 
            <input type="text" name="times" value="${doctorVisitRecord.times}"> 
        </div> 
        <div class="left"> 
            <span>状态(1:已就诊2:已缴费3:已领药)</span> 
            <input type="text" name="status" value="${doctorVisitRecord.status}"> 
        </div> 
        <div class="right"> 
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
 
