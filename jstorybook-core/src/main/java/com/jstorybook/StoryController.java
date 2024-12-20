package com.jstorybook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
public class StoryController {
  private static final Logger logger = LoggerFactory.getLogger(StoryController.class);
  private final StoryLoader storyLoader;

  public StoryController(StoryLoader storyLoader) {
    this.storyLoader = storyLoader;
  }

  @GetMapping("/")
  public String listStories(Model model) {
    List<Story> stories = storyLoader.loadStories();
    logger.info("Found stories: {}", stories);
    model.addAttribute("stories", stories);
    return "/WEB-INF/jstorybook/views/jstorybook";
  }

  @GetMapping("/{storyName}")
  public String viewStory(@PathVariable String storyName, Model model) {
    logger.info("Attempting to view story: {}", storyName);
    List<Story> stories = storyLoader.loadStories();
    model.addAttribute("stories", stories);
    model.addAttribute("title", storyName);
    model.addAttribute("storyPath", "/WEB-INF/views/stories/" + storyName + ".jsp");
    return "/WEB-INF/jstorybook/views/jstorybook-layout";
  }
}
