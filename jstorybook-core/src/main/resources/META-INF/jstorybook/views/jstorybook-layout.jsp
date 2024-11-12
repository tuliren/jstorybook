<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JStorybook - ${title}</title>
    <base href="${pageContext.request.contextPath}/">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
            line-height: 1.5;
            height: 100vh;
            display: flex;
        }

        .sidebar {
            width: 260px;
            height: 100vh;
            background: #f8f8f8;
            border-right: 1px solid #e6e6e6;
            padding: 20px;
            overflow-y: auto;
            flex-shrink: 0;
        }

        .sidebar-header {
            margin-bottom: 20px;
        }

        .sidebar-title {
            font-size: 20px;
            font-weight: bold;
            color: #333;
        }

        .nav-list {
            list-style: none;
        }

        .nav-item {
            margin: 8px 0;
        }

        .nav-link {
            display: block;
            padding: 8px 12px;
            color: #333;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.2s;
        }

        .nav-link:hover {
            background-color: #e6e6e6;
        }

        .nav-link.active {
            background-color: #e6e6e6;
        }

        .main-content {
            flex-grow: 1;
            padding: 20px;
            overflow-y: auto;
        }

        /* Story Preview styles */
        .story-preview {
            padding: 20px;
            background: white;
            border-radius: 4px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
        }

        .story-section {
            margin-bottom: 30px;
        }

        .story-section h3 {
            margin-bottom: 15px;
            color: #333;
        }
    </style>
</head>
<body>
    <!-- Sidebar -->
    <nav class="sidebar">
        <div class="sidebar-header">
            <h1 class="sidebar-title">JStorybook</h1>
        </div>
        <ul class="nav-list">
            <c:forEach items="${stories}" var="story">
                <li class="nav-item">
                    <a href="${story.url}" class="nav-link${requestScope['javax.servlet.forward.request_uri'] == story.url ? ' active' : ''}">
                        ${story.name}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>

    <!-- Main content -->
    <main class="main-content">
        <jsp:include page="${storyPath}" />
    </main>
</body>
</html>
