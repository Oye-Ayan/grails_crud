<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
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

    .login-container {
        background-color: #fff;
        padding: 40px 30px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        width: 380px;
    }

    .login-header {
        text-align: center;
        margin-bottom: 30px;
    }

    .login-header h2 {
        margin: 0;
        color: #2c3e50;
        font-size: 26px;
    }

    .login-header p {
        color: #7f8c8d;
        font-size: 14px;
    }

    label {
        font-weight: 600;
        color: #2c3e50;
        display: block;
        margin-bottom: 6px;
    }

    input[type="text"], input[type="password"] {
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

    .error-message {
        color: #e74c3c;
        text-align: center;
        margin-top: 15px;
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
<div class="login-container">
    <div class="login-header">
        <img src="https://cdn-icons-png.flaticon.com/512/29/29302.png" class="library-icon" alt="Library Icon" />
        <h2>Login</h2>
        <p>Access your account to manage books & purchases</p>
    </div>

    <g:form controller="auth" action="loginSubmit" method="POST">
        <label for="email">Email:</label>
        <g:textField name="email" id="email" required=""/>

        <label for="password">Password:</label>
        <g:passwordField name="password" id="password" required=""/>

        <g:submitButton name="Login" value="Login"/>
    </g:form>

    <g:if test="${flash.message}">
        <p class="error-message">${flash.message}</p>
    </g:if>

    <div class="footer-text">
        &copy; MAK
    </div>
</div>
</body>
</html>
