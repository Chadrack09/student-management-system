<%-- 
    Document   : courses
    Created on : 24 Jul 2021 | 18:34:56
    Author     : Chadrack B. Boudzoumou
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.cput.dbentity.CoursesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/bootstrap.css">
  </head>
  <body>
    
    <%  
      ArrayList<CoursesDAO> list = new ArrayList<>();
      list = (ArrayList<CoursesDAO>) session.getAttribute("courses");
    %>
    
    <%-- Navigation Bar --%>
    <jsp:include page="components/navbar.jsp" />
    
    <main class="mt-5 container log-container1">
      <div class="row mb-4">
        <div class="col-sm-12 col-lg-12 form-column1">
          <h1 class="text-center">Courses</h1>
          <small class="text-center">Please enter both details course name and duration</small>
          <form action="AddCourse" method="POST">
            <div class="form-group">
              <input type="text" placeholder="Course Name" class="form-control mb-1" name="coursename">
              <input type="text" placeholder="Duration" class="form-control mb-2" name="duration">
            </div>
            <div class="form-button">
              <div class="btn-submit">
                <input type="submit" value="Add Course" class="btn btn-primary w-100 mb-1">
              </div>
              <div class="btn-submit">
                <input type="submit" value="Reset" class="btn btn-danger w-100 mb-1">
              </div>
            </div>
          </form>          
        </div>
      </div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Course</th>
            <th scope="col">Duration</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
          </tr>
        </thead>
        <tbody>
          <% for(int i = 0; i < list.size(); i++) { %>
          <tr>
            <td><%= list.get(i).getCourseName() %></td>
            <td><%= list.get(i).getDuration() %></td>
            <td><a class="btn btn-primary" href="CourseEdit?id=<%= list.get(i).getId() %>">Edit</a></td>
            <td><a class="btn btn-danger" href="CourseDelete?id=<%= list.get(i).getId() %>">Delete</a></td>
          </tr>
          <% } %>
        </tbody>
      </table>
    </main>
  </body>
</html>
