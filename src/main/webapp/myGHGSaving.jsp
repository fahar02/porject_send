<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="myGHGSaving.css">
<%@include file="all.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@include file="myGHGSavingHeader.jsp" %>
<form action="mySavings" method="post">
        <div class="boxBody">
            <!-- Distance Travelled -->
            <div class="Box distance">
                <div class="contain">
                    <h3>Distance Travelled in km</h3>
                    <input type="number" name="distance" required>
                </div>
            </div>

            <!-- Mode of Travel -->
            <div class="Box travelled">
                <div class="contain">
                    <h3>Travelled by</h3>
                    <label for="travelMode">Mode of travel:</label>
                    <select id="travelMode" name="travelMode" required>
                        <option value="">Select Mode of Travel</option>
                        <option value="Walking">Walking</option>
                        <option value="Bicycle">Bicycle</option>
                        <option value="Bike">Bike</option>
                        <option value="Bus">Bus</option>
                        <option value="Train">Train</option>
                        <option value="Car">Car</option>
                        <option value="Flight">Flight</option>
                    </select>
                </div>
            </div>

            <!-- Alternative Mode of Travel -->
            <div class="Box instead">
                <div class="contain">
                    <h3>Alternative Mode of Travel</h3>
                    <label for="travelInstead">Mode of Travel:</label>
                    <select id="travelInstead" name="travelInstead" required>
                        <option value="">List of Vehicles</option>
                        <option value="Bicycle">Bicycle</option>
                        <option value="Bike">Bike</option>
                        <option value="Bus">Bus</option>
                        <option value="Train">Train</option>
                        <option value="Car">Car</option>
                        <option value="Flight">Flight</option>
                    </select>
                </div>
            </div>

            <!-- Date and Note -->
            <div class="Box date">
                <div class="contain">
                    <label for="note">Add Note</label>
                    <input type="text" name="note">
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