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
import za.ac.cput.dbconnect.DBConnect;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 25 Jul 2021 | 14:47:07
 */
public class AddBatch extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
      PrintWriter out = response.getWriter();
      
      String batchnumber = request.getParameter("batchnumber");
      String year = request.getParameter("year");
      Connection con = DBConnect.makeConnection();
      
      try {
        Statement st = con.createStatement();
        String sql = "INSERT INTO batch (batchnumber, year) VALUES "
                + "('"+batchnumber+"', '"+year+"')";
        
        if(!batchnumber.equals("") && !year.equals("")) {
          st.executeUpdate(sql);
          response.sendRedirect("Batch");
        }
        else {
          response.sendRedirect("Batch");
        }
      } 
      catch (SQLException ex) {
        out.println(ex.getMessage());
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
