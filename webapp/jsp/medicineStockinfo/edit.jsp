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
<form action="${path}/medicineStockinfo/update.action"> 
    <h1>修改药品库存表</h1> 
    <input type="hidden" name="stockinfoId" value="${medicineStockinfo.stockinfoId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>药品</span> 
            <input type="text" name="medicinecodeId" value="${medicineStockinfo.medicinecodeId}"> 
        </div> 
        <div class="right"> 
            <span>库存数量</span> 
            <input type="text" name="amt" value="${medicineStockinfo.amt}"> 
        </div> 
        <div class="left"> 
            <span>库存单价</span> 
            <input type="text" name="unitprc" value="${medicineStockinfo.unitprc}"> 
        </div> 
        <div class="right"> 
            <span>销售单价(库存单价*1.5)</span> 
            <input type="text" name="saleunitprc" value="${medicineStockinfo.saleunitprc}"> 
        </div> 
        <div class="left"> 
            <span>库存总金额(库存单价*数量)</span> 
            <input type="text" name="zje" value="${medicineStockinfo.zje}"> 
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
 
