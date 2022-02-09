<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/9/2022
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Detail Position</title>
</head>
<body>
<p>
    <button> <a href="${pageContext.request.contextPath}/books">Back to Books List</a></button>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["position"].getName()}</td>
    </tr>
    <tr>
        <td>Describe: </td>
        <td>${requestScope["position"].getDescribe()}</td>
    </tr>
    <tr>
        <td>QuantityLimit: </td>
        <td>${requestScope["position"].getQuantityLimit()}</td>
    </tr>
    <tr>
        <td>Quantity: </td>
        <td>${requestScope["position"].getQuantity()}</td>
    </tr>

</table>
</body>
</html>
