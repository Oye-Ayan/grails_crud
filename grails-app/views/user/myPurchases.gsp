<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 8/1/2025
  Time: 4:47 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>My Purchases</title>
</head>
<body>
<h2>📚 Your Purchased Books</h2>
<table border="1">
    <tr>
        <th>Book Name</th>
        <th>Author</th>
        <th>Date Purchased</th>
    </tr>
    <g:each in="${purchases}" var="p">
        <tr>
            <td>${p.book.bookName}</td>
            <td>${p.book.bookAuthor}</td>
            <td><g:formatDate date="${p.date}" format="dd-MM-yyyy HH:mm"/></td>
        </tr>
    </g:each>
</table>

<br><br>
<h2>🏆 Top Purchased Books</h2>
<table border="1">
    <tr>
        <th>Book Name</th>
        <th>Author</th>
        <th>Times Purchased</th>
    </tr>
    <g:each in="${topBooks}" var="entry">
        <tr>
            <td>${entry.book.bookName}</td>
            <td>${entry.book.bookAuthor}</td>
            <td>${entry.count}</td>
        </tr>
    </g:each>

</table>
<br>
<a href="${createLink(controller:'user', action:'index')}">Back to User Dashboard</a>

</body>
</html>
