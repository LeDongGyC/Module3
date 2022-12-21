<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 19/12/2022
  Time: 8:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>LIST USER</h1>
<form action="/users" method="post">
    <label for="">Name</label>
    <input type="text" name="countrySearch">
    <input type="submit" value="Search">
    <input type="hidden" name="action" value="findCountry">
</form>
<h1><a href="/users?action=create">ADD NEW</a></h1>
<table border="1" style="text-align: center">
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>NAME</td>
        <td>EMAIL</td>
        <td>COUNTRY</td>
        <td>EDIT</td>
        <td>DELETE</td>
    </tr>
    <c:forEach items="${userList}" varStatus="status" var="user">
        <tr>
            <td>${status.count}</td>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="/users?action=edit&&id=${user.id}">edit</a></td>
            <td><a href="/users?action=delete&&id=${user.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
