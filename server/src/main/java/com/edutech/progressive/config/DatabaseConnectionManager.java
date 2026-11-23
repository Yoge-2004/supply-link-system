package com.edutech.progressive.config;

import java.util.Properties;

import java.io.InputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static final Properties properties = new Properties();
    
    static {
        try (InputStream input = DatabaseConnectionManager.class
            .getClassLoader()
            .getResourceAsStream("application.properties")
        ) {
            if (input == null) 
                throw new IllegalStateException("application.properties not found");

            properties.load(input);
            
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application properties", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = properties.getProperty("spring.datasource.url");
        String username = properties.getProperty("spring.datasource.username");
        String password = properties.getProperty("spring.datasource.password");

        return DriverManager.getConnection(url, username, password);
    }
}
