package za.ac.cput.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.ac.cput.dbentity.CoursesDAO;
import za.ac.cput.studentcrud.CourseCRUD;
import za.ac.cput.studentcrud.Crud;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 25 Jul 2021 | 04:25:09
 */
public class Course extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      PrintWriter out = response.getWriter();
      List<CoursesDAO> list = new ArrayList<>();
      try {
        
        String query = "SELECT * FROM courses";
        
        Crud<CoursesDAO> crud = new CourseCRUD();
        list = crud.select(query);
        
        HttpSession session = request.getSession();
        session.setAttribute("courses", list);
        
        RequestDispatcher rd = request.getRequestDispatcher("/courses.jsp");
        rd.forward(request, response);
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
