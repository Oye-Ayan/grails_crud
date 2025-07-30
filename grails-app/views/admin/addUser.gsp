<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:49 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
%{--<html>--}%
%{--<head><title>Add User</title></head>--}%
%{--<body>--}%
%{--<h2>Add User</h2>--}%
%{--<g:form controller="admin" action="addUser">--}%
%{--    First Name: <g:textField name="firstName"/><br/>--}%
%{--    Last Name: <g:textField name="lastName"/><br/>--}%
%{--    Email: <g:textField name="email"/><br/>--}%
%{--    Phone: <g:textField name="phone"/><br/>--}%
%{--    Title: <g:textField name="title"/><br/>--}%
%{--    Password: <g:passwordField name="password"/><br/>--}%
%{--    <g:submitButton name="submit" value="Add User"/>--}%
%{--</g:form>--}%
%{--<a href="${createLink(controller:'admin', action:'index')}">Back to Admin Dashboard</a>--}%
%{--</body>--}%
%{--</html>--}%
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Add User</title>
</head>
<body>
<h2>Add New User</h2>

<g:form controller="admin" action="addUser" method="POST">
    <label>First Name:</label>
    <g:textField name="firstName"/><br/>

    <label>Last Name:</label>
    <g:textField name="lastName"/><br/>

    <label>Email:</label>
    <g:textField name="email"/><br/>

    <label>Phone:</label>
    <g:textField name="phone"/><br/>

    <label>Title:</label>
    <g:textField name="title"/><br/>

    <label>Password:</label>
    <g:passwordField name="password"/><br/>

    <g:submitButton name="submit" value="Add User"/>
</g:form>
</body>
</html>
