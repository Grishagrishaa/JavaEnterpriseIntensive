<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.04.2022
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="jsps/include.jsp"%>
    <style>
        form{
            text-align: center;
        }

    </style>
</head>
<body>
    <p align="center">${StatsData.usersCount} USERS COUNT</p>

    <p align="center"> ${StatsData.messagesCount} MESSAGES COUNT</p>

    <form align="center">
        <button align="center" value="REFRESH" type="submit"
                formaction="http://localhost:8080/JavaEnterpriseIntensive-1.0-SNAPSHOT/ui/admin/stats"
                formmethod="GET">
            REFRESH
        </button>
    </form>
</body>
</html>
