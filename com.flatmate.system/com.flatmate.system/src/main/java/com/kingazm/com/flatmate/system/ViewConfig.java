package com.kingazm.com.flatmate.system;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewConfig implements WebMvcConfigurer {

    //responsible for configuring the view of application, by pages below
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/dashboard").setViewName("dashboard");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/tasks").setViewName("tasks");
        registry.addViewController("/taskAddition").setViewName("taskAddition");
        registry.addViewController("/taskSuccess").setViewName("taskSuccess");
        registry.addViewController("/taskTest").setViewName("taskTest");
        registry.addViewController("/shoppingList").setViewName("shoppingList");
        registry.addViewController("/globalTasks").setViewName("globalTasks");
        registry.addViewController("/info").setViewName("info");
        registry.addViewController("/shoppingListItemAddition").setViewName("shoppingListItemAddition");

    }

}
