<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:56 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
%{--    <meta name="layout" content="main"/>--}%
    <title>Add Book</title>
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
        padding: 40px 20px;
    }

    .card {
        background-color: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
        max-width: 600px;
        width: 100%;
    }

    h2 {
        text-align: center;
        margin-bottom: 30px;
        color: #2c3e50;
        font-size: 28px;
    }

    label {
        display: block;
        margin-bottom: 6px;
        font-weight: 600;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        font-size: 14px;
        border: 1px solid #ccc;
        border-radius: 6px;
        box-sizing: border-box;
        margin-bottom: 15px;
    }

    input[type="submit"], .back-link {
        display: inline-block;
        background-color: #0056b3;
        color: white;
        padding: 12px 30px;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        text-decoration: none;
        text-align: center;
        margin-top: 20px;
    }

    .radio-group {
        display: flex; /* Arranges children in a row */
        gap: 20px;     /* Adds space between the options */
        align-items: center; /* Vertically aligns them */
    }

    input[type="submit"]:hover, .back-link:hover {
        background-color: #16a085;
    }

    .actions {
        text-align: center;
    }
    </style>
</head>
<body>
<div class="wrapper">
    <div class="card">
        <h2>Add New Book</h2>
        <g:form controller="admin" action="addBook" method="POST">
            <label>Book Name:</label>
            <g:textField name="bookName"/>

            <label>Author:</label>
            <g:textField name="bookAuthor"/>

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

            <label>Edition:</label>
            <g:textField name="bookEdition"/>

            <div class="actions">
                <input type="submit" value="Add Book"/>
                <br/>
                <a href="${createLink(controller: 'admin', action: 'showBooks')}" class="back-link">← Back to Books List</a>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>
