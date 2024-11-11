<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JStorybook</title>
    <style>
        .sidebar {
            width: 250px;
            position: fixed;
            height: 100%;
            background: #f5f5f5;
            padding: 20px;
            overflow-y: auto;
        }
        .main-content {
            margin-left: 270px;
            padding: 20px;
        }
        .story-frame {
            border: 1px solid #ddd;
            padding: 20px;
            margin-bottom: 20px;
        }
        .controls {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <h2>Components</h2>
        <ul>
            <c:forEach items="${stories}" var="story">
                <li>
                    <a href="#" onclick="loadStory('${story.componentPath}')">${story.name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="main-content">
        <div class="controls">
            <button onclick="toggleTheme()">Toggle Theme</button>
            <button onclick="toggleViewport()">Toggle Viewport</button>
        </div>

        <div class="story-frame">
            <iframe id="storyFrame" style="width: 100%; height: 500px; border: none;"></iframe>
        </div>
    </div>

    <script>
        const contextPath = '${pageContext.request.contextPath}';

        function loadStory(path) {
            const storyPath = contextPath + '/stories/' + path;
            console.log('Loading story:', storyPath);
            document.getElementById('storyFrame').src = storyPath;
        }

        function toggleTheme() {
            const frame = document.getElementById('storyFrame');
            frame.contentWindow.postMessage({ type: 'TOGGLE_THEME' }, '*');
        }

        function toggleViewport() {
            const frame = document.getElementById('storyFrame');
            frame.style.width = frame.style.width === '100%' ? '375px' : '100%';
        }
    </script>
</body>
</html>
