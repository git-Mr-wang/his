<%-- 
  Created by IntelliJ IDEA. 
  2019/01/15 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/inPatient/update.action"> 
    <h1>修改病人</h1> 
    <input type="hidden" name="patientId" value="${inPatient.patientId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>病人姓名</span> 
            <input type="text" name="patientName" value="${inPatient.patientName}"> 
        </div> 
        <div class="right"> 
            <span>性别</span> 
            <input type="text" name="sex" value="${inPatient.sex}"> 
        </div> 
        <div class="left"> 
            <span>出生日期</span> 
            <input type="date" name="birth" value="${inPatient.birth}"> 
        </div> 
        <div class="right"> 
            <span>床号</span> 
            <input type="text" name="bedNum" value="${inPatient.bedNum}"> 
        </div> 
        <div class="left"> 
            <span>消费金额</span> 
            <input type="text" name="amount" value="${inPatient.amount}"> 
        </div> 
        <div class="right"> 
            <span>1:在院2:出院</span> 
            <input type="text" name="status" value="${inPatient.status}"> 
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
 
