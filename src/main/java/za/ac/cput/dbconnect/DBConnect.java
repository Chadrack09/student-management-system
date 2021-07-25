package za.ac.cput.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.cput.dbentity.CoursesDAO;
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
  
//  public static void main(String[] args) throws SQLException {
//    Connection con = DBConnect.makeConnection();
//    Statement st = con.createStatement();
//    
//    String sql = "select coursename, duration from courses";
//    ResultSet rs = st.executeQuery(sql);
//    
//    List<Courses> list = new ArrayList<>();
//    while(rs.next()) {
//      CoursesDAO c = new CoursesDAO();
//      c.setCourseName(rs.getString("coursename"));
//      c.setDuration(rs.getString("duration"));
//      
//      
//      list.add(c);
//    }
//    
//    System.out.println("----------------[  List  ]----------------");
//    System.out.println(list);
//  }
  
}