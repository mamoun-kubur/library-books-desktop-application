/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author Mamoun kubur
 */
public class dbcon {
    private static final String sqconn="jdbc:sqlite:bookdb.sqlite";
    
     public static Connection connect() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(sqconn);
           
            
        } catch (ClassNotFoundException e) {
            System.out.println("errr");
        } 
         return null;
    }

    
}
