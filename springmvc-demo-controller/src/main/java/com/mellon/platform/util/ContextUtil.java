package com.mellon.platform.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * Created by mellon on 15-11-14.
 */
public class ContextUtil {
    private final static ContextUtil instance = new ContextUtil();

    private ContextUtil() {}

    public final static ContextUtil getInstance() {
        return instance;
    }

    private ApplicationContext springContext;

    public static Object getSpringBeanById(String beanId) {
        return getInstance().springContext.getBean(beanId);
    }

    /**
     * @param servletContext
     */
    public void init(ServletContext servletContext) {
        this.springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }
}
