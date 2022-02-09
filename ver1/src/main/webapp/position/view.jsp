<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/8/2022
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Position List</title>
</head>
<body>
<button ><a class="httpDirect" href="/positions?action=create">Create New Position</a></button>

<div class="display">
    <table>
        <tr class="trTable">
            <th>ID</th>
            <th>Name</th>
            <th>Describe</th>
            <th>Quantity Limit</th>
            <th>Quantity</th>
            <th colspan="1"></th>
        </tr>
        <c:forEach var="position" items="${requestScope['positions']}">
            <tr>
                <td>${position.getId()}</td>
                <td>${position.getName()}</td>
                <td>${position.getDescribe()}</td>
                <td>${position.getQuantityLimit()}</td>
                <td>${position.getQuantity()}</td>

                <td><button class="btn btn-success btn-sm"><a class="httpDirect" href="${pageContext.request.contextPath}/positions?action=edit&id=${position.getId()}">Edit</a></button></td>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
