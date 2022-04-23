<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.04.2022
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="jsps/include.jsp"%>
    <%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
        <c:forEach items="${messageBox}"
                   var="item">
            <c:out value="${item}"/>
        </c:forEach>

</body>
</html>
