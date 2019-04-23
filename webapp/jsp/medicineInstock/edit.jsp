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
<form action="${path}/medicineInstock/update.action"> 
    <h1>修改药品入库记录表</h1> 
    <input type="hidden" name="instockId" value="${medicineInstock.instockId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>发票号</span> 
            <input type="text" name="invno" value="${medicineInstock.invno}"> 
        </div> 
        <div class="right"> 
            <span>药品</span> 
            <input type="text" name="medicineCodeid" value="${medicineInstock.medicineCodeid}"> 
        </div> 
        <div class="left"> 
            <span>入库数量</span> 
            <input type="text" name="inamt" value="${medicineInstock.inamt}"> 
        </div> 
        <div class="right"> 
            <span>入库单价</span> 
            <input type="text" name="unitprc" value="${medicineInstock.unitprc}"> 
        </div> 
        <div class="left"> 
            <span>入库总金额</span> 
            <input type="text" name="zje" value="${medicineInstock.zje}"> 
        </div> 
        <div class="right"> 
            <span>入库人</span> 
            <input type="text" name="instockUserid" value="${medicineInstock.instockUserid}"> 
        </div> 
        <div class="left"> 
            <span>入库日期</span> 
            <input type="date" name="instockDate" value="${medicineInstock.instockDate}"> 
        </div> 
        <div class="right"> 
            <span>供应商</span> 
            <input type="text" name="manCode" value="${medicineInstock.manCode}"> 
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
 
