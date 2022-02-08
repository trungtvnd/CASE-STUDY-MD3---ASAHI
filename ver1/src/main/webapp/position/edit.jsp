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
        <a href="positions?action=positions">List All Position</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit position
                </h2>
            </caption>
            <c:if test="${position != null}">
                <input type="hidden" name="id" value="<c:out value='${position.id}' />"/>
            </c:if>
            <tr>
                <th> Name:</th>
                <td>
                    <label>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${position.name}' />"
                        />
                    </label>
                </td>
            </tr>
            <tr>
                <th>Describe:</th>
                <td>
                    <label>
                        <input type="text" name="describe" size="45"
                               value="<c:out value='${position.describe}' />"
                        />
                    </label>
                </td>
            </tr>
            <tr>
                <th>Quantity Limit:</th>
                <td>
                    <label>
                        <input type="text" name="quantityLimit" size="15"
                               value="<c:out value='${position.quantityLimit}' />"
                        />
                    </label>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <label>
                        <input type="text" name="quantity" size="15"
                               value="<c:out value='${position.quantity}' />"
                        />
                    </label>
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
