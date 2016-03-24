package com.mellon.common.web.context;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

public class CleanupContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<CleanupContextListener");
        //exec.shutdownNow();

        // Mysql bug
        try {
            AbandonedConnectionCleanupThread.shutdown();
        } catch (InterruptedException e) {
        }

        // Shiro subject cann't remove from thread local
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.remove();

        // deregistering db driver
        destroyJDBCDrivers();
    }

    private void destroyJDBCDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            ClassLoader driverclassLoader = driver.getClass().getClassLoader();
            ClassLoader thisClassLoader = this.getClass().getClassLoader();
            if (driverclassLoader != null && thisClassLoader != null &&  driverclassLoader.equals(thisClassLoader)) {
                try {
                    System.out.println("Deregistering: " + driver);
                    DriverManager.deregisterDriver(driver);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
