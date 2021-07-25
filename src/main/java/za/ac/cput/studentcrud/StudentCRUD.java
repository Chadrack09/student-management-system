package za.ac.cput.studentcrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import za.ac.cput.dbconnect.DBConnect;
import za.ac.cput.dbentity.CoursesDAO;
import za.ac.cput.dbentity.StudentDAO;

/**
 *
 * @author    Chadrack B. Boudzoumou
 * @email     219383847@mycput.ac.za
 * @student   219383847
 * @uni       Cape Peninsula University Of Technology
 * @since     25 Jul 2021 | 16:59:36
 */
public class StudentCRUD implements Crud {
  
  public static void main(String[] args) throws SQLException {
    Crud crud = new StudentCRUD();
    System.out.println(crud.select("select * from student"));
  }

  @Override
  public void insert() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<StudentDAO> select(String query) throws SQLException {
    
    List<StudentDAO> list = new ArrayList<>();
    
    Connection con = DBConnect.makeConnection();
    Statement st = con.createStatement();
    String sql = query;
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()) {
      StudentDAO s = new StudentDAO();
      s.setId(rs.getString("id"));
      s.setStudentName(rs.getString("student_name"));
      s.setCourse(rs.getString("course"));
      s.setBatch(rs.getString("batch"));
      s.setAddress(rs.getString("address"));
      s.setPhoneNumber(rs.getString("phone_number"));
      list.add(s);
    }
    System.out.println("Full List: \n" +list);
    return list;
  }

  @Override
  public void update() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String query, String id) throws SQLException {
    Connection con = DBConnect.makeConnection();
    Statement st = con.createStatement();
    String sql = query;
    if(!id.equals("")) {
      st.executeUpdate(sql);
      con.close();
    }
  }
  
}