%{--<%----}%
%{--  Created by IntelliJ IDEA.--}%
%{--  User: Lenovo--}%
%{--  Date: 7/30/2025--}%
%{--  Time: 12:40 PM--}%
%{----%>--}%

%{--<%@ page contentType="text/html;charset=UTF-8" %>--}%
%{--<!DOCTYPE html>--}%
%{--<html>--}%
%{--<head>--}%
%{--    <title>My Purchased Books</title>--}%
%{--    <style>--}%
%{--    body {--}%
%{--        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;--}%
%{--        background-color: #f4f4f4;--}%
%{--        margin: 0;--}%
%{--        padding: 0;--}%
%{--        color: #333;--}%
%{--    }--}%

%{--    h1 {--}%
%{--        text-align: center;--}%
%{--        background-color: #34495e;--}%
%{--        color: #fff;--}%
%{--        margin: 0;--}%
%{--        padding: 20px 0;--}%
%{--        font-size: 26px;--}%
%{--    }--}%

%{--    .content {--}%
%{--        margin: 30px auto;--}%
%{--        width: 85%;--}%
%{--        max-width: 1000px;--}%
%{--    }--}%

%{--    table {--}%
%{--        width: 100%;--}%
%{--        border-collapse: collapse;--}%
%{--        background-color: #fff;--}%
%{--        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);--}%
%{--    }--}%

%{--    th, td {--}%
%{--        padding: 14px;--}%
%{--        border: 1px solid #ddd;--}%
%{--        text-align: left;--}%
%{--    }--}%

%{--    th {--}%
%{--        background-color: #2c3e50;--}%
%{--        color: #fff;--}%
%{--    }--}%

%{--    tr:nth-child(even) {--}%
%{--        background-color: #f9f9f9;--}%
%{--    }--}%

%{--    tr:hover {--}%
%{--        background-color: #e0e0e0;--}%
%{--        transition: background-color 0.3s ease;--}%
%{--    }--}%

%{--    .no-purchases {--}%
%{--        text-align: center;--}%
%{--        font-size: 18px;--}%
%{--        color: #7f8c8d;--}%
%{--        margin: 40px 0;--}%
%{--        font-weight: bold;--}%
%{--    }--}%

%{--    .back-link {--}%
%{--        display: block;--}%
%{--        text-align: center;--}%
%{--        margin: 30px 0 10px 0;--}%
%{--        text-decoration: none;--}%
%{--        color: #1abc9c;--}%
%{--        font-size: 16px;--}%
%{--        font-weight: bold;--}%
%{--    }--}%

%{--    .back-link:hover {--}%
%{--        color: #16a085;--}%
%{--    }--}%

%{--    </style>--}%
%{--</head>--}%
%{--<body>--}%
%{--<h1>My Purchased Books</h1>--}%

%{--<div class="content">--}%
%{--    <g:if test="${books?.size() > 0}">--}%
%{--        <table>--}%
%{--            <thead>--}%
%{--            <tr>--}%
%{--                <th>Book Name</th>--}%
%{--                <th>Author</th>--}%
%{--                <th>Edition</th>--}%
%{--                <th>Price</th>--}%
%{--                <th>Availability</th>--}%
%{--            </tr>--}%
%{--            </thead>--}%
%{--            <tbody>--}%
%{--            <g:each in="${books}" var="book">--}%
%{--                <tr>--}%
%{--                    <td>${book.bookName}</td>--}%
%{--                    <td>${book.bookAuthor}</td>--}%
%{--                    <td>${book.bookEdition}</td>--}%
%{--                    <td>${book.bookPrice}</td>--}%
%{--                    <td>${book.bookAvailable}</td>--}%
%{--                </tr>--}%
%{--            </g:each>--}%
%{--            </tbody>--}%
%{--        </table>--}%
%{--    </g:if>--}%

%{--    <g:else>--}%
%{--        <p class="no-purchases">You have not purchased any books yet.</p>--}%
%{--    </g:else>--}%

%{--    <a class="back-link" href="${createLink(controller:'user', action:'index')}">← Back to User Dashboard</a>--}%
%{--</div>--}%
%{--</body>--}%
%{--</html>--}%
