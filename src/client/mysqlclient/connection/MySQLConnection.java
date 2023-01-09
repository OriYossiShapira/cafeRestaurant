package client.mysqlclient.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cafe_meals";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection conn;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null) {
            // Load the JDBC driver for MySQL
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // Connect to the MySQL server
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (conn.isValid(0)) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection failed!");
            }
        }

        return conn;
    }
}