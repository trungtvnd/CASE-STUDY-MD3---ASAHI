<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/9/2022
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display Quantity Positions</title>
</head>
<body>
<div>
    <table>
        <tr>
            <td>Name: </td>
            <td>Quantity: </td>
        </tr>
        <c:forEach var="joinPositions" items="${requestScope['joinPositions']}">
            <tr>
                <td>${joinPositions.getName()}</td>
                <td>${joinPositions.getQuantity()}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
