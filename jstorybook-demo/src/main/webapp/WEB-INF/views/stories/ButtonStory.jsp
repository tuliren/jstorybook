<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Button Story</title>
    <style>
        .button { margin: 10px; }
        .btn {
            padding: 8px 16px;
            border-radius: 4px;
            border: none;
            cursor: pointer;
        }
        .btn.primary {
            background: #007bff;
            color: white;
        }
        .btn.secondary {
            background: #6c757d;
            color: white;
        }
    </style>
</head>
<body>
    <h2>Button Examples</h2>

    <h3>Primary Button</h3>
    <jsp:include page="/components/Button.jsp">
        <jsp:param name="content" value="Click Me" />
        <jsp:param name="variant" value="primary" />
    </jsp:include>

    <h3>Secondary Button</h3>
    <jsp:include page="/components/Button.jsp">
        <jsp:param name="content" value="Secondary Action" />
        <jsp:param name="variant" value="secondary" />
    </jsp:include>
</body>
</html>
