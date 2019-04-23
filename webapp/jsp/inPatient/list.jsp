<%-- 
  Created by IntelliJ IDEA. 
  2019/01/15 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () {
                var $count="1=1";
                $.each($('input[name=box]'),function(){
                    if(this.checked){
                        $count+=("&patientId="+$(this).val());
                    }
                });
                location.href="${path}/inPatient/batchChange.action?"+$count;
             })
            $(".update").click(function () { 
                var patientId = $(this).attr("name");
                location.href="${path}/inPatient/load.action?patientId="+patientId;
             })
            $(".delete").click(function () { 
                var patientId = $(this).attr("name");
                location.href="${path}/inPatient/delete.action?patientId="+patientId;
             })
            $("#search").click(function () { 
                var patientName = $("#patientName").val();
                var status = $("#status").val();
                location.href = "${path}/inPatient/search.action?patientName="+patientName+"&status="+status;
             })
            $("#status").val("${searchObject.status}");
            //给全选的复选框添加事件
            $("#all").click(function () {
                // this 全选的复选框
                var userids=this.checked;
                //获取name=box的复选框 遍历输出复选框
                 $("input[name=box]").each(function(){
                    this.checked=!this.checked;
                 });
            })
            //给name=box的复选框绑定单击事件
            $("input[name=box]").click(function(){
                             //获取选中复选框长度
                             var length=$("input[name=box]:checked").length;
                             //未选中的长度
                             var len=$("input[name=box]").length;
                             if(length==len){
                                     $("#all").get(0).checked=true;
                                 }else{
                                     $("#all").get(0).checked=false;
                                 }
                         });
            // 隐藏出院
            $("#hide").click(function () {
                location.href="${path}/inPatient/search2.action?status=1";
            })
            //显示出院
            $("#display").click(function () {
                location.href="${path}/inPatient/list.action";
            })
            var index=0;
            $("table tr").each(function(i){
                if($($(this).find("td").get(6)).text()=='${maxAmount}'){
                    index=i;
                }
            })
            $("table tr:nth-child("+index+")").css("color","#ff000f")
            $("#Output").click(function () {
                location.href="${path}/inPatient/output.action";
                alert("输出完毕");
            })
            $("#riqi").click(function () {
                    location.href="${path}/inPatient/sort.action";
            })
        })
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            病人姓名：<input type="text" id="patientName" value="${searchObject.patientName}">
            状态：<select id="status">
                    <option></option>
                    <option value="1">在院</option>
                    <option value="2">出院</option>
                </select>
            <%--状态：<input type="text" id="status" value="${searchObject.status}">--%>
        </span>
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">出院</button>
        </span>
        <span>
            <button id="hide">隐藏出院</button>
        </span>
        <span>
            <button id="display">显示出院</button>
        </span>
        <span>
            <button id="Output">输出</button>
        </span>
    </div> 
    <table> 
        <thead>
            <td><input type="checkbox" id="all"></td>
            <td>序号</td> 
            <td>病人姓名</td> 
            <td>性别</td> 
            <td id="riqi">出生日期</td>
            <td>床号</td> 
            <td>消费金额</td> 
            <td>1:在院2:出院</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="inPatient" varStatus="status"> 
            <tr>
                <td><input type="checkbox" value="${inPatient.patientId}" name="box"></td>
                <td>${status.index+1}</td> 
                <td>${inPatient.patientName}</td> 
                <td>${inPatient.sex}</td> 
                <td>${inPatient.birth}</td> 
                <td>${inPatient.bedNum}</td> 
                <td>${inPatient.amount}</td>
                <c:if test="${inPatient.status==1}">
                    <td>在院</td>
                </c:if>
                <c:if test="${inPatient.status==2}">
                    <td>出院</td>
                </c:if>
                <%--<td>${inPatient.status}</td> --%>
                <td><img src="${path}/images/edit.gif" class="update" name="${inPatient.patientId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${inPatient.patientId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
