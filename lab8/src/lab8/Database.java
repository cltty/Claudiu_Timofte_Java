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
public class Database {
    private static Connection conn = null;
    
    public static Connection createConnection(String user, String pwd) {
        if (conn = null) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:XE", user, pwd);
        }
        return conn;
    }
    
    public static void closeConnection() {
        conn = null;
    }
}
