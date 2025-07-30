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
</head>
<body>
<h2>Add New Book</h2>

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
</body>
</html>
