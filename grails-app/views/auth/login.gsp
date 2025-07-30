<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 11:49 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>

<g:form controller="auth" action="loginSubmit" method="POST">
    <label>Email:</label>
    <g:textField name="email"/><br/>

    <label>Password:</label>
    <g:passwordField name="password"/><br/>

    <g:submitButton name="Login" value="Login"/>
</g:form>

<g:if test="${flash.message}">
    <p style="color:red;">${flash.message}</p>
</g:if>
</body>
</html>
