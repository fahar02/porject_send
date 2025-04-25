<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="materail.css">
<link >
<%@include file="all.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@include file="myGHGSavingHeader.jsp" %>
<form action="materail" method="post">
        <div class="boxBody">
            <!-- Materials -->
            <div class="Box material">
                <div class="contain">
                    <h3>Materials</h3>
                    <label for="materials">List Materials:</label>
                    <select id="materials" name="materials" required>
                        <option value="">Select Material</option>
                        <option value="Steel">Steel</option>
                        <option value="Stainless Steel">Stainless Steel</option>
                        <option value="Aluminium">Aluminium</option>
                        <option value="Copper">Copper</option>
                        <option value="Plastic">Plastic</option>
                        <option value="Ceramics">Ceramics</option>
                        <option value="Glass">Glass</option>
                        <option value="Paper">Paper</option>
                    </select>
                </div>
            </div>
    
            <!-- Duration of use -->
            <div class="Box duration">
                <div class="contain">
                    <h3>Duration of use</h3>
                    <label for="duration">Mode of use:</label>
                    <input type="number" id="duration" name="duration" required>
                </div>
            </div>
    
             <!-- Consumption -->
            <div class="Box consuption">
                <div class="contain">
                    <h3>Consumption per unit:</h3>
                    <button type="button" onclick="cal()">calculate</button>
                    <input name="consumption" id="input3">
                </div>
            </div>
    
            <!-- Date and Note -->
            <div class="Box date">
                <div class="contain">
                    <label for="note">Add Note:</label>
                    <input type="text" id="note" name="note">
                </div>
            </div>
    
            <!-- Save Button -->
            <div class="BoxButton save">
                <button type="submit">Save Record</button>
            </div>
        </div>
    </form>
   <script src="materailcal.js"></script>
<%@include file="footer.jsp" %>
<%@include file="all.jsp" %>
</body>
</html>