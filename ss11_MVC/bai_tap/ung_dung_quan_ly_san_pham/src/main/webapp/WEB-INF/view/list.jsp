<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 10/12/2022
  Time: 3:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>LIST PRODUCT</h1>
<%--<form action=""></form>--%>
<p><a href="/products?action=create">Create New Product</a></p>
<table border="1">
    <tr>
        <th>ID:</th>
        <th>Name:</th>
        <th>Price:</th>
        <th>Quantity:</th>
        <th>Country:</th>
        <th>Edit:</th>
        <th>Delete:</th>
    </tr>
    <jsp:useBean id="product" scope="request" type="java.util.List"/>
    <c:forEach items="${product}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>
                <a href="${pageContext.request.contextPath}/products?action=detail&&id=${product.id}">${product.name}</a>
            </td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.country}</td>
            <td><a href="${pageContext.request.contextPath}/products?action=edit&&id=${product.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/products?action=delete&&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
