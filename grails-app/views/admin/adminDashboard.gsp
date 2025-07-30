<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:51 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html><body>
<h2>Admin Dashboard</h2>
<ul>
    <li><g:link action="addUser">Add User</g:link></li>
    <li><g:link action="showUsers">View Users</g:link></li>
    <li><g:link action="addBook">Add Book</g:link></li>
    <li><g:link action="showBooks">View Books</g:link></li>
    <li><g:link controller="login" action="logout">Logout</g:link></li>
</ul>
</body></html>
