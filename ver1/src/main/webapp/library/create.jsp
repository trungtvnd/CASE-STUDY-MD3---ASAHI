<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/7/2022
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="books?index=1">List All Books</a>
    </h2>
</center>

<div align="center">

    <c:if test="${requestScope['check']<=10}">
        <h2 style="color: blue">Create Successfully</h2>
    </c:if>
    <c:if test="${requestScope['check']>10}">
        <h2 style="color: red">Position is Full, Please choose another Position</h2>
    </c:if>
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Book</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <label for="name"></label><input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Author:</th>
                <td>
                    <label>
                        <select name="author">
                            <c:forEach items="${authors}" var="author">
                                <option value="${author.getId()}">${author.getName()}</option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
                <td>
                    <button><a href="${pageContext.request.contextPath}/authors?action=create">Add New Author</a></button>
                </td>
            </tr>
            <tr>
                <th>Describe:</th>
                <td>
                    <label for="describe"></label><input type="text" name="describe" id="describe" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Language:</th>
                <td>
                    <label for="language"></label><input type="text" name="language" id="language" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Status:</th>
                <td>
                    <label><select name="status" id="status">
                        <option value="New">New</option>
                        <option value="Old">Old</option>
                    </select></label>
                </td>
            </tr>
            <tr>
                <th>Type:</th>
                <td>
                    <label><select name="type" id="type">
                        <option value="Political & Law">Political & Law</option>
                        <option value="Science">Science</option>
                        <option value="Economic">Economic</option>
                        <option value="Literature & Art">Literature & Art</option>
                        <option value="Cultural & Historical">Cultural & Historical</option>
                        <option value="Curriculum">Curriculum</option>
                        <option value="Story & Novel">Story & Novel</option>
                        <option value="Mentality, Spirituality & Religion">Mentality, Spirituality & Religion</option>
                        <option value="Children">Children</option>
                    </select></label>
                </td>
            </tr>
            <tr>
                <th>Publish:</th>
                <td>
                    <label>
                        <select name="publish">
                            <c:forEach items="${publishes}" var="publish">
                                <option value="${publish.getId()}">${publish.getName()}</option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
                <td>
                    <button><a href="/publishes?action=create">Add New Publish</a></button>
                </td>
            </tr>
            <tr>
                <th>Position:</th>
                <td>
                    <label>
                        <select name="position">
                            <c:forEach items="${positions}" var="position">
                                <option value="${position.getId()}">${position.getName()}</option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
                <td>
                    <button><a href="/positions?action=create">Add New Position</a></button>
                </td>
            </tr>
            <tr>
                <th>Year Publish:</th>
                <td>
                    <label for="yearPublish"></label><input type="text" name="yearPublish" id="yearPublish" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Image:</th>
                <td>
                    <label for="image"></label><input type="text" name="image" id="image" size="15"/>
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
