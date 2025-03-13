<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
     <%@page import="dto.User"%>
     <%@page import="dto.Travel"%>
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="travelsave.css">
<title>Insert title here</title>
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
                <th>Preferred Travel Mode</th>
                <th>Alternative Travel Mode</th>
                <th>Distance</th>
                <th>Reduction</th>
                <th>Note</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Travel> travelList =user.getTravel(); 
                if (travelList != null) {
                    for (Travel t : travelList) {
            %>
            <tr>
                <td><%= t.getName() %></td>
                <td><%= t.getPrefferedMode() %></td>
                <td><%= t.getInsteadMode() %></td>
                <td><%= t.getDistance() %></td>
                <td><%= t.getReduce() %></td>
                <td><%= t.getNote() %></td>
            </tr>
            <% 
                    } 
                } else { 
            %>
            <tr>
                <td colspan="6" class="text-center">No travel history available.</td>
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