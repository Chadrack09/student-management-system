<%-- 
    Document   : student
    Created on : 24 Jul 2021 | 19:46:19
    Author     : Chadrack B. Boudzoumou
--%>

<%@page import="za.ac.cput.dbentity.StudentDAO"%>
<%@page import="za.ac.cput.dbentity.BatchDAO"%>
<%@page import="za.ac.cput.dbentity.CoursesDAO"%>
<%@page import="java.util.ArrayList"%>
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
    <%-- NavBar Component --%>
    <jsp:include page="components/navbar.jsp" />

    <%
      ArrayList<CoursesDAO> courseList = new ArrayList<>();
      ArrayList<BatchDAO> batchList = new ArrayList<>();
      ArrayList<StudentDAO> studentList = new ArrayList<>();
      
      courseList = (ArrayList<CoursesDAO>) session.getAttribute("courseList");
      batchList = (ArrayList<BatchDAO>) session.getAttribute("batchList");
      studentList = (ArrayList<StudentDAO>) session.getAttribute("studentList");
    %>
    
    <main class="mt-5 container log-container1">
      <div class="row mb-4">
        <div class="col-sm-12 col-lg-12 form-column1">
          <h1 class="text-center">Student Database</h1>
          <small class="text-center">Please enter all field details</small>
          <form action="AddStudent" method="POST">
            <div class="form-group">
              <input type="text" placeholder="Student Name" class="form-control mb-1" name="studentname">
              
              <select id="id" class="form-select mb-1" name="courses">
                <% for (int i = 0; i < courseList.size(); i++) { %>
                <option value="<%= courseList.get(i).getCourseName() %>"><%= courseList.get(i).getCourseName() %></option>
                <% } %>
              </select>
              <select id="id" class="form-select mb-1" name="batches">
                <% for (int i = 0; i < batchList.size(); i++) { %>
                <option value="<%= batchList.get(i).getBatchNumber() %>"><%= batchList.get(i).getBatchNumber() %></option>
                <% } %>
              </select>
              
              <input type="text" placeholder="Address" class="form-control mb-2" name="address">
              <input type="text" placeholder="Phone Number" class="form-control mb-2" name="phoneNumber">
            </div>
            <div class="form-button">
              <div class="btn-submit">
                <input type="submit" value="Submit" class="btn btn-primary w-100 mb-1">
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
            <th scope="col">Student Name</th>
            <th scope="col">Course</th>
            <th scope="col">Batch</th>
            <th scope="col">Address</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
          </tr>
        </thead>
        <tbody>
          <% for (int i = 0; i < studentList.size(); i++) { %>
          <tr>
            <td><%= studentList.get(i).getStudentName() %></td>
            <td><%= studentList.get(i).getCourse() %></td>
            <td><%= studentList.get(i).getBatch() %></td>
            <td><%= studentList.get(i).getAddress() %></td>
            <td><%= studentList.get(i).getPhoneNumber() %></td>
            <td><a href="#">Edit</a></td>
            <td><a href="StudentDelete?id=<%= studentList.get(i).getId() %>">Delete</a></td>
          </tr>
          <% } %>
        </tbody>
      </table>
    </main>
  </body>
</html>
