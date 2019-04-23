<%-- 
  Created by IntelliJ IDEA. 
  2018/12/11 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/medicineInstock/insert.action"> 
    <h1>添加药品入库记录表</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>发票号</span> 
            <input type="text" name="invno" value=""> 
        </div> 
        <div class="right"> 
            <span>药品</span> 
            <input type="text" name="medicineCodeid" value=""> 
        </div> 
        <div class="left"> 
            <span>入库数量</span> 
            <input type="text" name="inamt" value=""> 
        </div> 
        <div class="right"> 
            <span>入库单价</span> 
            <input type="text" name="unitprc" value=""> 
        </div> 
        <div class="left"> 
            <span>入库总金额</span> 
            <input type="text" name="zje" value=""> 
        </div> 
        <div class="right"> 
            <span>入库人</span> 
            <input type="text" name="instockUserid" value=""> 
        </div> 
        <div class="left"> 
            <span>入库日期</span> 
            <input type="date" name="instockDate" value=""> 
        </div> 
        <div class="right"> 
            <span>供应商</span> 
            <input type="text" name="manCode" value=""> 
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
 
