package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static Util instance;
    private Util() {

    }
    public static final String DB_URL = "jdbc:mysql://localhost:3306/users";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "root";

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;
    public static Connection getMySQLConnection() {
        try {
            Class.forName(DB_DRIVER);
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                System.out.println("Connection is ok!)");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Error");
        }
        return connection;
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }
}