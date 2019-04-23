<%-- 
  Created by IntelliJ IDEA. 
  2018/12/03 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/baseManufacturer/add.jsp";
             })
            $(".update").click(function () { 
                var manCode = $(this).attr("name");
                location.href="${path}/baseManufacturer/load.action?manCode="+manCode;
             })
            $(".delete").click(function () { 
                var manCode = $(this).attr("name");
                location.href="${path}/baseManufacturer/delete.action?manCode="+manCode;
             })
            $("#search").click(function () { 
                var note = $("#note").val();
                location.href = "${path}/baseManufacturer/search.action?note="+note;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            备注：<input type="text" id="note" value="${searchObject.note}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span> 
    </div> 
    <table> 
        <thead> 
            <td>序号</td>
            <td>拼音</td> 
            <td>生产厂商名称</td> 
            <td>英文名称</td> 
            <td>生产厂商简称</td> 
            <td>地址</td> 
            <td>传真号</td> 
            <td>国籍代码</td> 
            <td>邮编编码</td> 
            <td>电话</td> 
            <td>网址</td> 
            <td>电子邮箱</td> 
            <td>省/直辖市</td> 
            <td>县/市</td>
            <td>备注</td>
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="baseManufacturer" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td>
                <td>${baseManufacturer.py1}</td> 
                <td>${baseManufacturer.manChnName}</td> 
                <td>${baseManufacturer.manEngDesc}</td> 
                <td>${baseManufacturer.manAbsName}</td> 
                <td>${baseManufacturer.address}</td> 
                <td>${baseManufacturer.faxNo}</td> 
                <td>${baseManufacturer.nationCode}</td> 
                <td>${baseManufacturer.postCode}</td> 
                <td>${baseManufacturer.telNo}</td> 
                <td>${baseManufacturer.website}</td> 
                <td>${baseManufacturer.email}</td> 
                <td>${baseManufacturer.stateCode}</td> 
                <td>${baseManufacturer.cityCode}</td>
                <td>${baseManufacturer.note}</td>
                <td><img src="${path}/images/edit.gif" class="update" name="${baseManufacturer.manCode}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${baseManufacturer.manCode}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
