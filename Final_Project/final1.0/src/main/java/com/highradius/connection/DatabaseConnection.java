package com.highradius.connection;
import java.sql.*;

public class DatabaseConnection {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/mysql";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "anusthan";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
	 
	
	   
   

