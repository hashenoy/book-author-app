<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Author</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css" />
</head>
<body>
    <h1>Edit Author</h1>

    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>

    <form action="/authors/edit/${author.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${author.name}" required/><br/>

        <label for="nationality">Nationality:</label>
        <input type="text" id="nationality" name="nationality" value="${author.nationality}" required/><br/>

        <label for="birthYear">Birth Year:</label>
        <input type="number" id="birthYear" name="birthYear" value="${author.birthYear}" required/><br/>

        <button type="submit">Update Author</button>
    </form>
    <a href="/authors/list">Back to Author List</a>
</body>
</html>
