<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 7/29/2025
  Time: 10:53 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html><body>
<h2>User Dashboard</h2>
<ul>
    <li><g:link action="booksList">View Books</g:link></li>
    <li>
        <g:form action="changePassword">
            Old Password: <g:passwordField name="oldPassword" /><br/>
            New Password: <g:passwordField name="newPassword" /><br/>
            <g:submitButton name="change" value="Change Password"/>
        </g:form>
    </li>
    <li><g:link controller="login" action="logout">Logout</g:link></li>
</ul>
<g:if test="${flash.message}">${flash.message}</g:if>
</body></html>
