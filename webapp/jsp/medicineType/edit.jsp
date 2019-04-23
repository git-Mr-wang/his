<%-- 
  Created by IntelliJ IDEA. 
  2018/12/03 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/medicineType/update.action"> 
    <h1>修改药品类别</h1> 
    <input type="hidden" name="typeId" value="${medicineType.typeId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>类别名称</span> 
            <input type="text" name="typeName" value="${medicineType.typeName}"> 
        </div> 
        <div class="right"> 
            <span>备注</span> 
            <input type="text" name="remark" value="${medicineType.remark}"> 
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
 
