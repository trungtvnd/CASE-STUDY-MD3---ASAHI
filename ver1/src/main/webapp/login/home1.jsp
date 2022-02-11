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
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="home1.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>

<div class="jumbotron">
    <div class="container text-center">
        <h1>ASAHI LIBRARY</h1>
        <img class="logo" src="library.png" alt="" >
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
                        <button class="dropbtn">Home</button>
                    </div>
                </li>
                <li>
                    <div class="dropdown">
                        <button class="dropbtn"><a href="${pageContext.request.contextPath}/books" style="color: white">Books</a></button>
                    </div>
                </li>
                <%--                <li><a href="/books?action=joinType">KIND OF BOOK</a></li>--%>
                <li>
                    <div class="dropdown">
                        <button class="dropbtn">Kind of book</button>
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
                        <button class="dropbtn">Positions</button>
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
                        <button class="dropbtn">Authors</button>
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

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Political & Law</div>
                <div class="panel-body"><img
                        src="http://1.bp.blogspot.com/-RPdEvwiXsso/T8Ncc2PWQ9I/AAAAAAAAAE4/7n9szTDA9hQ/s1600/law.jpg"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Science</div>
                <div class="panel-body"><img src="https://cdn1.byjus.com/wp-content/uploads/2020/09/Science.png"
                                             class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Economic</div>
                <div class="panel-body"><img
                        src="https://cdn.vietnambiz.vn/2019/8/30/001372acd7d3136c30eb34-1567136819514101698650-15671369070471788017558.png"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
            </div>
        </div>
    </div>
</div>
<br>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Literature & Art</div>
                <div class="panel-body"><img
                        src="https://continuingstudies.uvic.ca/upload/Arts/News/ARTS-How-arts-benefits-us-all_original.jpg"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Cultural & Historical</div>
                <div class="panel-body"><img
                        src="https://www.re-thinkingthefuture.com/wp-content/uploads/2020/01/A471-RICH-CULTURAL-HISTORY-OF-DELHI-IMAGE-2-1024x699.jpg"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Curriculum</div>
                <div class="panel-body"><img
                        src="https://previews.123rf.com/images/dizanna/dizanna1612/dizanna161200573/68077083-curriculum-word-cloud-concetto-di-business-dell-educazione.jpg"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Story & Novel</div>
                <div class="panel-body"><img src="https://mastersreview.com/files/2016/05/story-today-2-1-768x414.jpg"
                                             class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Mentality, Spirituality & Religion</div>
                <div class="panel-body"><img src="http://nghiencuuquocte.org/wp-content/uploads/2020/03/religions.jpg"
                                             class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Children</div>
                <div class="panel-body"><img
                        src="https://img.freepik.com/free-vector/children-playing-park_29937-3636.jpg?w=996"
                        class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
            </div>
        </div>
    </div>
</div>
<br><br>

<footer class="container-fluid text-center">
    <p>Online Store Copyright</p>
    <form class="form-inline">Get deals:
        <input type="email" class="form-control" size="50" placeholder="Email Address">
        <button type="button" class="btn btn-danger">Sign Up</button>
    </form>
</footer>
</body>
</html>
