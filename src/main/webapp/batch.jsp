<%-- 
    Document   : batch
    Created on : 24 Jul 2021 | 19:07:52
    Author     : Chadrack B. Boudzoumou
--%>

<%@page import="za.ac.cput.dbentity.BatchDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>

    <!-- <link rel="stylesheet" href="css/bootstrap.css"> -->
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    <%-- NavBar Component --%>
    <jsp:include page="components/navbar.jsp" />
    
    <%
      ArrayList<BatchDAO> list = new ArrayList<>();
      list = (ArrayList<BatchDAO>) session.getAttribute("list");
    %>
    
    <main class="mt-5 container log-container1">
      <div class="row mb-4">
        <div class="col-sm-12 col-lg-12 form-column1">
          <h1 class="text-center">Batch Number</h1>
          <small class="text-center">Please enter both details batch number and year</small>
          <form action="AddBatch" method="POST">
            <div class="form-group">
              <input type="text" placeholder="Batch Number" class="form-control mb-1" name="batchnumber">
              <input type="text" placeholder="Year" class="form-control mb-2" name="year">
            </div>
            <div class="form-button">
              <div class="btn-submit">
                <input type="submit" value="AddBatch" class="btn btn-primary w-100 mb-1">
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
            <th scope="col">Batch Number</th>
            <th scope="col">Year</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
          </tr>
        </thead>
        <tbody>
          <% for (int i = 0; i < list.size(); i++) { %>
          <tr>
            <td><%= list.get(i).getBatchNumber() %></td>
            <td><%= list.get(i).getYear() %></td>
            <td><a href="#">Edit</a></td>
            <td><a href="BatchDelete?id=<%= list.get(i).getId() %>">Delete</a></td>
          </tr>
          <% } %>
        </tbody>
      </table>
    </main>
  </body>
</html>
