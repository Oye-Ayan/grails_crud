<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Panel</title>
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #dfe9f3, #ffffff);
        margin: 0;
        padding: 0;
        color: #2c3e50;
    }

    .container {
        display: flex;
        min-height: 100vh;
    }

    .sidebar {
        width: 250px;
        background-color: #34495e;
        color: white;
        display: flex;
        flex-direction: column;
        padding-top: 40px;
        box-shadow: 4px 0 12px rgba(0,0,0,0.1);
    }

    .sidebar h2 {
        text-align: center;
        margin-bottom: 30px;
        font-weight: 600;
        font-size: 22px;
        color: #ecf0f1;
    }

    .nav-link {
        text-decoration: none;
        color: white;
        padding: 14px 30px;
        font-size: 15px;
        transition: background 0.3s ease, padding-left 0.3s ease;
        border-bottom: 1px solid rgba(255, 255, 255, 0.1);
    }

    .nav-link:hover {
        background-color: #1abc9c;
        padding-left: 40px;
    }

    .content {
        flex: 1;
        padding: 60px 40px;
    }

    .welcome-card {
        background-color: white;
        padding: 40px 30px;
        border-radius: 12px;
        box-shadow: 0 6px 20px rgba(0,0,0,0.08);
        max-width: 700px;
        margin: 0 auto;
        text-align: center;
    }

    .welcome-card h3 {
        margin-top: 0;
        font-size: 28px;
        color: #2c3e50;
    }

    .welcome-card p {
        font-size: 16px;
        color: #7f8c8d;
        margin-top: 10px;
    }

    </style>
</head>
<body>
<div class="container">
    <div class="sidebar">
        <h2>Admin Panel</h2>
        <g:link class="nav-link" action="addUser">Add User</g:link>
        <g:link class="nav-link" action="showUsers">Show Users</g:link>
        <g:link class="nav-link" action="addBook">Add Books</g:link>
        <g:link class="nav-link" action="showBooks">Show Books</g:link>
        <g:link class="nav-link" controller="auth" action="logout">Logout</g:link>
    </div>

    <div class="content">
        <div class="welcome-card">
            <h3>Welcome, Admin</h3>
            <p>Use the sidebar to manage users and books easily.</p>
        </div>
    </div>
</div>
</body>
</html>
