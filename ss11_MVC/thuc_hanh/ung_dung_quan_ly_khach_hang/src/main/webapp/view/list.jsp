<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 10/12/2022
  Time: 10:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/customer?action=create">Create new customer</a>
</p>
<table border="1" style="text-align: center">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td><a href="/customer?action=detail&id=${customer.id}">${customer.getName()}</a></td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td><a href="/customer?action=edit&id=${customer.id}">edit</a></td>
            <td><a href="/customer?action=delete&id=${customer.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
