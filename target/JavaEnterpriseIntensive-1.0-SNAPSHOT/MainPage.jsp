<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.04.2022
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%@include file="jsps/include.jsp"%>
    <style>
        form{
            text-align: center;
        }
    </style>
</head>
<body>
<br>
<br>
<form>
    <button type="submit" value="SIGN IN" formaction="http://localhost:8080/JavaEnterpriseIntensive-1.0-SNAPSHOT/ui/signIn" formmethod="GET"> SIGN IN </button>
    <button type="submit" value="SIGN UP" formaction="http://localhost:8080/JavaEnterpriseIntensive-1.0-SNAPSHOT/ui/signup" formmethod="GET"> SIGN UP</button>
</form>
</body>
</html>
