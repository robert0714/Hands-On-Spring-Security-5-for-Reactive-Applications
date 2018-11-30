package com.packtpub.book.ch07.springsecurity.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcWebApplicationInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationConfig.class, SpringSecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebApplicationConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    public void onStartup(final ServletContext servletContext)
            throws ServletException {

        // Register DispatcherServlet
        super.onStartup(servletContext);

        // Register H2 Admin console:
        ServletRegistration.Dynamic h2WebServlet = servletContext.addServlet("h2WebServlet",
                "org.h2.server.web.WebServlet");
        h2WebServlet.addMapping("/admin/h2/*");
        h2WebServlet.setInitParameter("webAllowOthers", "true");

    }
}
