<%--
  Created by IntelliJ IDEA.
  User: NGO MAI
  Date: 10/02/2022
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="home1.css">
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
            box-shadow: 0px 0px 8px rgba(0,0,0,.3);
            margin: 94px 20px 20px 20px;
        }

        /* Styles the lightbox, removes it from sight and adds the fade-in transition */

        .lightbox-target {
            position: fixed;
            top: -100%;
            width: 100%;
            background: rgba(0,0,0,.7);
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
            left:0;
            right:0;
            bottom: 0;
            max-height: 0%;
            max-width: 0%;
            border: 3px solid white;
            box-shadow: 0px 0px 8px rgba(0,0,0,.3);
            box-sizing: border-box;
            -webkit-transition: .5s ease-in-out;
            -moz-transition: .5s ease-in-out;
            -o-transition: .5s ease-in-out;
            transition: .5s ease-in-out;

        }

        /* Styles the close link, adds the slide down transition */

        a.lightbox-close {
            display: block;
            width:50px;
            height:50px;
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
            top:10px;
            -webkit-transform:rotate(45deg);
            -moz-transform:rotate(45deg);
            -o-transform:rotate(45deg);
            transform:rotate(45deg);
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
            top:10px;
            -webkit-transform:rotate(-45deg);
            -moz-transform:rotate(-45deg);
            -o-transform:rotate(-45deg);
            transform:rotate(-45deg);
        }

        /* Uses the :target pseudo-class to perform the animations upon clicking the .lightbox-target anchor */

        .lightbox-target:target {
            opacity: 1;
            top: 0;
            bottom: 0;
            overflow:scroll;
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
        .panel-heading{

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
        .dropdown:hover .dropbtn {
            background-color: #3e8e41;
        }

        .img-responsive {
            width: 80px;
            height: 200px;
        }
        .panel-heading{

            text-align: center;
        }
        .jumbotron{
            background-image: url("/picture/sky2.jpg");
            background-repeat: no-repeat;
            background-position: center center;
            background-size: cover;
        }
        img {
            transform: scale(1);
            transition: all 0.5s;
        }
        img:hover {
            transform: scale(1.1);
        }
    </style>
</head>
<body>

<div class="jumbotron">
    <div class="container text-center">
        <h1  style=" font-family: 'Nothing You Could Do',cursive; color: white">ASAHI LIBRARY</h1>
        <img class="logo" src="/picture/library.png" alt="" >
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
                </li>
                <li>
                    <div class="dropdown">
                        <button class="dropbtn"><a href="${pageContext.request.contextPath}/books?index=1" style="color: white ;text-decoration: none;">Books <span class="glyphicon glyphicon-th-list "></span></a></button>
                    </div>
                </li>

                <li>
                    <div class="dropdown">
                        <button class="dropbtn">Pulish <span class="glyphicon glyphicon-chevron-down"></span></button>
                        <div class="dropdown-content">
                            <c:forEach items="${publishes}" var="publish">
                                <label>
                                    <a href="/books?action=sortByPublish&sortByPublish=${publish.getName()}&name=${account.name}">${publish.getName()}</a>
                                </label>

                            </c:forEach>
                        </div>
                    </div>
                </li>

                <li>
                    <div class="dropdown">
                        <button class="dropbtn">Positions <span class="glyphicon glyphicon-chevron-down"></span></button>
                        <div class="dropdown-content">
                            <c:forEach items="${positions}" var="position">
                                <label>
                                    <a href="${pageContext.request.contextPath}/books?action=sortByPosition&sortByPosition=${position.getName()}&name=${account.name}">${position.getName()}</a>
                                </label>
                            </c:forEach>
                        </div>
                    </div>
                </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/register?action=displayUser&username=${account.name}"><span class="glyphicon glyphicon-user"></span> ${account.name}</a></li>
                <li><a href="/login/login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel panel-primary" onclick="location.href='${pageContext.request.contextPath}/books?action=sortByType&type=Political&name=${account.name}';" style="cursor:pointer;">
                <div class="panel-heading">Political & Law </div>
                <div class="panel-body"><img
                        src="https://1.bp.blogspot.com/-RPdEvwiXsso/T8Ncc2PWQ9I/AAAAAAAAAE4/7n9szTDA9hQ/s1600/law.jpg"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">We have ${x} Political & Law books</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary" onclick="location.href='${pageContext.request.contextPath}/books?action=sortByType&type=Science&name=${account.name} ';" style="cursor:pointer;">
                <div class="panel-heading">Science</div>
                <div class="panel-body"><img src="https://cdn1.byjus.com/wp-content/uploads/2020/09/Science.png"
                                             class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">We have ${x} Science books</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary" onclick="location.href='${pageContext.request.contextPath}/books?action=sortByType&type=Economic&name=${account.name}';" style="cursor:pointer;">
                <div class="panel-heading">Economic</div>
                <div class="panel-body"><img
                        src="https://cdn.vietnambiz.vn/2019/8/30/001372acd7d3136c30eb34-1567136819514101698650-15671369070471788017558.png"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">We have ${x} Economic books</div>
            </div>
        </div>
    </div>
</div>
<br>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel panel-primary" onclick="location.href='${pageContext.request.contextPath}/books?action=sortByType&type=Literature&name=${account.name}';" style="cursor:pointer;">
                <div class="panel-heading">Literature & Art</div>
                <div class="panel-body"><img
                        src="https://continuingstudies.uvic.ca/upload/Arts/News/ARTS-How-arts-benefits-us-all_original.jpg"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">We have ${x} Literature & Art books</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary" onclick="location.href='${pageContext.request.contextPath}/books?action=sortByType&type=Cultural&name=${account.name}';" style="cursor:pointer;">
                <div class="panel-heading">Cultural & Historical</div>
                <div class="panel-body"><img
                        src="https://www.re-thinkingthefuture.com/wp-content/uploads/2020/01/A471-RICH-CULTURAL-HISTORY-OF-DELHI-IMAGE-2-1024x699.jpg"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">We have ${x} Cultural & Historical books</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary" onclick="location.href='${pageContext.request.contextPath}/books?action=sortByType&type=Curriculum&name=${account.name}';" style="cursor:pointer;">
                <div class="panel-heading">Curriculum</div>
                <div class="panel-body"><img
                        src="https://previews.123rf.com/images/dizanna/dizanna1612/dizanna161200573/68077083-curriculum-word-cloud-concetto-di-business-dell-educazione.jpg"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">We have ${x} Curriculum books</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary" onclick="location.href='${pageContext.request.contextPath}/books?action=sortByType&type=Story&name=${account.name}';" style="cursor:pointer;">
                <div class="panel-heading">Story & Novel</div>
                <div class="panel-body"><img src="https://mastersreview.com/files/2016/05/story-today-2-1-768x414.jpg"
                                             class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">We have ${x} Story & Novel books</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary" onclick="location.href='${pageContext.request.contextPath}/books?action=sortByType&type=Mentality&name=${account.name}';" style="cursor:pointer;">
                <div class="panel-heading">Mentality, Spirituality & Religion</div>
                <div class="panel-body"><img src="https://nghiencuuquocte.org/wp-content/uploads/2020/03/religions.jpg"
                                             class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">We have ${x} Mentality, Spirituality & Religion books</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary" onclick="location.href='${pageContext.request.contextPath}/books?action=sortByType&type=Children&name=${account.name}';" style="cursor:pointer;">
                <div class="panel-heading">Children</div>
                <div class="panel-body"><img
                        src="https://img.freepik.com/free-vector/children-playing-park_29937-3636.jpg?w=996"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">We have ${x} Children books</div>
            </div>
        </div>
    </div>
</div>
<br><br>

<footer class="container-fluid text-center">
    <p>ASAHI LIBRARY copyright</p>
    <p>Address: Lô 1 KĐT Mỹ Đình 2, Hà Nội</p>
    <p>Phone: 0123456789 </p>

</footer>
</body>
</html>
