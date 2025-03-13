<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="homeApplience.css">
<%@include file="all.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@include file="myGHGSavingHeader.jsp" %>
<form action="myHome" method="post">
        <div class="boxBody">
            <!-- Home Appliance Selection -->
            <div class="Box applience">
                <div class="contain">
                    <h3>Home</h3>
                    <label>Home Appliance</label>
                    <select name="homeAppliance" required>
                        <option value="">List of Devices</option>
                        <option value="Heater">Heater</option>
                        <option value="AC">AC</option>
                        <option value="Water Heater">Water Heater</option>
                        <option value="Light">Light</option>
                        <option value="Other Electronic Device">Other Electronic Device</option>
             
                    </select>
                </div>
            </div>
    
            <!-- Duration of Use -->
            <div class="Box duration">
                <div class="contain">
                    <h3>Duration of use</h3>
                    <label for="duration">Duration (in hours):</label>
                    <input type="number" id="duration" name="duration" required>
                </div>
            </div>
    
            <!-- Consumption per Unit -->
            <div class="Box consuption">
                <div class="contain">
                    <h3>Consumption</h3>
                    <label for="consumption">Consumption per unit (kWh):</label>
                    <input type="number" id="consumption" name="consumption" placeholder="100 gram/hour" value="100">
                </div>
            </div>
    
            <!-- Date and Note -->
            <div class="Box date">
                <div class="contain">
                    <label for="note">Add Note</label>
                    <input type="text" id="note" name="note">
                </div>
            </div>
    
            <!-- Save Button -->
            <div class="BoxButton save">
                <button type="submit">Save Record</button>
            </div>
        </div>
    </form>
<%@include file="footer.jsp" %>
<%@include file="all.jsp" %>
</body>
</html>