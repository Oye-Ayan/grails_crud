<%-- Created by IntelliJ IDEA. User: Lenovo Date: 7/29/2025 Time: 10:58 PM --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All Users</title>
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
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 12px;
        text-align: left;
        border: 1px solid #ddd;
    }
    th {
        background-color: #2c3e50;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #e0e0e0;
        transition: background-color 0.3s ease;
    }
    .content {
        margin-left: 260px;
        padding: 20px;
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
    form {
        margin: 0;
        display: inline;
    }
    input[type="submit"] {
        background-color: #e74c3c;
        color: white;
        border: none;
        padding: 5px 10px;
        cursor: pointer;
        border-radius: 3px;
    }
    input[type="submit"]:hover {
        background-color: #c0392b;
    }
    </style>
</head>
<body>
<h2>Users List</h2>
<div class="content">
    <table border="1">
        <tr>
            <th>First Name</th><th>Last Name</th><th>Email</th><th>Phone</th><th>Title</th><th>Enabled</th><th>Actions</th>
        </tr>
        <g:each in="${users}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.title}</td>
                <td>${user.enabled}</td>
                <td>
                    <g:form controller="admin" action="delUser" method="post">
                        <g:hiddenField name="email" value="${user.email}"/>
                        <g:submitButton name="delete" value="Delete"/>
                    </g:form>
                </td>
            </tr>
        </g:each>
    </table>
    <a href="${createLink(controller:'admin', action:'index')}">Back to Admin Dashboard</a>
</div>
</body>
</html>