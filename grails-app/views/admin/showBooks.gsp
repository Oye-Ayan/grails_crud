<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:59 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>All Books</title></head>
<body>
<h2>Books List</h2>
<table border="1">
    <tr>
        <th>Name</th><th>Author</th><th>Edition</th><th>Price</th><th>Available</th>
    </tr>
    <g:each in="${books}" var="book">
        <tr>
            <td>${book.bookName}</td>
            <td>${book.bookAuthor}</td>
            <td>${book.bookEdition}</td>
            <td>${book.bookPrice}</td>
            <td>${book.bookAvailable}</td>
        </tr>
    </g:each>
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

</table>
<a href="${createLink(controller:'admin', action:'index')}">Back to Admin Dashboard</a>
</body>
</html>
