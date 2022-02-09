<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/8/2022
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Publish</title>
</head>
<body>
<center>
    <h1>Publish Management</h1>
    <h2>
        <a href="/publishes?action=create">Add New Author</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Publish</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Email</th>
            <th >Actions</th>
        </tr>
        <c:forEach var="publish" items="${listPublish}">
            <tr>
                <td><c:out value="${publish.id}"/></td>
                <td><c:out value="${publish.name}"/></td>
                <td><c:out value="${publish.address}"/></td>
                <td><c:out value="${publish.email}"/></td>
                <td>
                    <a href="/publishes?action=edit&id=${publish.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
