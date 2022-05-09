<%--
  Created by IntelliJ IDEA.
  User: GrigoryDmitrievich
  Date: 6.05.22
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>AirPorts</title>
    <style>
        img{
            text-align: center;
        }
        H1{
            text-align: center;
        }
    </style>
</head>
<body>
<p><img src="logo.png" alt="plane"></p>
<H1><pre>BELAVIA AIRLINES - НЕ ВАЖНО С КЕМ, НЕ ВАЖНО КАК, ГЛАВНОЕ ВМЕСТЕ</pre></H1>

<table align="center" border="">
    <caption>AirPorts INFO</caption>
    <tr bgcolor="aqua">
        <td align="center">Number</td>
        <td align="center">AirPort Code</td>
        <td align="center">AirPort Name</td>
        <td align="center">City</td>
        <td align="center">Coordinates</td>
        <td align="center">Timezone</td>
    </tr>

    <%! private int portCount = 0; %>

        <c:forEach items="${allAirPorts}"
                            var = "port">
    <tr>
            <td align="center"><%= ++portCount %></td>
            <td align="center">${port.airport_code}</td>
            <td>${port.airport_name}</td>
            <td>${port.city}</td>
            <td>${port.coordinates}</td>
            <td>${port.timezone}</td>
        </c:forEach>
        <% portCount = 0; %>
    </tr>
</table>

</body>
</html>
