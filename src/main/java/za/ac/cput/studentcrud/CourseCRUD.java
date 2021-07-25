package za.ac.cput.studentcrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import za.ac.cput.dbconnect.DBConnect;
import za.ac.cput.dbentity.CoursesDAO;

/**
 *
 * @author    Chadrack B. Boudzoumou
 * @email     219383847@mycput.ac.za
 * @student   219383847
 * @uni       Cape Peninsula University Of Technology
 * @since     25 Jul 2021 | 13:34:47
 * 
 * This class contain all crud operation performed towards courses tables
 * CRUD -- (Create[Insert]; Read[Select]; Update[Edit]; Delete)
 */
public class CourseCRUD implements Crud {
  
  public static void main(String[] args) throws SQLException {
    CourseCRUD cr = new CourseCRUD();
    List<CoursesDAO> list = new ArrayList<>();
    list = cr.select("select * from courses");
    System.out.println(list);
  }

  
  /**
   * @see #select(java.util.List, za.ac.cput.dbentity.Courses), this method 
   * select everything from courses tables and return a list
   * 
   * @return list<Courses>
   * 
   * @param list
   * @param c
   */
  @Override
  public List<CoursesDAO> select(String query) throws SQLException {
    List<CoursesDAO> list = new ArrayList<>();
    
    Connection con = DBConnect.makeConnection();
    Statement st = con.createStatement();
    String sql = query;
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()) {
      CoursesDAO c = new CoursesDAO();
      c.setId(rs.getString("id"));
      c.setCourseName(rs.getString("coursename"));
      c.setDuration(rs.getString("duration"));
      list.add(c);
    }
    System.out.println("The Fulle List: " +list);
    return list;
  }


  @Override
  public void insert() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String query, String id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}