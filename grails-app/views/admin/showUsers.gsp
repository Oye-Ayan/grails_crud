<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:58 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>All Users</title></head>
<body>
<h2>Users List</h2>
<table border="1">
    <tr>
        <th>First Name</th><th>Last Name</th><th>Email</th><th>Phone</th><th>Title</th><th>Enabled</th>

    </tr>
    <g:each in="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.title}</td>
            <td>${user.enabled}</td>
        </tr>
    </g:each>
    <tr>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.email}</td>
        <td>${user.phone}</td>
        <td>${user.title}</td>
        <td>${user.enabled}</td>
        <td>
            <g:form controller="admin" action="delUser" method="post">
                <g:hiddenField name="email" value="${user.email}"/>
                <g:submitButton name="delete" value="Delete"/>
            </g:form>
        </td>
    </tr>

</table>
<a href="${createLink(controller:'admin', action:'index')}">Back to Admin Dashboard</a>
</body>
</html>
