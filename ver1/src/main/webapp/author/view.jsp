<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/8/2022
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Author Management</h1>
    <h2>
        <a href="/authors?action=create">Add New Author</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Email</th>
            <th colspan="2">Actions</th>
        </tr>
        <c:forEach var="author" items="${listAuthor}">
            <tr>
                <td><c:out value="${author.id}"/></td>
                <td><c:out value="${author.name}"/></td>
                <td><c:out value="${author.address}"/></td>
                <td><c:out value="${author.email}"/></td>
                <td>
                    <a href="/authors?action=edit&id=${author.id}">Edit</a>
                    <a href="/authors?action=delete&id=${author.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
