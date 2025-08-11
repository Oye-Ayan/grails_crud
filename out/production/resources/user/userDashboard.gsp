<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #dfe9f3, #ffffff);
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
    }

    .form-container {
        background-color: #fff;
        padding: 40px 30px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        width: 380px;
    }

    .form-header {
        text-align: center;
        margin-bottom: 30px;
    }

    .form-header h2 {
        margin: 0;
        color: #2c3e50;
        font-size: 26px;
    }

    .form-header p {
        color: #7f8c8d;
        font-size: 14px;
    }

    label {
        font-weight: 600;
        color: #2c3e50;
        display: block;
        margin-bottom: 6px;
    }

    input[type="password"] {
        width: 100%;
        padding: 10px 12px;
        border: 1px solid #ccc;
        border-radius: 6px;
        margin-bottom: 20px;
        box-sizing: border-box;
        font-size: 14px;
    }

    input[type="submit"] {
        background-color: #34495e;
        color: white;
        border: none;
        padding: 12px;
        width: 100%;
        font-size: 16px;
        font-weight: bold;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #1abc9c;
    }

    .back-button {
        margin-top: 15px;
        display: inline-block;
        text-align: center;
        background-color: #95a5a6;
        color: white;
        padding: 10px 20px;
        border-radius: 6px;
        text-decoration: none;
        font-weight: bold;
        transition: background-color 0.3s ease;
        width: 100%;
        box-sizing: border-box;
    }

    .back-button:hover {
        background-color: #7f8c8d;
    }

    .flash-message {
        color: #e74c3c;
        text-align: center;
        margin-top: 10px;
        font-size: 14px;
    }

    .footer-text {
        margin-top: 20px;
        font-size: 12px;
        color: #999;
        text-align: center;
    }

    .library-icon {
        display: block;
        margin: 0 auto 15px auto;
        width: 60px;
    }
    </style>
</head>
<body>
<div class="form-container">
    <div class="form-header">
        <img src="https://cdn-icons-png.flaticon.com/512/29/29302.png" class="library-icon" alt="Password Icon" />
        <h2>Change Password</h2>
        <p>Update your credentials securely</p>
    </div>

    <g:form action="changePassword" method="POST">
        <label for="oldPassword">Old Password:</label>
        <g:passwordField name="oldPassword" id="oldPassword" required=""/>

        <label for="newPassword">New Password:</label>
        <g:passwordField name="newPassword" id="newPassword" required=""/>

        <g:submitButton name="change" value="Change Password"/>
    </g:form>

    <a href="${createLink(controller:'user', action:'index')}" class="back-button">⬅ Back to Dashboard</a>


    <g:if test="${flash.message}">
        <div class="flash-message">${flash.message}</div>
    </g:if>

    <div class="footer-text">
        &copy; MAK
    </div>
</div>
</body>
</html>
