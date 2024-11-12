package com.jstorybook;

import jakarta.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.WebApplicationInitializer;

@Configuration
public class StorybookConfig implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) {
    try {
      // Create directory for core JSPs
      String jspPath = servletContext.getRealPath("/WEB-INF/jstorybook/views");
      new File(jspPath).mkdirs();

      // Copy JSPs from JAR to webapp
      PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
      Resource[] resources = resolver.getResources("classpath:/META-INF/jstorybook/views/*.jsp");

      for (Resource resource : resources) {
        String filename = resource.getFilename();
        File destFile = new File(jspPath, filename);

        try (InputStream is = resource.getInputStream();
            OutputStream os = new FileOutputStream(destFile)) {
          byte[] buffer = new byte[1024];
          int length;
          while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
          }
        }
      }
    } catch (Exception e) {
      throw new RuntimeException("Failed to initialize Storybook", e);
    }
  }
}
