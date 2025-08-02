<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:51 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Dashboard</title>
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
    ul {
        list-style-type: none;
        width: 250px;
        margin: 0;
        padding: 0;
        background-color: #2c3e50;
        height: 100vh;
        position: fixed;
        top: 0;
        left: 0;
    }
    li {
        padding: 15px 20px;
        border-bottom: 1px solid #34495e;
    }
    li:last-child {
        border-bottom: none;
    }
    li a {
        text-decoration: none;
        color: white;
        font-size: 16px;
        display: block;
    }
    li a:hover {
        color: #1abc9c;
        background-color: #34495e;
        padding-left: 25px;
        transition: all 0.3s ease;
    }
    .content {
        margin-left: 260px;
        padding: 20px;
        min-height: 100vh;
    }
    </style>
</head>
<body>
<h2>Admin Dashboard</h2>
<ul>
    <li><g:link action="addUser">Add User</g:link></li>
    <li><g:link action="showUsers">View Users</g:link></li>
    <li><g:link action="addBook">Add Book</g:link></li>
    <li><g:link action="showBooks">View Books</g:link></li>
    <li><g:link controller="login" action="logout">Logout</g:link></li>
</ul>
<div class="content">
    <p>Welcome to the Admin Dashboard! Manage users and books efficiently.</p></div>
</body>
</html>