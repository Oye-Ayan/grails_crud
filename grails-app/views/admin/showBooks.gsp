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
        margin: 0 0 20px 0;
        width: 100%;
    }
    table {
        width: 90%;
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
    g\\:submitButton {
        background-color: #e74c3c;
        color: white;
        padding: 8px 12px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-weight: bold;
    }
    g\\:submitButton:hover {
        background-color: #c0392b;
    }
    a {
        display: block;
        text-align: center;
        margin: 30px auto;
        text-decoration: none;
        color: #1abc9c;
        font-weight: bold;
        font-size: 16px;
    }
    a:hover {
        color: #16a085;
    }
    </style>
</head>
<body>
<h2>Books List</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Author</th>
        <th>Edition</th>
        <th>Price</th>
        <th>Available</th>
        <th>Action</th>
    </tr>
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
                    <g:submitButton name="delete" value="Delete"/>
                </g:form>
            </td>
        </tr>
    </g:each>
</table>
<a href="${createLink(controller:'admin', action:'index')}">Back to Admin Dashboard</a>
</body>
</html>
