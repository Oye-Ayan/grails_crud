<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 11:12 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Admin Panel</title></head>
<body>
<h2>Welcome Admin</h2>
<ul>
    <li><g:link action="addUser">Add User</g:link></li>
    <li><g:link action="showUsers">Show Users</g:link></li>
    <li><g:link action="addBook">Add Book</g:link></li>
    <li><g:link action="showBooks">Show Books</g:link></li>
    <li><g:link controller="login" action="logout">Logout</g:link></li>
</ul>
</body>
</html>
