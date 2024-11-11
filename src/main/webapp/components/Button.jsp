<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="button">
    <!-- Component content here -->
    <c:if test="${param.content != null}">
        ${param.content}
    </c:if>
</div>
