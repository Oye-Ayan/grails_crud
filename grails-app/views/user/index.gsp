<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 11:13 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>User Dashboard</title></head>
<body>
<h2>Welcome User</h2>
<ul>
    <li><g:link action="booksList">View Books</g:link></li>
    <li><g:link action="myBooks">My Books</g:link></li>
    <li><g:link action="changePassword">Change Password</g:link></li>
    <li><g:link controller="login" action="logout">Logout</g:link></li>
</ul>
</body>
</html>
