package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/testforkata";
    private static final String PASSWORD = "root";
    private static final String USERNAME = "root";

    private Util() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (final SQLException e) {
            System.err.println("Connection has not been established");
        }
        return connection;
    }
}
