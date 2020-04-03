package com.aoher.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final Logger log = LoggerFactory.getLogger(ConnectionFactory.class);

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        final String DB_URL = "jdbc:mysql://localhost/bookmark";

        final String USER = "root";
        final String PASS = "root";

        if (connection == null) {
            log.info("Connecting to Original database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        return connection;
    }

    private ConnectionFactory() {
    }
}
