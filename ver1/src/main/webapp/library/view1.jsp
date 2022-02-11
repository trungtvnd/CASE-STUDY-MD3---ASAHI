<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 11/02/2022
  Time: 08:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://mdbootstrap.com/docs/b4/jquery/getting-started/cdn/">
    <link rel="stylesheet" href="view1.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        body, html {
            padding: 0;
            margin: 0;
            text-align: center;
        }

        /* Styles the thumbnail */
        a.lightbox img {
            height: 150px;
            border: 3px solid white;
            box-shadow: 0px 0px 8px rgba(0, 0, 0, .3);
            margin: 94px 20px 20px 20px;
        }

        /* Styles the lightbox, removes it from sight and adds the fade-in transition */
        .lightbox-target {
            position: fixed;
            top: -100%;
            width: 100%;
            background: rgba(0, 0, 0, .7);
            width: 100%;
            opacity: 0;
            -webkit-transition: opacity .5s ease-in-out;
            -moz-transition: opacity .5s ease-in-out;
            -o-transition: opacity .5s ease-in-out;
            transition: opacity .5s ease-in-out;
            overflow: hidden;
        }

        /* Styles the lightbox image, centers it vertically and horizontally, adds the zoom-in transition and makes it responsive using a combination of margin and absolute positioning */
        .lightbox-target img {
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            max-height: 0%;
            max-width: 0%;
            border: 3px solid white;
            box-shadow: 0px 0px 8px rgba(0, 0, 0, .3);
            box-sizing: border-box;
            -webkit-transition: .5s ease-in-out;
            -moz-transition: .5s ease-in-out;
            -o-transition: .5s ease-in-out;
            transition: .5s ease-in-out;
        }

        /* Styles the close link, adds the slide down transition */
        a.lightbox-close {
            display: block;
            width: 50px;
            height: 50px;
            box-sizing: border-box;
            background: white;
            color: black;
            text-decoration: none;
            position: absolute;
            top: -80px;
            right: 0;
            -webkit-transition: .5s ease-in-out;
            -moz-transition: .5s ease-in-out;
            -o-transition: .5s ease-in-out;
            transition: .5s ease-in-out;
        }

        /* Provides part of the "X" to eliminate an image from the close link */
        a.lightbox-close:before {
            content: "";
            display: block;
            height: 30px;
            width: 1px;
            background: black;
            position: absolute;
            left: 26px;
            top: 10px;
            -webkit-transform: rotate(45deg);
            -moz-transform: rotate(45deg);
            -o-transform: rotate(45deg);
            transform: rotate(45deg);
        }

        /* Provides part of the "X" to eliminate an image from the close link */
        a.lightbox-close:after {
            content: "";
            display: block;
            height: 30px;
            width: 1px;
            background: black;
            position: absolute;
            left: 26px;
            top: 10px;
            -webkit-transform: rotate(-45deg);
            -moz-transform: rotate(-45deg);
            -o-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }

        /* Uses the :target pseudo-class to perform the animations upon clicking the .lightbox-target anchor */
        .lightbox-target:target {
            opacity: 1;
            top: 0;
            bottom: 0;
            overflow: scroll;
        }

        .lightbox-target:target img {
            max-height: 100%;
            max-width: 100%;
        }

        .lightbox-target:target a.lightbox-close {
            top: 0;
        }

        /* Remove the navbar's default rounded borders and increase the bottom margin */
        .navbar {
            margin-bottom: 50px;
            border-radius: 0;
        }

        /* Remove the jumbotron's default bottom margin */
        .jumbotron {
            margin-bottom: 0;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            padding: 25px;
        }

        .logo {
            border-radius: 50%;
            width: 100px;
            height: 100px;
        }

        .nav navbar-nav {
            font-size: 20px;
        }

        body {
        }

        /* Style The Dropdown Button */
        .dropbtn {
            background-color: black;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }

        /* The container <div> - needed to position the dropdown content */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* Dropdown Content (Hidden by Default) */
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        /* Links inside the dropdown */
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        /* Change color of dropdown links on hover */
        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }

        /* Show the dropdown menu on hover */
        .dropdown:hover .dropdown-content {
            display: block;
        }

        /* Change the background color of the dropdown button when the dropdown content is shown */
        .dropdown:hover .dropbtn {
            background-color: #3e8e41;
        }

        .img-responsive {
            width: 80px;
            height: 200px;
        }

        .panel-heading {
            text-align: center;
        }

        /* Remove the navbar's default rounded borders and increase the bottom margin */
        .navbar {
            margin-bottom: 50px;
            border-radius: 0;
        }

        /* Remove the jumbotron's default bottom margin */
        .jumbotron {
            margin-bottom: 0;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            padding: 25px;
        }

        .logo {
            border-radius: 50%;
            width: 100px;
            height: 100px;
        }

        .nav navbar-nav {
            font-size: 20px;
        }

        body {
            background-color: mistyrose;
        }

        /* Style The Dropdown Button */
        .dropbtn {
            background-color: black;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }

        /* The container <div> - needed to position the dropdown content */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* Dropdown Content (Hidden by Default) */
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        /* Links inside the dropdown */
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        /* Change color of dropdown links on hover */
        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }

        /* Show the dropdown menu on hover */
        .dropdown:hover .dropdown-content {
            display: block;
        }

        /* Change the background color of the dropdown button when the dropdown content is shown */
        .dropbtn:hover {
            background-color: #3e8e41;
        }

        .img-responsive {
            width: 80px;
            height: 200px;
        }

        .panel-heading {
            text-align: center;
        }

        .jumbotron {
            background-image: url("https://mcdn.wallpapersafari.com/medium/55/22/P5ABoL.jpg");
            background-repeat: no-repeat;
            background-position: center center;
            background-size: cover;

        }

        .active-pink input.form-control[type=text] {
            border-bottom: 1px solid #f48fb1;
            box-shadow: 0 1px 0 0 #f48fb1;
        }

        .input-group.md-form.form-sm.form-2 input {
            border: 1px solid #bdbdbd;
            border-top-left-radius: 0.25rem;
            border-bottom-left-radius: 0.25rem;
        }

        .input-group.md-form.form-sm.form-2 input.red-border {
            border: 1px solid #ef9a9a;
        }

    </style>
</head>
<body>
<div class="jumbotron">
    <div class="container text-center">
        <h1 style=" font-family: 'Nothing You Could Do',cursive;">ASAHI LIBRARY</h1>
        <img class="logo" src="/picture/library.png" alt="">
    </div>
</div>

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
                        <button class="dropbtn">Home <span class="glyphicon glyphicon-home "></span></button>
                    </div>
                    <div class="dropdown">
                        <button class="dropbtn">
                            <a class="httpDirect" href="${pageContext.request.contextPath}/books?action=create"
                               style="color: white">
                                <span class="glyphicon glyphicon-pencil"></span> Create New Book</a></button>
                    </div>
                    <div class="dropdown">
                        <button class="dropbtn">
                            <a class="httpDirect" href="${pageContext.request.contextPath}/books?action=books"
                               style="color: white">
                                <span
                                        class="glyphicon glyphicon-log-out"></span> Back To Book List</a></button>
                    </div>
                </li>


            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li style="width: 300px;height: 55px;">
                    <div class="input-group" style="top: 50%;transform: translateY(-50%);">
                        <input type="text" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn">
                    <button class="btn btn-default" type="button" style="height: 100%;padding: 9px 12px;">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </span>
                    </div>
                </li>


            </ul>
        </div>
    </div>
</nav>

<div style="float: right">
    <c:if test="${requestScope['checkView'] == true}">
        <label><span>Quantity :</span> <input style="color: red; width: 50px" type="text"
                                              value="${quantityAllBook}"></label>
    </c:if>
    <c:if test="${requestScope['checkPublish'] == true}">
        <label>Quantity: <input style="color: red; width: 50px" type="text" value="${quantityPublish}"></label>
    </c:if>
    <c:if test="${requestScope['checkPosition'] == true}">
        <label>Quantity: <input style="color: red; width: 50px" type="text" value="${quantityPosition}"></label>
    </c:if>
</div>

<div class="container">
    <div class="row">
        <c:forEach var="book" items="${requestScope['books']}">
            <div class="col-sm-3">

                <div class="panel panel-primary"
                     onclick="location.href='${pageContext.request.contextPath}/books?action=view&id=${book.getId()}';"
                     style="cursor:pointer;">
                    <div class="panel-heading">${book.getName()}</div>
                    <div class="panel-body"><img
                            src="${book.getImage()}"
                            class="img-responsive" style="width:80%; margin: auto" alt="Image"></div>
                    <div class="panel-footer">
                        <button class="btn btn-success btn"><a style="color: white" class="httpDirect"
                                                               href="${pageContext.request.contextPath}/books?action=edit&id=${book.getId()}"><span
                                class="glyphicon glyphicon-edit"></span> Edit</a>
                        </button>
                        <button class="btn btn-success btn"><a style="color: white" class="httpDirect"
                                                               href="${pageContext.request.contextPath}/books?action=delete&id=${book.getId()}"><span
                                class="glyphicon glyphicon-trash "></span> Delete</a>
                        </button>

                    </div>

                </div>

            </div>
        </c:forEach>
    </div>
</div>
<br><br><br>

</body>
</html>
