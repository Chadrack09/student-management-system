package za.ac.cput.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import za.ac.cput.dbconnect.DBConnect;
import za.ac.cput.dbentity.CoursesDAO;
import za.ac.cput.studentcrud.CourseCRUD;
import za.ac.cput.studentcrud.Crud;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 25 Jul 2021 | 06:31:50
 */
public class CourseEdit extends HttpServlet { 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      PrintWriter out = response.getWriter();
      String id = request.getParameter("id");
      List<CoursesDAO> list = new ArrayList<>();
      try {
        
        String query = "select * from courses where id='"+id+"' ";
        Crud crud = new CourseCRUD();
        list = crud.select(query);
        
        HttpSession session = request.getSession();
        session.setAttribute("list", list);
        
        response.sendRedirect("courseEdit.jsp");
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
