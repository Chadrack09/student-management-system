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
import za.ac.cput.dbentity.BatchDAO;
import za.ac.cput.dbentity.CoursesDAO;
import za.ac.cput.dbentity.StudentDAO;
import za.ac.cput.studentcrud.BatchCRUD;
import za.ac.cput.studentcrud.CourseCRUD;
import za.ac.cput.studentcrud.Crud;
import za.ac.cput.studentcrud.StudentCRUD;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 25 Jul 2021 | 16:56:27
 */
public class Student extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Student Servlet");
        
        String courseQuery = "SELECT * FROM courses";
        String batchQuery = "SELECT * FROM batch";
        String studentQuery = "SELECT * FROM student";
        
        List<CoursesDAO> courseList = new ArrayList<>();
        List<BatchDAO> batchList = new ArrayList<>();
        List<StudentDAO> studentList = new ArrayList<>();
        
      try {
        
        Crud<CoursesDAO> courseCrud = new CourseCRUD();
        courseList = courseCrud.select(courseQuery);
        
        Crud<BatchDAO> batchCrud = new BatchCRUD();
        batchList = batchCrud.select(batchQuery);
        
        Crud<StudentDAO> studentCrud = new StudentCRUD();
        studentList = studentCrud.select(studentQuery);
        
        out.println("All Lists");
        out.println(courseList);
        out.println(batchList);
        out.println(studentList);
        
        HttpSession session = request.getSession();
        session.setAttribute("courseList", courseList);
        session.setAttribute("batchList", batchList);
        session.setAttribute("studentList", studentList);
        
        RequestDispatcher rd = request.getRequestDispatcher("/student.jsp");
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
