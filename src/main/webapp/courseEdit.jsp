<%-- 
    Document   : courseEdit
    Created on : 25 Jul 2021 | 06:37:37
    Author     : Chadrack B. Boudzoumou
--%>

<%@page import="za.ac.cput.dbentity.CoursesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/bootstrap.css">
  </head>
  <body>
    <%
      ArrayList<CoursesDAO> list = new ArrayList<>();
      list = (ArrayList<CoursesDAO>) session.getAttribute("list");
    %>
    <main class="mt-5 container log-container1">
      <div class="row mb-4">
        <div class="col-sm-12 col-lg-8 form-column1">
          <h1 class="text-center">Edit Course</h1>
          <small class="text-center">Please enter all field details</small>
          <form action="CourseEdited" method="POST">
            <div class="form-group">
              <input type="text" readonly name="id" value="<%= list.get(0).getId() %>" class="form-control mb-1">
              <label for="coursename">CourseName</label>
              <input type="text" value="<%= list.get(0).getCourseName() %>" placeholder="Course Name" class="form-control mb-1" name="coursename">
              <label for="duration">Duration</label>
              <input type="text" value="<%= list.get(0).getDuration() %>" placeholder="Duration" class="form-control mb-2" name="duration">
            </div>
            <div class="form-button">
              <div class="btn-submit">
                <input type="submit" value="Edit Course" class="btn btn-primary w-100 mb-1">
              </div>
              <div class="btn-submit">
                <input type="submit" value="Reset" class="btn btn-danger w-100 mb-1">
              </div>
            </div>
          </form>          
        </div>
      </div>
    </main>
  </body>
</html>
