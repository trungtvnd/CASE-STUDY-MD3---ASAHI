<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 11/02/2022
  Time: 08:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="view1.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active">
                    <div class="dropdown">
                        <button class="dropbtn">Home<span class="glyphicon glyphicon-home "></span></button>
                    </div>
                </li>
                <li>
                    <div class="dropdown">
                        <button class="dropbtn"><a href="${pageContext.request.contextPath}/books" style="color: white">Books<span class="glyphicon glyphicon-th-list "></span></a></button>
                    </div>
                </li>
                <%--                <li><a href="/books?action=joinType">KIND OF BOOK</a></li>--%>
                <li>
                    <div class="dropdown">
                        <button class="dropbtn">Kind of book<span class="glyphicon glyphicon-sort"></span></button>
                        <div class="dropdown-content">
                            <a href="#" class="titlebook">Political & Law</a>
                            <a href="#">Science</a>
                            <a href="#">Economic</a>
                            <a href="#">Literature & Art</a>
                            <a href="#">Cultural & Historical</a>
                            <a href="#">Curriculum</a>
                            <a href="#">Story & Novel</a>
                            <a href="#">Mentality, Spirituality & Religion</a>
                            <a href="#">Children</a>
                        </div>
                    </div>
                </li>
                <%--                <li><a href="/books?action=joinPosition">STATISTIC BY POSITION</a></li>--%>
                <li>
                    <div class="dropdown">
                        <button class="dropbtn">Positions<span class="glyphicon glyphicon-sort"></span></button>
                        <div class="dropdown-content">
                            <c:forEach items="${positions}" var="position">
                                <a href="#"> ${position.getName()}</a>
                            </c:forEach>
                        </div>
                    </div>
                </li>
                <%--                <li><a href="/books?action=joinStatus">STATISTIC BY STATUS</a></li>--%>
                <li>
                    <div class="dropdown">
                        <button class="dropbtn">Authors<span class="glyphicon glyphicon-sort"></span></button>
                        <div class="dropdown-content">
                            <c:forEach items="${authors}" var="author">
                                <a href="#"> ${author.getName()}</a>
                            </c:forEach>
                        </div>
                    </div>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${username}</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
