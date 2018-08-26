<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Registration Form</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Contacts</h2>
        </div>
        <c:if test="${!empty name}">
            <table class="w3-table w3-bordered w3-striped">
                <c:forEach var="user" items="${name}">
                    <jsp:useBean id="user" class="model.entity.User"/>
                    <tr class="w3-teal">
                        <th>Id</th>
                        <th>Name</th>
                        <th>Login</th>
                        <th>Role</th>
                    </tr>
                    <tr>
                        <td><c:out value="${user.idUser}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.login}"/></td>
                        <td><c:out value="${user.role}"/></td>

                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>