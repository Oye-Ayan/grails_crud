<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:47 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>

<g:if test="${flash.message}">
    <div style="color:red">${flash.message}</div>
</g:if>

<g:form action="login">
    Email: <g:textField name="email" /><br/>
    Password: <g:passwordField name="password" /><br/>
    <g:submitButton name="Login" value="Login"/>
</g:form>
</body>
</html>
