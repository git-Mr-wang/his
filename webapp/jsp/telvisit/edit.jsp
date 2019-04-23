<%-- 
  Created by IntelliJ IDEA. 
  2018/12/24 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/telvisit/update.action"> 
    <h1>修改回访记录表</h1> 
    <input type="hidden" name="tvid" value="${telvisit.tvid}"> 
    <div class="update"> 
        <div class="left"> 
            <span>回访人姓名</span> 
            <input type="text" name="telname" value="${telvisit.telname}"> 
        </div> 
        <div class="right"> 
            <span>回访时间</span> 
            <input type="date" name="teltime" value="${telvisit.teltime}"> 
        </div> 
        <div class="left"> 
            <span>回访分类</span> 
            <input type="text" name="visitreason" value="${telvisit.visitreason}"> 
        </div> 
        <div class="right"> 
            <span>回访结果</span> 
            <input type="text" name="visitreturn" value="${telvisit.visitreturn}"> 
        </div> 
        <div class="left"> 
            <span>回访方式</span> 
            <input type="text" name="visittype" value="${telvisit.visittype}"> 
        </div> 
        <div class="right"> 
            <span>所属公司编号</span> 
            <input type="text" name="cid" value="${telvisit.cid}"> 
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
 
