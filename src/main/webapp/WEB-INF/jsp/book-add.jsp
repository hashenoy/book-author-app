<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add New Book</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css" />
</head>
<body>
    <h1>Add Book</h1>

    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>

    <form action="/books/add" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${book.title}" required/><br/>

        <label for="genre">Genre:</label>
        <input type="text" id="genre" name="genre" value="${book.genre}" required/><br/>

        <label for="publishedYear">Published Year:</label>
        <input type="number" id="publishedYear" name="publishedYear" value="${book.publishedYear}" required/><br/>

        <label for="author">Author:</label>
        <select id="author" name="author.id" required>
            <option value="">Select Author</option>
            <c:forEach var="author" items="${authors}">
                <option value="${author.id}">${author.name}</option>
            </c:forEach>
        </select><br/>

        <button type="submit">Add Book</button>
    </form>
    <a href="/books/list">Back to Book List</a>
</body>
</html>
