<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.04.2022
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
    <style>
        table.REGFORM{
            font-size: xx-large;
        }
    </style>
</head>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jsps/include.jsp"%>
<body>

<table width="100%" class="REGFORM" >
    <tr>
        <td bgcolor="#778899" align="center">

            <form action="http://localhost:8080/JavaEnterpriseIntensive-1.0-SNAPSHOT/api/user" method="POST">
            <input type="text" id="login" name="login"/>
                <label for="login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login</label><br>
            <input type="text" id="password" name="password">
                <label for="password"> Password </label><br>
            <input type="text" id="fullName" name="fullName"/>
                <label for="fullName"> FullName </label><br>
            <input  type="text" id="birthdate" name="birthDate"/>
                <label for="birthdate"> Birthdate<sub><font size="-1">(dd.MM.yyyy)</font></sub> </label><br>
                <input type="submit"/>
            </form>
        </td>
    </tr>
</table>

</body>
</html>
