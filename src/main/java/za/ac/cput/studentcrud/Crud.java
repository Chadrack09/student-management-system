/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.studentcrud;

import java.sql.SQLException;
import java.util.List;
import za.ac.cput.dbentity.CoursesDAO;

/**
 *
 * @author Chadtech
 */
public interface Crud<T> {
  
  public void insert();
  
  public List<T> select(String query) throws SQLException;
  
  public void update();
  
  public void delete(String query, String id) throws SQLException;
  
}
