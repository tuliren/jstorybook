package com.jstorybook;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import jakarta.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class StoryLoader implements ServletContextAware {
  private static final Logger logger = LoggerFactory.getLogger(StoryLoader.class);
  private ServletContext servletContext;
  private String storiesPath;

  public StoryLoader() {
    this.storiesPath = "/WEB-INF/views/stories";
  }

  @Override
  public void setServletContext(ServletContext servletContext) {
    this.servletContext = servletContext;
  }

  public List<Story> loadStories() {
    List<Story> stories = new ArrayList<>();

    String realPath = servletContext.getRealPath(storiesPath);
    logger.info("Looking for stories in: {}", realPath);

    if (realPath == null) {
      logger.warn("Could not resolve real path for: {}", storiesPath);
      return stories;
    }

    File storiesDir = new File(realPath);
    if (!storiesDir.exists() || !storiesDir.isDirectory()) {
      logger.warn("Stories directory does not exist or is not a directory: {}", realPath);
      return stories;
    }

    File[] storyFiles = storiesDir.listFiles((dir, name) -> name.endsWith("Story.jsp"));
    if (storyFiles == null) {
      logger.warn("No story files found in: {}", realPath);
      return stories;
    }

    String contextPath = servletContext.getContextPath();
    for (File storyFile : storyFiles) {
      String fileName = storyFile.getName();
      // Remove the .jsp extension
      String storyName = fileName.substring(0, fileName.length() - 4);
      String storyUrl = contextPath + "/story/" + storyName;

      logger.info("Found story: {} -> {}", fileName, storyUrl);
      stories.add(new Story(storyName, storyUrl));
    }

    return stories;
  }

  public List<Story> loadStories(String path) {
    this.storiesPath = path;
    return loadStories();
  }
}
