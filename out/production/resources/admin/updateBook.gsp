<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 11:01 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update Book</title>
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
        padding: 40px;
    }

    .form-container {
        max-width: 700px;
        margin: 0 auto;
        background-color: white;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    }

    h2.title {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 30px;
        font-size: 26px;
    }

    label {
        display: block;
        margin-top: 15px;
        font-weight: 600;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 6px;
        box-sizing: border-box;
        font-size: 14px;
    }

    .submit-btn {
        margin-top: 30px;
        text-align: center;
    }

    .radio-group {
        display: flex; /* Arranges children in a row */
        gap: 20px;     /* Adds space between the options */
        align-items: center; /* Vertically aligns them */
    }

    input[type="submit"] {
        background-color: #27ae60;
        color: white;
        padding: 12px 30px;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #219150;
    }

    .back-link {
        display: inline-block;
        margin-top: 20px;
        text-align: center;
        text-decoration: none;
        background-color: #3498db;
        color: white;
        padding: 10px 20px;
        border-radius: 6px;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }

    .back-link:hover {
        background-color: #2980b9;
    }

    </style>
</head>
<body>

<div class="sidebar">
    <h2>Admin Panel</h2>
    <a href="${createLink(controller:'admin', action:'index')}">Dashboard</a>
    <a href="${createLink(controller:'admin', action:'showUsers')}">All Users</a>
    <a href="${createLink(controller:'admin', action:'showBooks')}">All Books</a>
    <a href="${createLink(controller:'auth', action:'logout')}">Logout</a>
</div>

<div class="main-content">
    <div class="form-container">
        <h2 class="title">Update Book</h2>
        <g:form controller="admin" action="updateBook" method="POST">
            <label>Book Name (required):</label>
            <g:textField name="bookName" required="true"/>

            <label>Author:</label>
            <g:textField name="bookAuthor"/>

            <label>Edition:</label>
            <g:textField name="bookEdition"/>

            <label>Price:</label>
            <g:textField name="bookPrice"/>

            <label>Availability:</label>
            <div class="radio-group">
                <div class="radio-option">
                    <input type="radio" id="bookAvailableTrue" name="bookAvailable" value="true">
                    <label for="bookAvailableTrue">True</label>
                </div>
                <div class="radio-option">
                    <input type="radio" id="bookAvailableFalse" name="bookAvailable" value="false">
                    <label for="bookAvailableFalse">False</label>
                </div>
            </div>


            <div class="submit-btn">
                <input type="submit" value="Update Book"/>
            </div>
        </g:form>

        <div class="submit-btn">
            <a href="${createLink(controller:'admin', action:'index')}" class="back-link">← Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>
