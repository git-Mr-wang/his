<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26 0026
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>首页</title>
    <script>
        $(function () {
            $(document).attr("title","商丘市公疗医院");
        })
    </script>
</head>

<frameset rows="60,*" border="0">
    <frame src="${path}/jsp/index/top.jsp" name="topFrame" scrolling="NO">
    <frameset cols="240,*" >
        <frame src="${path}/jsp/index/left.jsp" name="leftFrame" scrolling="yes">
        <frame src="${path}/jsp/index/main.jsp" name="mainFrame" scrolling="YES">
    </frameset>
</frameset>

</html>
