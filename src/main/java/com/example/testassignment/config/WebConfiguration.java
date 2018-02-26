package com.example.testassignment.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.h2.server.web.WebServlet;


/**
 * Web MVC Configuration
 */
@Configuration
public class WebConfiguration
{
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/h2/*");
        registrationBean.setName("webServlet");
        return registrationBean;
    }
}
