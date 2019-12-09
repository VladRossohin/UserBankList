<%@ page import="Entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 09.12.2019
  Time: 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
    Long sum = (Long) session.getAttribute("sum");
%>

<%=
    sum
%>
</body>
</html>
