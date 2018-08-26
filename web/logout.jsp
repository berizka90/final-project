<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 19.08.2018
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% session.invalidate();
response.sendRedirect("home.jsp");%>
</body>
</html>
