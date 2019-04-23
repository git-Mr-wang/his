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
<form action="${path}/doctorVisitRecord/insert.action"> 
    <h1>添加医生就诊记录</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>病人</span> 
            <input type="text" name="patientId" value=""> 
        </div> 
        <div class="right"> 
            <span>医生</span> 
            <input type="text" name="doctorId" value=""> 
        </div> 
        <div class="left"> 
            <span>就诊时间</span> 
            <input type="date" name="visitDate" value=""> 
        </div> 
        <div class="right"> 
            <span>症状</span> 
            <input type="text" name="symptom" value=""> 
        </div> 
        <div class="left"> 
            <span>医生建议</span> 
            <input type="text" name="advice" value=""> 
        </div> 
        <div class="right"> 
            <span>就诊次数</span> 
            <input type="text" name="times" value=""> 
        </div> 
        <div class="left"> 
            <span>状态(1:已就诊2:已缴费3:已领药)</span> 
            <input type="text" name="status" value=""> 
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
 
