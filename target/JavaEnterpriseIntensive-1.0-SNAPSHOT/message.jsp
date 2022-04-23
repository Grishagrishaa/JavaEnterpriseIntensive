<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.04.2022
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%@include file="jsps/include.jsp"%>
</head>
<body>
<p align="center">${smsmessage}</p>
    <table width="100%" class="REGFORM" >
        <tr>
            <td bgcolor="#778899" align="center"  >
                <form action="http://localhost:8080/JavaEnterpriseIntensive-1.0-SNAPSHOT/api/message" method="POST">
                    <input type="text" name="recipient" id="recipient" aria-label="Recipient">
                    <label for="recipient">RECIPIENT</label>
                    <input type="text" name="sms" id="sms" aria-label="SMS">
                    <label for="sms">TEXT</label>
                    <input TYPE="submit" VALUE="SEND">
                    <button type="submit" value="MY MESSAGES"
                            formaction="http://localhost:8080/JavaEnterpriseIntensive-1.0-SNAPSHOT/ui/user/chats"
                            formmethod="GET"> MY MESSAGES</button>
                </form>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
