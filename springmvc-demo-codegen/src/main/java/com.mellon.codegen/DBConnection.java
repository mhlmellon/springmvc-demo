package com.mellon.codegen;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
* 
 *
 */
public class DBConnection {
    
	
    
    /**
     * @return
     * @throws java.io.IOException
     */
    public static Connection getConnection() throws IOException{
    	InputStream in = new BufferedInputStream(new FileInputStream(PropertyRegister.CONFIG_PATH));
    	Properties p = new Properties();
    	p.load(in);
        Connection conn = null;
        try{
            Class.forName(p.getProperty("jdbc.driver"));
            conn = DriverManager.getConnection(p.getProperty("jdbc.url"),p.getProperty("jdbc.user"),p.getProperty("jdbc.password"));
            System.out.println("link success!");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }
    
    /**
     * @return
     * @throws java.io.IOException
     */
    public static Connection getMysqlConnection() throws IOException{
    	InputStream in = new BufferedInputStream(new FileInputStream(PropertyRegister.CONFIG_PATH));
    	Properties p = new Properties();
    	p.load(in);
        Connection conn = null;
        try{
            Class.forName(p.getProperty("jdbc.mysql_driver"));
            conn = DriverManager.getConnection(p.getProperty("jdbc.mysql_url"),p.getProperty("jdbc.mysql_user"),p.getProperty("jdbc.mysql_password"));
            System.out.println("link success!");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }
    
    /**
     * 
     * @param connect
     */
    public void closeConnection(Connection conn){
        try{
            if(conn!=null){
                if(!conn.isClosed()){
                    conn.close();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    
}
