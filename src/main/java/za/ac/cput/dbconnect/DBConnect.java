package za.ac.cput.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author    Chadrack B. Boudzoumou
 * @email     219383847@mycput.ac.za
 * @student   219383847
 * @uni       Cape Peninsula University Of Technology
 * @since     25 Jul 2021 | 03:08:40
 */
public class DBConnect {
  
  public static Connection makeConnection() { 
    
    String username  = "root";
    String password  = "@Admin0912";
    String url       = "jdbc:mysql://localhost:3306/studentsystem";
    Connection con = null;
    
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, username, password);
      System.out.println("Connected to database");
    } 
    catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    }
    return con;
  }  
}