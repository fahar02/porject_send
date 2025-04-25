<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="home.css">
<title>Insert title here</title>
</head>
<body>

<%@include file="new.jsp" %>
<div class="homeContainer"> 
        <a href="showtravel?id=<%=user.getUserId()%>"><button class="btn btn1" type="submit" >Travel History</button></a>
        <a href="showhome?id=<%=user.getUserId()%>"><button class="btn btn2" type="submit" >Home History</button></a>
        <a href="showmaterial?id=<%=user.getUserId()%>"><button class="btn btn3" type="submit" >Matrial History</button></a>
    </div>
    <!-- New two buttons with equal height and width -->
<div class="extraContainer">
    <a href="totalcalculation?id=<%=user.getUserId()%>"><button class="btn btn4">over all co2 calculation</button></a>
</div>
<div class="dataBlock" id="co2ReduceData">
    <h3>CO2 Reduction Data</h3>
    <p>
        <% if (request.getAttribute("reduce") != null) { %>
            <%= request.getAttribute("reduce") %> kg CO₂ reduced
        <% } else { %>
            No data loaded yet.
        <% } %>
    </p>
</div>

<div class="dataBlock" id="co2GenerationData">
    <h3>CO2 Generation Data</h3>
    <p>
        <% if (request.getAttribute("generation") != null) { %>
            <%= request.getAttribute("generation") %> kg CO₂ generated
        <% } else { %>
            No data loaded yet.
        <% } %>
    </p>
</div>
	
    <%@include file="footer.jsp" %>
    <%@include file="all.jsp" %>
</body>
</html>