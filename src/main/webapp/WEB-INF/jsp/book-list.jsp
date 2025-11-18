<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books List</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css" />
</head>
<body>
    <h1>Books</h1>
    <a href="/books/add">Add New Book</a>
    <table border="1">
        <thead>
            <tr>
                <th>Title</th>
                <th>Genre</th>
                <th>Published Year</th>
                <th>Author</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.genre}</td>
                    <td>${book.publishedYear}</td>
                    <td>${book.author.name}</td>
                    <td>
                        <a href="/books/edit/${book.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
