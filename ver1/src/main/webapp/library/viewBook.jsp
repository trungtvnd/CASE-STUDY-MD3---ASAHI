<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/9/2022
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Detail Book</title>
</head>
<body>
<div>
    <p>
        <button> <a href="${pageContext.request.contextPath}/books">Back to Book List</a></button>
    </p>
    <table>
        <tr>
            <td>Name: </td>
            <td>${requestScope["book"].getName()}</td>
        </tr>
        <tr>
            <td>Author: </td>
            <td>${requestScope["book"].getAuthorID()}</td>
        </tr>
        <tr>
            <td>Describe: </td>
            <td>${requestScope["book"].getDescribe()}</td>
        </tr>
        <tr>
            <td>Language: </td>
            <td>${requestScope["book"].getLanguage()}</td>
        </tr>
        <tr>
            <td>Status: </td>
            <td>${requestScope["book"].getStatus()}</td>
        </tr>
        <tr>
            <td>Type: </td>
            <td>${requestScope["book"].getType()}</td>
        </tr>
        <tr>
            <td>Publish: </td>
            <td>${requestScope["book"].getPublish()}</td>
        </tr>
        <tr>
            <td>Position: </td>
            <td>${requestScope["book"].getPositionID()}</td>
        </tr>
        <tr>
            <td>YearPublish: </td>
            <td>${requestScope["book"].getYearPublish()}</td>
        </tr>
        <tr>
            <td>Image: </td>
            <td><img src="${requestScope["book"].getImage()}" alt=""></td>
        </tr>

    </table>
</div>
</body>
</html>
