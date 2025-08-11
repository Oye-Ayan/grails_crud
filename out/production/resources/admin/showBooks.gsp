<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:59 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All Books</title>
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

    form {
        margin: 0;
        display: inline;
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

    .center-btn {
        text-align: center;
        margin-top: 30px;
    }

    .back-link {
        display: inline-block;
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
    </style>
</head>
<body>

<div class="sidebar">
    <h2>Admin Panel</h2>
    <a href="${createLink(controller:'admin', action:'index')}">Dashboard</a>
    <a href="${createLink(controller:'admin', action:'addBook')}">Add Book</a>
    <a href="${createLink(controller:'admin', action:'addUser')}">Add User</a>
    <a href="${createLink(controller:'auth', action:'logout')}">Logout</a>
</div>

<div class="main-content">
    <h2 class="title">Books List</h2>

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Author</th>
            <th>Edition</th>
            <th>Price</th>
            <th>Available</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${books}" var="book">
            <tr>
                <td>${book.bookName}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.bookEdition}</td>
                <td>${book.bookPrice}</td>
                <td>${book.bookAvailable}</td>
                <td>
                    <g:form controller="admin" action="delBook" method="post">
                        <g:hiddenField name="bookName" value="${book.bookName}"/>
                        <input type="submit" value="Delete"/>
                    </g:form>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="center-btn">
        <a href="${createLink(controller:'admin', action:'index')}" class="back-link">Back to Admin Dashboard</a>
    </div>
</div>

</body>
</html>
