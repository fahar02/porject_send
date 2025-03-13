<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dto.User"%>
    <%User user1=(User)session.getAttribute("user");%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="new.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.6.0/css/fontawesome.min.css">
    <title>Document</title>
</head>
<body>
    <%if(user1==null){%>
<div class="container">
        <nav class="menu-area">
            <ul>
                <li>
                    <div class="dropdown">
                        <button onclick="myFunction()" class="dropbtn">
                            <div class="m"></div>
                            <div class="m"></div>
                            <div class="m"></div>
                        </button>
                        <div id="myDropdown" class="dropdown-content">
                            <a class="link"  href="#">My saving History</a>
                            <a class="link" href="#">My target</a>
                            <a class="link" href="#">Help</a>
                            <a class="link" href="#">Social Media</a>
                            <a class="link" href="#">Acknowledgments</a>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="headerLogo">
                        <img class="logo" src="images/logo.png" alt="logo" style="height: 100px; width: 150px;">
                    </div>
                </li>
                <li><a href="#">Home</a></li>
                <li><a href="#">AboutUs</a></li>
                <li><a href="#">Service</a></li>
                <li><a href="#">Community</a></li>
                <li><a href="contact.html">Contact</a></li> 
                <li><a href="login.jsp" class="btn btn-primary btn-lg"><i class="fa fa-user-circle-o" style="font-size:36px"></i> Login</a></li>
                <li><a href="registration.jsp" class="btn btn-primary btn-lg"><i class="fa fa-user-circle-o" style="font-size:36px"></i> Registration</a></li>
            </ul>
        </nav>
    </div>
<%}else{%>
<div class="container">
        <nav class="menu-area">
            <ul>
                <li>
                    <div class="dropdown">
                        <button onclick="myFunction()" class="dropbtn">
                            <div class="m"></div>
                            <div class="m"></div>
                            <div class="m"></div>
                        </button>
                        <div id="myDropdown" class="dropdown-content">
                            <a class="link" href="userhistory?id=<%=user1.getUserId()%>">My saving History</a>
                            <a class="link" href="#">My target</a>
                            <a class="link" href="#">Help</a>
                            <a class="link" href="#">Social Media</a>
                            <a class="link" href="#">Acknowledgments</a>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="headerLogo">
                        <img class="logo" src="images/logo.png" alt="logo" style="height: 100px; width: 150px;">
                    </div>
                </li>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="#">AboutUs</a></li>
                <li><a href="#">Service</a></li>
                <li><a href="#">Community</a></li>
                <li><a href="contact.html">Contact</a></li> 
                <li><a href="login.jsp" class="btn btn-primary btn-lg"><i class="fa fa-user-circle-o" style="font-size:36px"></i><%=user1.getName()%></a></li>
                <li><a href="logoutuser" class="btn btn-primary btn-lg"><i class="fa fa-user-circle-o" style="font-size:36px"></i>Log-out</a></li>
            </ul>
        </nav>
    </div>
<%}%>
    <script src="ec.js"></script>
</body>
</html>
