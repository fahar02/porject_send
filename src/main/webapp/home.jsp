<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="home.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="all.jsp" %>
<%@include file="new.jsp" %>
<div class="homeContainer"> 
        <a href="myGHGSaving.jsp"><button class="btn btn1" type="submit" >Add Travel</button></a>
        <a href="homeApplience.jsp"><button class="btn btn2" type="submit" >Add Home</button></a>
        <a href="material.jsp"><button class="btn btn3" type="submit" >Add Matrial</button></a>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>