package com.jstorybook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoryLoader {
  private static final Logger logger = LoggerFactory.getLogger(StoryLoader.class);
  private static final String STORIES_DIR = "/WEB-INF/views/stories";

  public List<Story> loadStories(String contextPath) {
    List<Story> stories = new ArrayList<>();
    File storiesDir = new File(contextPath + STORIES_DIR);

    if (storiesDir.exists() && storiesDir.isDirectory()) {
      for (File file : storiesDir.listFiles()) {
        if (file.getName().endsWith(".jsp")) {
          try {
            stories.add(createStoryFromFile(file));
          } catch (IOException e) {
            logger.error("Error loading story from file: " + file.getName(), e);
          }
        }
      }
    } else {
      logger.warn("Stories directory not found: {}", storiesDir.getAbsolutePath());
    }

    return stories;
  }

  private Story createStoryFromFile(File file) throws IOException {
    String content = readFileContent(file);
    String name = extractMetadata(content, "Story:");
    String description = extractMetadata(content, "Description:");

    if (name == null) {
      name = file.getName().replace("Story.jsp", "");
    }

    // Just use the component name without .jsp extension for the URL
    String componentPath = file.getName().replace(".jsp", "");

    return new Story(
            name,
            description != null ? description : "Story for " + name,
            componentPath,
            null
    );
  }

  private String readFileContent(File file) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      StringBuilder content = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }
      return content.toString();
    }
  }

  private String extractMetadata(String content, String key) {
    Pattern pattern = Pattern.compile(key + "\\s*(.+)");
    Matcher matcher = pattern.matcher(content);
    return matcher.find() ? matcher.group(1).trim() : null;
  }
}
