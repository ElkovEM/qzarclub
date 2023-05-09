package ru.course.qzar.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ModelViewControllerConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/arenas").setViewName("arenas");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/create").setViewName("create");
        registry.addViewController("/admin").setViewName("admin");
    }

}