<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Authors List</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css" />
</head>
<body>
    <h1>Authors</h1>
    <a href="/authors/add">Add New Author</a>
    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Nationality</th>
                <th>Birth Year</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="author" items="${authors}">
                <tr>
                    <td>${author.name}</td>
                    <td>${author.nationality}</td>
                    <td>${author.birthYear}</td>
                    <td>
                        <a href="/authors/edit/${author.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
