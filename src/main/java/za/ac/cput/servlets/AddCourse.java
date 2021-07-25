package za.ac.cput.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.cput.dbconnect.DBConnect;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 25 Jul 2021 | 02:52:12
 */
public class AddCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
      PrintWriter out = response.getWriter();
      
      String courseName = request.getParameter("coursename");
      String duration = request.getParameter("duration");
      
      Connection con = DBConnect.makeConnection();
      try {
        Statement st = con.createStatement();
        String sql = "INSERT INTO courses (coursename, duration) VALUES "
                + "('"+courseName+"', '"+duration+"')";
        if(!courseName.equals("") && !duration.equals("")) {
          st.executeUpdate(sql);
          response.sendRedirect("Course");
        }
        else {
          response.sendRedirect("Course");
        }
      } 
      catch (SQLException ex) {
        Logger.getLogger(AddCourse.class.getName()).log(Level.SEVERE, null, ex);
      }
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
}
