<%-- Created by IntelliJ IDEA. User: Lenovo Date: 7/29/2025 Time: 10:49 PM --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
%{--    <meta name="layout" content="main"/>--}%
    <title>Add User</title>
    <style>
    body {
        margin: 0;
        padding: 0;
        background-color: #eef2f7;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .wrapper {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        padding: 40px 20px;
        box-sizing: border-box;
    }

    .card {
        background-color: white;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
        max-width: 1000px;
        width: 100%;
    }

    h2 {
        text-align: center;
        margin-bottom: 30px;
        color: #2c3e50;
        font-size: 28px;
    }

    .form-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
        gap: 20px;
    }

    label {
        display: block;
        margin-bottom: 6px;
        font-weight: 600;
        color: #333;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        font-size: 14px;
        border: 1px solid #ccc;
        border-radius: 6px;
        box-sizing: border-box;
        margin-bottom: 10px;
    }

    .form-actions {
        grid-column: 1 / -1;
        text-align: center;
        margin-top: 20px;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: white;
        padding: 12px 30px;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    .back-link {
        display: inline-block;
        margin-top: 20px;
        text-align: center;
        text-decoration: none;
        color: #007bff;
        font-weight: 500;
    }

    .back-link:hover {
        color: #0056b3;
    }

    @media (max-width: 768px) {
        .form-actions {
            grid-column: span 1;
        }
    }
    </style>
</head>
<body>
<div class="wrapper">
    <div class="card">
        <h2>Add New User</h2>
        <g:form controller="admin" action="addUser" method="POST">
            <div class="form-grid">
                <div>
                    <label>First Name:</label>
                    <g:textField name="firstName"/>
                </div>
                <div>
                    <label>Last Name:</label>
                    <g:textField name="lastName"/>
                </div>
                <div>
                    <label>Email:</label>
                    <g:textField name="email"/>
                </div>
                <div>
                    <label>Phone:</label>
                    <g:textField name="phone"/>
                </div>
                <div>
                    <label>Title:</label>
                    <g:textField name="title"/>
                </div>
                <div>
                    <label>Role:</label>
                    <g:textField name="role"/>
                </div>
                <div>
                    <label>Password:</label>
                    <g:passwordField name="password"/>
                </div>
            </div>
            <div class="form-actions">
                <input type="submit" value="Add User"/>
                <br>
                <a href="${createLink(controller:'admin', action:'index')}" class="back-link">← Back to Admin Dashboard</a>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>
