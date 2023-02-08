<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 04/01/2023
  Time: 9:02 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/user">Back To List</a></p>
<p><span>${mess}</span></p>
<form action="/user" method="post">
    <table border="1">
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
