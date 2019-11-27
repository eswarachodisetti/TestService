package com.fedex.utility;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

import javax.sql.DataSource;
import javax.naming.InitialContext;



public class JDBCUtility {
	

      private static String appPropertiesFullyQualifiedPath = "/tmp/application.properties";
      //private static String appPropertiesFullyQualifiedPath = "X:/KafkaProducer/properties/L1/application.properties";
        private static Properties prop = new Properties();

    static {
        System.out.println("appPropertiesFullyQualifiedPath =========> " + appPropertiesFullyQualifiedPath);
        try {
            prop.load(new FileInputStream(new File(appPropertiesFullyQualifiedPath)));
        } catch(Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e.getMessage()); //TODO handle exceptions better
        }
    }

        public static Connection getJNDIConnectionFromEnvProperties() throws Exception {
                String jndiName = prop.getProperty("spring.datasource.jndi");
                return getJNDIConnection(jndiName);
        }

        public static Connection getJNDIConnectionHardcoded() throws Exception {
                return getJNDIConnection("jdbc/generic");
        }

        public static Connection getJNDIConnection(String jndiName) throws Exception {
                /*
                Context initContext = new InitialContext();
                Context webContext = (Context)initContext.lookup("java:/comp/env");

                System.out.println("Using JNDI: " + jndiName);
                DataSource ds = (DataSource) webContext.lookup(jndiName);
                return ds.getConnection();
                */
                //If the above block does not work, uncomment below block and comment above block
                InitialContext initContext = new InitialContext();
                DataSource ds = (DataSource) initContext.lookup(jndiName); //jndiName = "jdbc/generic1"
                return ds.getConnection();
        }

        public static Connection getConnection() {
                try {
                	
                        
                       // return getJNDIConnection();
                       // return getJNDIConnectionFromEnvProperties();
                        //return getJNDIConnectionHardcoded();
                        //return getJDBCConnectionHardcoded();
                       return getJDBCConnectionFromEnvProperties();
                } catch(Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage()); //TODO handle exceptions better
                }
        }
        public static Connection getJDBCConnectionHardcoded() throws Exception {
                //Connection details Hardcoded
                return DriverManager.getConnection("jdbc:mysql://34.70.82.227:3306/PSK?user=root&password=Zw5.bT1B");
        }
        public static Connection getJDBCConnectionFromEnvProperties() throws Exception {
                //Connection details from environment
                String url=prop.getProperty("spring.datasource.url");
                String user=prop.getProperty("spring.datasource.username");
                String password=prop.getProperty("spring.datasource.password");
                System.out.println("Using JDBC URL: " + url + "\t\t username: " + user);
                return DriverManager.getConnection(url, user, password);
        }


}