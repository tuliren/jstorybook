<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- 
Story: Button
Description: Description of the Button
Props:
  - content: string | Main content for the component
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Button Story</title>
    <style>
        .button {
            /* Component styles here */
        }
    </style>
</head>
<body>
    <h2>Button Examples</h2>
    
    <h3>Default</h3>
    <jsp:include page="/components/Button.jsp">
        <jsp:param name="content" value="Default Content" />
    </jsp:include>

    <h3>Custom Content</h3>
    <jsp:include page="/components/Button.jsp">
        <jsp:param name="content" value="Custom Content Example" />
    </jsp:include>
</body>
</html>
