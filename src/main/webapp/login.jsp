<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="login.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="new.jsp" %>
 <div class="contain">

 <form action="loginUser" method="post"  class="forms" >
 <h1 style="text-align:center;margin-bottom: 20px;">Login</h1>
 <label class="text">Email:</label>
 <input class="text" type="text" name="email" required> 
 <label class="text">Password:</label>
 <input class="text" type="password" name="password" required> <br> 
<input class="text" type="submit"  style="text-align:center;background-color: #007bff;"> 
 </form>
 </div>
<%@include file="footer.jsp" %>
</body>
</html>