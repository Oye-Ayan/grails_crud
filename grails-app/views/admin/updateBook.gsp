<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 11:01 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Update Book</title></head>
<body>
<h2>Update Book</h2>
<g:form controller="admin" action="updateBook">
    Book Name (required): <g:textField name="bookName"/><br/>
    Author: <g:textField name="bookAuthor"/><br/>
    Edition: <g:textField name="bookEdition"/><br/>
    Price: <g:textField name="bookPrice"/><br/>
    Availability: <g:textField name="bookAvailable"/><br/>
    <g:submitButton name="submit" value="Update Book"/>
</g:form>
<a href="${createLink(controller:'admin', action:'showBooks')}">Back to Books</a>
</body>
</html>
