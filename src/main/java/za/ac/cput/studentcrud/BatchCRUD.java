package za.ac.cput.studentcrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import za.ac.cput.dbconnect.DBConnect;
import za.ac.cput.dbentity.BatchDAO;
import za.ac.cput.dbentity.CoursesDAO;

/**
 *
 * @author    Chadrack B. Boudzoumou
 * @email     219383847@mycput.ac.za
 * @student   219383847
 * @uni       Cape Peninsula University Of Technology
 * @since     25 Jul 2021 | 14:52:42
 */
public class BatchCRUD implements Crud {
  
  public static void main(String[] args) throws SQLException {
    Crud bcrud = new BatchCRUD();
    String query = "SELECT * FROM batch";
    List<BatchDAO> list = new ArrayList();
    list = bcrud.select(query);
    System.out.println("List: " +list.get(0).getBatchNumber());
  }

  @Override
  public void insert() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<BatchDAO> select(String query) throws SQLException {
    List<BatchDAO> list = new ArrayList<>();
    
    Connection con = DBConnect.makeConnection();
    Statement st = con.createStatement();
    String sql = query;
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()) {
      BatchDAO b = new BatchDAO();
      b.setId(rs.getString("id"));
      b.setBatchNumber(rs.getString("batchnumber"));
      b.setYear(rs.getString("year"));
      list.add(b);
    }
    System.out.println("The Full List: " +list);
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