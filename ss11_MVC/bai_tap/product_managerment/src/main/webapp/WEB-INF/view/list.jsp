<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 14/12/2022
  Time: 8:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        a{
            text-decoration: none;
        }
    </style>
    <title>Title</title>
</head>
<body>
<h1>List Product</h1>
<form action="">
    <label>Search By Name:</label>
    <input type="text" name="nameSearch">
    <input type="submit" value="Search">
    <input type="hidden" name="action" value="findName">
</form>
<p><a href="/products?action=create">Add New Product</a></p>
<table border="1" style="text-align: center">
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>QUANTITY</th>
        <th>COUNTRY</th>
        <th>DETAIL</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${productList}" var="product" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.country}</td>
            <td><a href="/products?action=detail&&id=${product.id}">DETAIL</a></td>
            <td><a href="/products?action=edit&&id=${product.id}">EDIT</a></td>
            <td><a href="/products?action=delete&&id=${product.id}">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
