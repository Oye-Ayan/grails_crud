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
    <meta name="layout" content="main"/>
    <title>Add Book</title>
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
    input[type="text"] {
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
<h2>Add New Book</h2>
<div class="content">
    <g:form controller="admin" action="addBook" method="POST">
        <label>Book Name:</label>
        <g:textField name="bookName"/><br/>

        <label>Author:</label>
        <g:textField name="bookAuthor"/><br/>

        <label>Price:</label>
        <g:textField name="bookPrice"/><br/>

        <label>Availability?:</label>
        <g:textField name="bookAvailable"/><br/>

        <label>Edition:</label>
        <g:textField name="bookEdition"/><br/>

        <g:submitButton name="submit" value="Add Book"/>
    </g:form>
    <a href="${createLink(controller: 'admin', action: 'showBooks')}">Back to Books List</a>
</div>
</body>
</html>