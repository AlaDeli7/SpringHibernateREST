package com.spring.training.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DeliInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DeliInitializer.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return  null;
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
