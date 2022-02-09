<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/8/2022
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Publish</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="publishes?action=publishes">List All Publish</a>
    </h2>
    <h2>
        <a href="/books?action=create">Back To Create Book</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New publish</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <label for="name"></label><input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <label for="address"></label><input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <label for="email"></label><input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
