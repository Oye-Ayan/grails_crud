<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:47 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
        color: #333;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }
    h2 {
        text-align: center;
        color: #2c3e50;
        padding: 20px 0;
        background-color: #34495e;
        color: white;
        margin: 0 0 20px 0;
        width: 100%;
    }
    form {
        width: 300px;
        margin: 0 auto;
        background-color: white;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #2c3e50;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #1abc9c;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
    }
    input[type="submit"]:hover {
        background-color: #16a085;
        transition: background-color 0.3s ease;
    }
    .error-message {
        color: #e74c3c;
        text-align: center;
        margin-bottom: 10px;
    }
    </style>
</head>
<body>
<h2>Login</h2>

<g:if test="${flash.message}">
    <div class="error-message">${flash.message}</div>
</g:if>

<g:form action="login">
    <label>Email:</label>
    <g:textField name="email"/><br/>
    <label>Password:</label>
    <g:passwordField name="password"/><br/>
    <g:submitButton name="Login" value="Login"/>
</g:form>
</body>
</html>