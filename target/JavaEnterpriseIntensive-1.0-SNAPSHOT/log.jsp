<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.04.2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%@include file="jsps/include.jsp"%>
    <%--<%! String message;%>
    <% String message = (String) request.getAttribute("message");
    if(message == null){
        message = "NICE TO MEET YOU";
    }
    %>--%>

</head>
<body>
<p align="center">${message}</p>
<table width="100%" class="REGFORM" >
    <tr>
        <td bgcolor="#778899" align="center"  >

            <form action="http://localhost:8080/JavaEnterpriseIntensive-1.0-SNAPSHOT/api/login" method="POST">
                <input type="text" id="login" name="login"/>
                <label for="login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login</label><br>
                <input type="text" id="password" name="password">
                <label for="password"> Password </label><br>
                <input type="submit"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
