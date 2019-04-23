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
<form action="${path}/baseManufacturer/insert.action"> 
    <h1>添加生产厂商</h1> 
    <div class="update">
        <div class="left"> 
            <span>生产厂商名称</span> 
            <input type="text" name="manChnName" value=""> 
        </div> 
        <div class="right"> 
            <span>英文名称</span> 
            <input type="text" name="manEngDesc" value=""> 
        </div> 
        <div class="left"> 
            <span>生产厂商简称</span> 
            <input type="text" name="manAbsName" value=""> 
        </div> 
        <div class="right"> 
            <span>地址</span> 
            <input type="text" name="address" value=""> 
        </div> 
        <div class="left"> 
            <span>传真号</span> 
            <input type="text" name="faxNo" value=""> 
        </div> 
        <div class="right"> 
            <span>国籍代码</span> 
            <input type="text" name="nationCode" value=""> 
        </div> 
        <div class="left"> 
            <span>邮编编码</span> 
            <input type="text" name="postCode" value=""> 
        </div> 
        <div class="right"> 
            <span>电话</span> 
            <input type="text" name="telNo" value=""> 
        </div> 
        <div class="left"> 
            <span>网址</span> 
            <input type="text" name="website" value=""> 
        </div> 
        <div class="right"> 
            <span>电子邮箱</span> 
            <input type="text" name="email" value=""> 
        </div> 
        <div class="left"> 
            <span>省/直辖市</span> 
            <input type="text" name="stateCode" value=""> 
        </div> 
        <div class="right"> 
            <span>县/市</span> 
            <input type="text" name="cityCode" value=""> 
        </div>
        <div class="left">
            <span>备注</span>
            <input type="text" name="note" value="">
        </div>
        <div class="right">
            <%--<span>拼音</span>--%>
            <%--<input type="text" name="py1" value="">--%>
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
 
