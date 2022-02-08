<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/8/2022
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Position Management</h1>
    <h2>
        <a href="positions?action=positions">List All Positions</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Position</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <label for="name"></label><input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Describe:</th>
                <td>
                    <label for="describe"></label><input type="text" name="describe" id="describe" size="15"/>
                </td>
            </tr>
            <th>Quantity Limit:</th>
            <td>
                <label for="quantityLimit"></label><input type="text" name="quantityLimit" id="quantityLimit" size="15"/>
            </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <label for="quantity"></label><input type="text" name="quantity" id="quantity" size="15"/>
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
