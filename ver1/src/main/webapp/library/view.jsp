<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/7/2022
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display Books</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .httpDirect{
            text-decoration: none;
            color: white;

        }
        table{
            border: black solid 1px;
            border-collapse: collapse;
            border-radius: 5px;
            width: 1500px;
            height: 400px;

        }
        table tr,th,td {
            padding: 5px;
            text-align: center;
        }
        tr:hover{
            background-color: #725454;
            cursor:pointer;
        }
        tr:nth-child(even) td{
            background-color: rgba(245, 221, 136, 0.99);
        }
        .trTable{
            background-color: antiquewhite;
        }
        .display{
            width: 1000px;
        }
        .imgTable{
            width: 80px;
            height: 120px;
        }

    </style>

</head>
<body>
<button class="btn btn-success"><a class="httpDirect" href="/books?action=create">Create New Book</a></button>

<div class="display">
    <table>
        <tr class="trTable">
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>Describe</th>
            <th>Language</th>
            <th>Status</th>
            <th>Type</th>
            <th>Publish</th>
            <th>Position</th>
            <th>YearPublish</th>
            <th>Image</th>
            <th colspan="2"></th>
        </tr>
        <c:forEach var="book" items="${requestScope['books']}">
            <tr>
                <td>${book.getId()}</td>
                <td>${book.getName()}</td>
                <td>${book.getAuthorID()}</td>
                <td>${book.getDescribe()}</td>
                <td>${book.getLanguage()}</td>
                <td>${book.getStatus()}</td>
                <td>${book.getType()}</td>
                <td>${book.getPublish()}</td>
                <td>${book.getPositionID()}</td>
                <td>${book.getYearPublish()}</td>
                <td><img class="imgTable" src="${book.getImage()}" alt=""></td>
                <td><button class="btn btn-success btn-sm"><a class="httpDirect" href="${pageContext.request.contextPath}/books?action=edit&id=${book.getId()}">Edit</a></button></td>
                <td><button class="btn btn-success btn-sm" ><a class="httpDirect" href="${pageContext.request.contextPath}/books?action=delete&id=${book.getId()}">Delete</a></button></td>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
