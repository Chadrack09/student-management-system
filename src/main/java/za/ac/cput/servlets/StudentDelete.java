package za.ac.cput.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import za.ac.cput.studentcrud.Crud;
import za.ac.cput.studentcrud.StudentCRUD;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 25 Jul 2021 | 17:54:43
 */
public class StudentDelete extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      PrintWriter out = response.getWriter();
      
      String id = request.getParameter("id");
      String query = "DELETE FROM student WHERE id='"+id+"' ";
      
      try {
        Crud crud = new StudentCRUD();
        crud.delete(query, id);
        response.sendRedirect("Student");
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
