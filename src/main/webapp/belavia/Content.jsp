<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
    <%@include file="FlightsInclude.jsp"%>
    <style>
        body{
            text-align: center;
        }
        form{
            text-align: center;
        }
    </style>
</head>
<body>

<br/>
<table align="center" border="">
    <caption>Flights INFO</caption>
    <tr bgcolor="aqua">
        <td align="center">ID</td>
        <td align="center">Number</td>
        <td align="center">Scheduled Departure</td>
        <td align="center">Scheduled Arrival</td>
        <td align="center">Departure Airport</td>
        <td align="center">Arrival Airport</td>
        <td align="center">Status</td>
        <td align="center">Aircraft Code</td>
        <td align="center">Actual Departure</td>
        <td align="center">Actual Arrival</td>
    </tr>


<c:forEach items="${allFlights}"
               begin="${begin}"
               end="${end}"
               var = "flight">
    <tr>
        <td align="center">${flight.getFlight_id()}</td>
        <td>${flight.flight_no}</td>
        <td>${flight.scheduled_departure}</td>
        <td>${flight.scheduled_arrival}</td>
        <td>${flight.departure_airport}</td>
        <td>${flight.arrival_airport}</td>
        <td>${flight.status}</td>
        <td>${flight.aircraft_code}</td>
        <td>${flight.actual_departure}</td>
        <td>${flight.actual_arrival}</td>
        </c:forEach>
    </tr>
</table>
<form action="${pageContext.request.contextPath}/flights"  method="POST">
    <input type="submit" value="Back" id="Back" name="Back">
    <input type="submit" value="Next" id="Next" name="Next">
</form>

<form action="${pageContext.request.contextPath}/flights" method="POST">
    <input type="submit" value="Cancel" id="Cancel" name="Cancel">
</form>

</body>
</html>
