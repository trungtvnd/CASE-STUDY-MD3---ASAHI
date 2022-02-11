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

        .imgTable{
            width: 80px;
            height: 120px;
        }
        table{
            border: black solid 1px;
            border-collapse: collapse;
            border-radius: 5px;
            width: 100%;
        }
        table tr,th,td {
            padding: 5px;
            text-align: center;
        }
        tr:hover{
            background-color:#ddd;
            cursor:pointer;
        }
        tr:nth-child(even) td{
            /*background-color: rgba(245, 221, 136, 0.99);*/
            background-color: rgba(50, 115, 220, 0.3);
        }
        .trTable{
            background-color: antiquewhite;
        }
    </style>

</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/books?action=search" method="post">
            <label><input type="text" name="searchBook" placeholder="Name of Book"></label>
            <label><input type="submit" value="SEARCH"></label>
    </form>
</div>
<div class="divSort">

<div>
    <form action="/books?action=sortByPublish" method="post">
        <label> SORT BY PUBLISH
            <select name="sortByPublish">
                <c:forEach items="${publishes}" var="publish">
                    <option value="${publish.getName()}">${publish.getName()}</option>
                </c:forEach>
            </select>
        </label>
        <button type="submit">SUBMIT</button>
    </form>
    <form action="/books?action=sortByPosition" method="post">
        <label> SORT BY POSITION
            <select name="sortByPosition">
                <c:forEach items="${positions}" var="position">
                    <option value="${position.getName()}">${position.getName()}</option>
                </c:forEach>
            </select>
        </label>
        <button type="submit">SUBMIT</button>
    </form>
    <form action="/books?action=sortByAuthor" method="post">
        <label> SORT BY AUTHORS
            <select name="sortByAuthor">
                <c:forEach items="${authors}" var="author">
                    <option value="${author.getName()}">${author.getName()}</option>
                </c:forEach>
            </select>
        </label>
        <button type="submit">SUBMIT</button>
    </form>

</div>
</div>
<button class="btn btn-success"><a class="httpDirect" href="${pageContext.request.contextPath}/books?action=create">Create New Book</a></button>
<button class="btn btn-success"><a class="httpDirect" href="${pageContext.request.contextPath}/books?action=books">Back To Book List</a></button>
<div style="float: right">
    <c:if test="${requestScope['checkView'] == true}">
        <label><span>Quantity :</span> <input style="color: red; width: 50px" type="text" value="${quantityAllBook}"></label>
    </c:if>
    <c:if test="${requestScope['checkPublish'] == true}">
        <label>Quantity: <input style="color: red; width: 50px" type="text" value="${quantityPublish}"></label>
    </c:if>
    <c:if test="${requestScope['checkPosition'] == true}">
        <label>Quantity: <input style="color: red; width: 50px" type="text" value="${quantityPosition}"></label>
    </c:if>
</div>
<div class="display">
    <c:if test="${requestScope['books'].isEmpty()}">
        <h4 style="color: red">Not Found</h4>
    </c:if>

    <table class="displayTable">
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
                <td ><a href="${pageContext.request.contextPath}/books?action=view&id=${book.getId()}">${book.getName()}</a></td>
                <td>${book.getAuthorID()}</td>
                <td>${book.getDescribe()}</td>
                <td>${book.getLanguage()}</td>
                <td>${book.getStatus()}</td>
                <td>${book.getType()}</td>
                <td>${book.getPublish()}</td>
                <td ><a class="getLink" href="${pageContext.request.contextPath}/positions?action=view&name=${book.getPositionID()}">${book.getPositionID()}</a></td>
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
