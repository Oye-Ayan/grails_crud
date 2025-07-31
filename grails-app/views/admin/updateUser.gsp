<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 11:00 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Update User</title></head>
<body>
<h2>Update User</h2>
<g:form controller="admin" action="updateUser" method="Post">
    <label>Email (required):</label>
%{--    Email (required):--}%
    <g:textField name="email"/><br/>

    <label>First Name:</label>
    <g:textField name="firstName"/><br/>

    <label>Last Name:</label>
    <g:textField name="lastName"/><br/>

%{--    <label>Email:</label>--}%
%{--    <g:textField name="email"/><br/>--}%

    <label>Phone:</label>
    <g:textField name="phone"/><br/>

    <label>Title:</label>
    <g:textField name="title"/><br/>

    <label>Password:</label>
    <g:passwordField name="password"/><br/>
%{--    Email (required): <g:textField name="email"/><br/>--}%
%{--    First Name: <g:textField name="firstName"/><br/>--}%
%{--    Last Name: <g:textField name="lastName"/><br/>--}%
%{--    Phone: <g:textField name="phone"/><br/>--}%
%{--    Title: <g:textField name="title"/><br/>--}%
%{--    Password: <g:passwordField name="password"/><br/>--}%
    <g:submitButton name="submit" value="Update User"/>
</g:form>
<a href="${createLink(controller:'admin', action:'showUsers')}">Back to Users</a>
</body>
</html>
