<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="button">
    <button class="btn ${param.variant || 'primary'}">
        <c:if test="${param.content != null}">
            ${param.content}
        </c:if>
    </button>
</div>
