<%-- 
    Document   : home
    Created on : 24 Jul 2021 | 13:14:48
    Author     : Chadrack B. Boudzoumou
--%>

<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    
    <%
      String username = request.getParameter("username");
      String password = request.getParameter("password");
    %>
    
    <%-- Navigation Bar Component --%>
    <jsp:include page="components/navbar.jsp" />

    <div class="container">
      <h1 class="">Welcome to Student Management System</h1>
      <div class="img-content">
        <img src="img/img.png" class="img-thumbnail" alt="" srcset="">
      </div>
    </div>

  </body>
</html>
