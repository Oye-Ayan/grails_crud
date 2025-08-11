<%-- Created by IntelliJ IDEA. User: Lenovo Date: 7/29/2025 Time: 10:58 PM --%>
<%--
    Redesigned All Users Page
    Styled to match the modern Available Books and Dashboard UI
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All Users</title>
    <style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f6f8;
    }

    .sidebar {
        width: 250px;
        height: 100vh;
        background-color: #2c3e50;
        position: fixed;
        left: 0;
        top: 0;
        padding-top: 40px;
        box-shadow: 2px 0 5px rgba(0,0,0,0.1);
    }

    .sidebar h2 {
        color: white;
        text-align: center;
        margin-bottom: 30px;
    }

    .sidebar a {
        display: block;
        color: white;
        padding: 15px 30px;
        text-decoration: none;
        font-size: 16px;
        transition: background-color 0.3s ease;
    }

    .sidebar a:hover {
        background-color: #34495e;
    }

    .main-content {
        margin-left: 250px;
        padding: 30px;
    }

    h2.title {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 30px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    }

    th, td {
        padding: 12px 16px;
        border: 1px solid #e0e0e0;
        text-align: left;
    }

    th {
        background-color: #2c3e50;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #ecf0f1;
    }

    input[type="submit"] {
        background-color: #e74c3c;
        color: white;
        border: none;
        padding: 6px 12px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 14px;
    }

    input[type="submit"]:hover {
        background-color: #c0392b;
    }

    .back-link {
        display: inline-block;
        margin-top: 30px;
        text-decoration: none;
        background-color: #3498db;
        color: white;
        padding: 10px 20px;
        border-radius: 5px;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }

    .back-link:hover {
        background-color: #2980b9;
    }

    .center-btn {
        text-align: center;
        margin-top: 20px;
    }
    </style>
</head>
<body>

<div class="sidebar">
    <h2>Admin Panel</h2>
    <a href="${createLink(controller:'admin', action:'index')}">Dashboard</a>
    <a href="${createLink(controller:'admin', action:'addUser')}">Add User</a>
    <a href="${createLink(controller:'admin', action:'showBooks')}">All Books</a>
    <a href="${createLink(controller:'auth', action:'logout')}">Logout</a>
</div>

<div class="main-content">
    <h2 class="title">All Registered Users</h2>

    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Title</th>
            <th>Enabled</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
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
                        <g:hiddenField name="email" value="${user.email}" />
                        <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this user?');" />
                    </g:form>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="center-btn">
        <a href="${createLink(controller:'admin', action:'index')}" class="back-link">← Back to Admin Dashboard</a>
    </div>
</div>

</body>
</html>
