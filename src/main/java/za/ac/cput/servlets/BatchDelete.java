package za.ac.cput.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.cput.studentcrud.BatchCRUD;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 25 Jul 2021 | 15:45:55
 */
public class BatchDelete extends HttpServlet { 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      PrintWriter out = response.getWriter();

      String id = request.getParameter("id");
      out.println("ID: " +id);
      String query = "DELETE FROM batch WHERE id='"+id+"' ";

      try {
        BatchCRUD crud = new BatchCRUD();
        crud.delete(query, id);
        
        response.sendRedirect("Batch");
      } 
      catch (SQLException ex) {
        Logger.getLogger(BatchDelete.class.getName()).log(Level.SEVERE, null, ex);
      }
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
}
