package com.mellon.platform.core.listener;

import com.mellon.platform.util.ContextUtil;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 */
public class StartupListener extends ContextLoaderListener implements
    ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        ContextUtil.getInstance().init(servletContext);
    }

}
