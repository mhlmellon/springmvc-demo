package com.mellon.common.web.context;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import com.alibaba.dubbo.config.ProtocolConfig;

public class MyContextLoaderListener extends ContextLoaderListener {

    private static final Logger LOG = LoggerFactory
            .getLogger(MyContextLoaderListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        ProtocolConfig.destroyAll();// close dubbo service
        super.contextDestroyed(event);
    }

}