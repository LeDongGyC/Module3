<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 19/12/2022
  Time: 8:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>UPDATE THE USER</h1>
<p><a href="/users">BACK TO LIST</a></p>
<form action="/users?action=edit" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>NAME</td>
            <td><input type="text" name="name" value="${user.name}"></td>
        </tr>
        <tr>
            <td>EMAIL</td>
            <td><input type="text" name="email" value="${user.email}"></td>
        </tr>
        <tr>
            <td>COUNTRY</td>
            <td><input type="text" name="country" value="${user.country}"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="reset" value="Reset">
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${user.id}">
</form>
</body>
</html>
