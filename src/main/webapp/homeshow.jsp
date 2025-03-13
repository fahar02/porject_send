<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
     <%@page import="dto.User"%>
     <%@page import="dto.Home"%>
      <% User user=(User)session.getAttribute("user"); 
    if(user==null){
    	response.sendRedirect("login.jsp");
    	session.setAttribute("login-error","pleas login");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="travelsave.css">
</head>
<body>
<%@include file="new.jsp" %>
<div class="travelcontainer">
   
    <div class="travelheading">
     <h3>Profile  :  </h3>
        <h4><%= user.getName() %>   </h4>
        
    </div>

    <h2>My Travel History</h2>

    <!-- Travel History Table -->
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Name</th>
                <th>User Duration</th>
                <th>co2 generated</th>
                <th>Note</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Home> homelist =user.getHome(); 
                if (homelist != null) {
                    for (Home t : homelist) {
            %>
            <tr>
                <td><%= t.getName() %></td>
                <td><%= t.getDuration() %></td>
                <td><%= t.getEmition() %></td>
                <td><%= t.getNote() %></td>
            </tr>
            <% 
                    } 
                } else { 
            %>
            <tr>
                <td colspan="6" class="text-center">No home history available.</td>
            </tr>
            <% 
                }
            %>
        </tbody>
    </table>
</div>

<%@include file="footer.jsp" %>
<%@include file="all.jsp" %>
<script src="menu.js"></script>

</body>
</html>