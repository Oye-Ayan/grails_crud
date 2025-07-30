<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/30/2025
  Time: 12:40 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Purchased Books</title>
</head>
<body>
<h1>My Purchased Books</h1>

<g:if test="${books?.size() > 0}">
    <table border="1">
        <thead>
        <tr>
            <th>Book Name</th>
            <th>Author</th>
            <th>Edition</th>
            <th>Price</th>
            <th>Availability</th>
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
            </tr>
        </g:each>
        </tbody>
    </table>
</g:if>

<g:else>
    <p>You have not purchased any books yet.</p>
</g:else>

<br>
<a href="${createLink(controller:'user', action:'index')}">Back to User Dashboard</a>
</body>
</html>
