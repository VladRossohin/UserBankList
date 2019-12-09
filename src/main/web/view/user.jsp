<%@ page import="Entity.User" %><%--
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
    User user = (User) session.getAttribute("user");
%>
    <%=
        user.getName()
    %>
    <%=
        user.getSurName()
    %>
</body>
</html>
