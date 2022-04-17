<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.04.2022
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TERROGRAM</title>
</head>
<body>

    <jsp:useBean id="admin" class="org.example.JavaEnterpriseIntensive.servlets.jsp.User" scope="application">
        <jsp:setProperty name="admin" property="login" value="admin" />

        <jsp:setProperty name="admin" property="password" value="admin"/>

    </jsp:useBean>

    <form action="RegServlet" method="post">
        Your Login:<input type="text" name="login"/><br/>
        Your Password<input type="text" name="password"/><br/>
        Your Full Name<input type="text" name="fullName"/><br/>
        Your BirthDate (dd.MM.yyyy)<input type="text" name="birthDate"/><br/>
        <input type="submit" value="OK"/>
    </form>

</body>
</html>
