package com.jstorybook;

public class Story {
  private String name;
  private String description;
  private String componentPath;
  private Object props;

  public Story(String name, String description, String componentPath, Object props) {
    this.name = name;
    this.description = description;
    this.componentPath = componentPath;
    this.props = props;
  }

  // Getters and setters
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public String getComponentPath() { return componentPath; }
  public void setComponentPath(String componentPath) { this.componentPath = componentPath; }
  public Object getProps() { return props; }
  public void setProps(Object props) { this.props = props; }
}
