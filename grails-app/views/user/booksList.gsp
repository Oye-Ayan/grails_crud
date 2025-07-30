<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 11:11 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Available Books</title></head>
<body>
<h2>Books Available</h2>

<table border="1">
%{--    <tr>--}%
%{--        <th>Name</th><th>Author</th><th>Edition</th><th>Price</th><th>Available</th>--}%
%{--    </tr>--}%
%{--    <g:each in="${books}" var="book">--}%
%{--        <tr>--}%
%{--            <td>${book.bookName}</td>--}%
%{--            <td>${book.bookAuthor}</td>--}%
%{--            <td>${book.bookEdition}</td>--}%
%{--            <td>${book.bookPrice}</td>--}%
%{--            <td>${book.bookAvailable}</td>--}%
%{--        </tr>--}%
%{--    </g:each>--}%
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
                <g:form controller="user" action="purchaseBook">
                    <g:hiddenField name="bookId" value="${book.id}" />
                    <g:submitButton name="purchase" value="Buy" onclick="alert('Purchased successfully');" />                </g:form>
            </td>
        </tr>
    </g:each>
    </tbody>

</table>

<li><g:link action="myBooks">My Books</g:link></li>
<a href="${createLink(controller:'user', action:'index')}">Back to User Dashboard</a>
</body>
</html>
