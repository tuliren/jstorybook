<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="story-preview">
    <h2>Button Component</h2>

    <div class="story-section">
        <h3>Primary Button</h3>
        <jsp:include page="/components/Button.jsp">
            <jsp:param name="content" value="Click Me" />
            <jsp:param name="variant" value="primary" />
        </jsp:include>
    </div>

    <div class="story-section">
        <h3>Secondary Button</h3>
        <jsp:include page="/components/Button.jsp">
            <jsp:param name="content" value="Secondary Action" />
            <jsp:param name="variant" value="secondary" />
        </jsp:include>
    </div>
</div>
