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
<form action="${path}/baseManufacturer/update.action"> 
    <h1>修改生产厂商</h1> 
    <input type="hidden" name="manCode" value="${baseManufacturer.manCode}"> 
    <div class="update">
        <div class="left"> 
            <span>生产厂商名称</span> 
            <input type="text" name="manChnName" value="${baseManufacturer.manChnName}"> 
        </div> 
        <div class="right"> 
            <span>英文名称</span> 
            <input type="text" name="manEngDesc" value="${baseManufacturer.manEngDesc}"> 
        </div> 
        <div class="left"> 
            <span>生产厂商简称</span> 
            <input type="text" name="manAbsName" value="${baseManufacturer.manAbsName}"> 
        </div> 
        <div class="right"> 
            <span>地址</span> 
            <input type="text" name="address" value="${baseManufacturer.address}"> 
        </div> 
        <div class="left"> 
            <span>传真号</span> 
            <input type="text" name="faxNo" value="${baseManufacturer.faxNo}"> 
        </div> 
        <div class="right"> 
            <span>国籍代码</span> 
            <input type="text" name="nationCode" value="${baseManufacturer.nationCode}"> 
        </div> 
        <div class="left"> 
            <span>邮编编码</span> 
            <input type="text" name="postCode" value="${baseManufacturer.postCode}"> 
        </div> 
        <div class="right"> 
            <span>电话</span> 
            <input type="text" name="telNo" value="${baseManufacturer.telNo}"> 
        </div> 
        <div class="left"> 
            <span>网址</span> 
            <input type="text" name="website" value="${baseManufacturer.website}"> 
        </div> 
        <div class="right"> 
            <span>电子邮箱</span> 
            <input type="text" name="email" value="${baseManufacturer.email}"> 
        </div> 
        <div class="left"> 
            <span>省/直辖市</span> 
            <input type="text" name="stateCode" value="${baseManufacturer.stateCode}"> 
        </div> 
        <div class="right"> 
            <span>县/市</span> 
            <input type="text" name="cityCode" value="${baseManufacturer.cityCode}"> 
        </div>
        <div class="left">
            <span>备注</span>
            <input type="text" name="note" value="${baseManufacturer.note}">
        </div>
        <div class="right">
            <%--<span>拼音</span>--%>
            <%--<input type="text" name="py1" value="${baseManufacturer.py1}">--%>
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
 
