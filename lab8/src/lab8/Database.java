/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

/**
 *
 * @author Claudiu
 */
import java.sql.*;

public class Database {
    private static Database databaseInstance = null;
    static Connection connection;

    private Database(String url, String user, String password) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static Database getDatabaseInstance(String url, String user, String password) {
        if (databaseInstance == null) {
            databaseInstance = new Database(url, user, password);
        }
        return databaseInstance;
    }

    public static void closeDatabase() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
