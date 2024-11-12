<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JStorybook</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
    <h1>JStorybook</h1>
    <p>Found ${stories.size()} stories:</p>
    <ul>
        <c:forEach items="${stories}" var="story">
            <li>
                <a href="${story.url}">${story.name}</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
