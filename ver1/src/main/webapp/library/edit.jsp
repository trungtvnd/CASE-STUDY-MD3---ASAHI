<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/7/2022
  Time: 4:24 PM
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
    <h1>Books Management</h1>
    <h2>
        <a href="books?action=books">List All Books</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Book
                </h2>
            </caption>
            <c:if test="${book != null}">
                <input type="hidden" name="id" value="<c:out value='${book.id}' />"/>
            </c:if>
            <tr>
                <th> Name(old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="45"
                               value="<c:out value='${book.name}' />"
                        />
                    </label>
                </td>
                <th> Name(new) :</th>
                <td>
                    <label>
                        <input type="text" name="name" size="45"/>
                    </label>
                </td>
            </tr>
            <tr>
                <th>Author(old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="45"
                               value="<c:out value='${book.authorID}' />"
                        />
                    </label>
                </td>
                <th>Author(new):</th>
                <td>
                    <label>
                        <select name="authorID">
                            <c:forEach items="${authors}" var="author">
                                <option value="${author.getId()}">${author.getName()}</option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <th>Describe(old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="15"
                               value="<c:out value='${book.describe}' />"
                        />
                    </label>
                </td>
                <th>Describe(new):</th>
                <td>
                    <label>
                        <input type="text" name="describe" size="15"/>
                    </label>
                </td>
            </tr>
            <tr>
                <th>Language(old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="15"
                               value="<c:out value='${book.language}' />"
                        />
                    </label>
                </td>
                <th>Language(new):</th>
                <td>
                    <label>
                        <input type="text" name="language" size="15"/>
                    </label>
                </td>
            </tr>
            <tr>
                <th>Status(old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="15"
                               value="<c:out value='${book.status}' />"
                        />
                    </label>
                </td>
                <th>Status(new):</th>
                <td>
                    <label><select name="status" id="status">
                        <option value="New">New</option>
                        <option value="Old">Old</option>
                    </select></label>
                </td>
            </tr>
            <tr>
                <th>Type(old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="15"
                               value="<c:out value='${book.type}' />"
                        />
                    </label>
                </td>
                <th>Type(new):</th>
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
                <th>Publish(old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="15"
                               value="<c:out value='${book.publish}' />"
                        />
                    </label>
                </td>
                <th>Publish(new):</th>
                <td>
                    <label>
                        <select name="publish">
                            <c:forEach items="${publishes}" var="publish">
                                <option value="${publish.getId()}">${publish.getName()}</option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <th>Position (old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="15"
                               value="<c:out value='${book.positionID}' />"
                        />
                    </label>
                </td>
                <th>Position(new):</th>
                <td>
                    <label>
                        <select name="positionID">
                            <c:forEach items="${positions}" var="position">
                                <option value="${position.getId()}">${position.getName()}</option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <th>Year(old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="15"
                               value="<c:out value='${book.yearPublish}' />"
                        />
                    </label>
                </td>
                <th>Year(new):</th>
                <td>
                    <label>
                        <input type="text" name="yearPublish" size="15"/>
                    </label>
                </td>
            </tr>
            <tr>
                <th>Image(old):</th>
                <td>
                    <label>
                        <input type="text" name="" size="15"
                               value="<c:out value='${book.image}' />"
                        />
                    </label>
                </td>
                <th>Image(new):</th>
                <td>
                    <label>
                        <input type="text" name="image" size="15"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
