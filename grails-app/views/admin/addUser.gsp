<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:49 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Add User</title>
    <style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
        color: #333;
    }
    h2 {
        text-align: center;
        color: #2c3e50;
        padding: 20px 0;
        background-color: #34495e;
        color: white;
        margin: 0;
    }
    .content {
        margin-left: 260px;
        padding: 20px;
    }
    form {
        width: 50%;
        margin: 20px auto;
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
    }
    input[type="submit"]:hover {
        background-color: #16a085;
        transition: background-color 0.3s ease;
    }
    a {
        display: block;
        text-align: center;
        margin-top: 20px;
        text-decoration: none;
        color: #1abc9c;
        font-weight: bold;
    }
    a:hover {
        color: #16a085;
    }
    </style>
</head>
<body>
<h2>Add New User</h2>
<div class="content">
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

        <label>Role:</label>
        <g:textField name="role"/><br/>

        <g:submitButton name="submit" value="Add User"/>
    </g:form>
    <a href="${createLink(controller:'admin', action:'index')}">Back to Admin Dashboard</a>
</div>
</body>
</html>