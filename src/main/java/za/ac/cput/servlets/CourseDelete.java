package za.ac.cput.servlets;

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
 * @since: 25 Jul 2021 | 05:51:38
 */
public class CourseDelete extends HttpServlet { 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id");
        Connection con = DBConnect.makeConnection();
        
      try {
        Statement st = con.createStatement();
        String sql = "DELETE FROM courses WHERE id='"+id+"' ";
        if(!id.equals("")) {
          st.executeUpdate(sql);
          con.close();
          response.sendRedirect("Course");
        }
      } 
      catch (SQLException ex) {
        System.out.println(ex.getMessage());
      }
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
