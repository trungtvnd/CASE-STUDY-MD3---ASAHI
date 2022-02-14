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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>View Detail Book</title>
    <style>
        body, html {
            font-family: "Times New Roman", serif;
        }

        image {
            width: 60px;
            height: 80px;
        }

        .displayBook {
            margin: 5px;
            float: left;
            padding: 100px;
        }

        .displayImage {
            margin-top: 100px;
            float: left;
            padding-left: 50px;
            padding-top: 100px;

        }
        .imageBook{
            width: 240px;
            height: 320px;
        }

        table {
            border-radius: 30%;
            border: cadetblue 5px solid;
            padding: 30px;
            width: 500px;
        }

        td {
            padding: 10px;
        }

        .headers-region {
            width: 100px;
        }
        .buttonBack{
            margin: 5px;
            float: left;
            padding: 10px;
        }


    </style>
</head>
<body>
<p class="buttonBack">
    <button class="btn btn-success btn"><a href="${pageContext.request.contextPath}/books?index=1"
                                           style="text-decoration: none; color: white"> <span
            class="glyphicon glyphicon-log-out"></span>Back to Book List</a></button>
</p>
<div>
    <div class="displayBook">
            <h3 style="color: #17a2b8">BOOK DETAIL</h3>
        <div>
            <table class="displayTable">

                <tr>
                    <td class="headers-region">Name:</td>
                    <td>${requestScope["book"].getName()}</td>
                </tr>
                <tr>
                    <td class="headers-region">Author:</td>
                    <td>${requestScope["book"].getAuthorID()}</td>
                </tr>
                <tr>
                    <td class="headers-region">Describe:</td>
                    <td>${requestScope["book"].getDescribe()}</td>
                </tr>
                <tr>
                    <td class="headers-region">Language:</td>
                    <td>${requestScope["book"].getLanguage()}</td>
                </tr>
                <tr>
                    <td class="headers-region">Status:</td>
                    <td>${requestScope["book"].getStatus()}</td>
                </tr>
                <tr>
                    <td class="headers-region">Type:</td>
                    <td>${requestScope["book"].getType()}</td>
                </tr>
                <tr>
                    <td class="headers-region"> Publish:</td>
                    <td>${requestScope["book"].getPublish()}</td>
                </tr>
                <tr>
                    <td class="headers-region">Position:</td>
                    <td><a href="${pageContext.request.contextPath}/books?action=joinPosition">${requestScope["book"].getPositionID()}</a></td>
                </tr>
                <tr>
                    <td class="headers-region">YearPublish:</td>
                    <td>${requestScope["book"].getYearPublish()}</td>
                </tr>
                <tr>
                    <td class="headers-region">Image:</td>
                    <td></td>
                </tr>

            </table>
        </div>
    </div>
    <div class="displayImage">
        <img class="imageBook" src="${requestScope["book"].getImage()}" alt="">
    </div>
</div>
</body>
</html>
