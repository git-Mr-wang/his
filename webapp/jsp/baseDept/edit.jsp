<%-- 
  Created by IntelliJ IDEA. 
  2018/12/19 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/baseDept/update.action"> 
    <h1>修改部门管理</h1> 
    <input type="hidden" name="deptId" value="${baseDept.deptId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>部门名称</span> 
            <input type="text" name="deptName" value="${baseDept.deptName}"> 
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
 
