<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Purchases</title>
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #ecf0f1;
        color: #2c3e50;
        margin: 0;
        padding: 0;
    }
    h1 {
        background-color: #2c3e50;
        color: white;
        padding: 20px;
        text-align: center;
        margin: 0;
        font-size: 28px;
    }
    .content {
        padding: 30px;
    }
    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 20px;
    }
    table {
        width: 95%;
        margin: 0 auto 40px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        border-radius: 8px;
        overflow: hidden;
    }
    th, td {
        padding: 14px 18px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #34495e;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #dfe6e9;
    }
    .no-purchases {
        text-align: center;
        font-size: 18px;
        color: #7f8c8d;
        margin-top: 40px;
    }
    .back-button {
        display: block;
        width: fit-content;
        margin: 30px auto 0 auto;
        text-decoration: none;
        background-color: #1abc9c;
        color: white;
        padding: 12px 24px;
        border-radius: 6px;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }
    .back-button:hover {
        background-color: #16a085;
    }
    </style>
</head>
<body>
<h1>My Purchases</h1>
<div class="content">
    <g:if test="${purchases?.size() > 0}">
        <h2>Your Purchased Books</h2>
        <table>
            <thead>
            <tr>
                <th>Book Name</th>
                <th>Author</th>
                <th>Edition</th>
                <th>Price</th>
                <th>Availability</th>
                <th>Purchased On</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${purchases}" var="purchase">
                <tr>
                    <td>${purchase.book.bookName}</td>
                    <td>${purchase.book.bookAuthor}</td>
                    <td>${purchase.book.bookEdition}</td>
                    <td>${purchase.book.bookPrice}</td>
                    <td>${purchase.book.bookAvailable}</td>
                    <td>${purchase.date}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </g:if>
    <g:else>
        <p class="no-purchases">You have not purchased any books yet.</p>
    </g:else>

    <g:if test="${topBooks?.size() > 0}">
        <h2>Top Purchased Books</h2>
        <table>
            <thead>
            <tr>
                <th>Book Name</th>
                <th>Author</th>
                <th>Edition</th>
                <th>Times Purchased</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${topBooks}" var="entry">
                <tr>
                    <td>${entry.book.bookName}</td>
                    <td>${entry.book.bookAuthor}</td>
                    <td>${entry.book.bookEdition}</td>
                    <td>${entry.count}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </g:if>

    <a class="back-button" href="${createLink(controller:'user', action:'index')}">← Back to User Dashboard</a>
</div>
</body>
</html>