<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/8/2022
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Publish Management</h1>
    <h2>
        <a href="publishes?action=publish">List All Publish</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Publish
                </h2>
            </caption>
            <c:if test="${publish != null}">
                <input type="hidden" name="id" value="<c:out value='${publish.id}' />"/>
            </c:if>
            <tr>
                <th> Name:</th>
                <td>
                    <label>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${publish.name}' />"
                        />
                    </label>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <label>
                        <input type="text" name="address" size="45"
                               value="<c:out value='${publish.address}' />"
                        />
                    </label>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <label>
                        <input type="text" name="email" size="15"
                               value="<c:out value='${publish.email}' />"
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
