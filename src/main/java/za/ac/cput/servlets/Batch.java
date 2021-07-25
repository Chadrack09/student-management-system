package za.ac.cput.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

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
import za.ac.cput.studentcrud.BatchCRUD;

/**
 *
 * @author: Chadrack B. Boudzoumou
 * @email: 219383847@mycput.ac.za
 * @studentN: 219383847
 * @Univerity: Cape Peninsula University Of Technology 
 * @since: 25 Jul 2021 | 14:48:48
 */
public class Batch extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Welcome to batch Servlet");
        
        List<BatchDAO> list = new ArrayList<>();
        try {
          String query = "SELECT * FROM batch";
          BatchCRUD bcrud = new BatchCRUD();
          list = bcrud.select(query);
          
          HttpSession session = request.getSession();
          session.setAttribute("list", list);
          
          RequestDispatcher rd = request.getRequestDispatcher("batch.jsp");
          rd.forward(request, response);
        }
        catch(SQLException ex) {
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
