<%@ page import="Entity.User" %>
<%@ page import="Services.UserService" %>
<%@ page import="Servlets.UserServlet" %>
<%@ page import="Services.AccountService" %><%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 05.12.2019
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>UserBankList</title>
  </head>
  <body>

  <%
      UserService userService = new UserService();
      AccountService accountService = new AccountService();
      User user = userService.getRichestUser();

  %>
  <p>Richect user:
      <b><%=user.getName()%></b>
      <b><%=user.getSurName()%></b></p><br>
  <p>Accounts sum: <b><%=accountService.getSumOfAccounts()%></b>
  </p>

  </body>
</html>
