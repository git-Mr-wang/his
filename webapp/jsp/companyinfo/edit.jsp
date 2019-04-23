<%-- 
  Created by IntelliJ IDEA. 
  2018/12/04 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/companyinfo/update.action"> 
    <h1>修改公司信息表</h1> 
    <input type="hidden" name="cid" value="${companyinfo.cid}"> 
    <div class="update"> 
        <div class="left"> 
            <span>公司名称</span> 
            <input type="text" name="compname" value="${companyinfo.compname}"> 
        </div> 
        <div class="right"> 
            <span>法人姓名</span> 
            <input type="text" name="ownername" value="${companyinfo.ownername}"> 
        </div> 
        <div class="left"> 
            <span>法人电话</span> 
            <input type="text" name="ownertel" value="${companyinfo.ownertel}"> 
        </div> 
        <div class="right"> 
            <span>公司简介</span> 
            <input type="text" name="compinfo" value="${companyinfo.compinfo}"> 
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
 
