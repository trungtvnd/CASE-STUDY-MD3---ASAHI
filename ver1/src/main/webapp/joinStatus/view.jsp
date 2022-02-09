<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/9/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Display Status</title>
</head>
<body>
<div>
    <table>
        <tr>
            <td>Status: </td>
            <td>Quantity: </td>
        </tr>
        <c:forEach var="joinStatuses" items="${requestScope['joinStatuses']}">
            <tr>
                <td>${joinStatuses.getStatus()}</td>
                <td>${joinStatuses.getQuantity()}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
