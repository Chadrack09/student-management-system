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
 * @since: 25 Jul 2021 | 17:35:45
 */
public class AddStudent extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
      PrintWriter out = response.getWriter();
      String studentName = request.getParameter("studentname");
      String course = request.getParameter("courses");
      String batch = request.getParameter("batches");
      String address = request.getParameter("address");
      String phoneNumber = request.getParameter("phoneNumber");
      out.println(studentName+course+batch+address+phoneNumber);
      
      Connection con = DBConnect.makeConnection();
      
      try {
        Statement st = con.createStatement();
        String sql = "INSERT INTO student (student_name, course, batch, address, phone_number) "
                + "VALUES ('"+studentName+"', '"+course+"', '"+batch+"', '"+address+"', '"+phoneNumber+"' )";
        if (!studentName.equals("") && !address.equals("") && !phoneNumber.equals("")) {
          st.executeUpdate(sql);
          con.close();
          response.sendRedirect("Student");
        }
        else {
          response.sendRedirect("Student");
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
}
