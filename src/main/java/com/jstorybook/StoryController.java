package com.jstorybook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.ServletContext;
import java.util.List;

@Controller
public class StoryController {
  private final StoryLoader storyLoader;
  private final ServletContext servletContext;

  @Autowired
  public StoryController(StoryLoader storyLoader, ServletContext servletContext) {
    this.storyLoader = storyLoader;
    this.servletContext = servletContext;
  }

  @GetMapping("/")
  public String showStorybook(Model model) {
    List<Story> stories = storyLoader.loadStories(servletContext.getRealPath("/"));
    model.addAttribute("stories", stories);
    return "storybook";
  }

  @GetMapping("/stories/{storyName}")
  public String showStory(@PathVariable String storyName, Model model) {
    // Simply pass through the story name, let the view resolver handle it
    return "stories/" + storyName;
  }
}
