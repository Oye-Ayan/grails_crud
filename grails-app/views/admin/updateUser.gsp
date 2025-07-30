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
<g:form controller="admin" action="updateUser">
    Email (required): <g:textField name="email"/><br/>
    First Name: <g:textField name="firstName"/><br/>
    Last Name: <g:textField name="lastName"/><br/>
    Phone: <g:textField name="phone"/><br/>
    Title: <g:textField name="title"/><br/>
    Password: <g:passwordField name="password"/><br/>
    <g:submitButton name="submit" value="Update User"/>
</g:form>
<a href="${createLink(controller:'admin', action:'showUsers')}">Back to Users</a>
</body>
</html>
