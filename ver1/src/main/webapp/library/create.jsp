<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/7/2022
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="books?action=books">List All Books</a>
    </h2>
</center>
<div align="center">
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
                    <label for="authorID"></label><input type="text" name="authorID" id="authorID" size="45"/>
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
                    <label for="status"></label><input type="text" name="status" id="status" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Type:</th>
                <td>
                    <label for="type"></label><input type="text" name="type" id="type" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Publish:</th>
                <td>
                    <label for="publish"></label><input type="text" name="publish" id="publish" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Position:</th>
                <td>
                    <label for="positionID"></label><input type="text" name="positionID" id="positionID" size="15"/>
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
