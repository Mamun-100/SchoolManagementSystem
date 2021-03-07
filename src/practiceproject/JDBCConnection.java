/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Os-10
 */
public class JDBCConnection {
private Connection con;
    public JDBCConnection() {
        createConnection();
    }
    public void createConnection(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolproject", "j2ee","1234");
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection(){
    return con;
    }
}
