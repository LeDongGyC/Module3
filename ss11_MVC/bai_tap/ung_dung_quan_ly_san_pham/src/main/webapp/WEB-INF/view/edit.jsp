<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 10/12/2022
  Time: 4:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update The Product</h1>
<p>
    <a href="${pageContext.request.contextPath}/products">Back to List</a>
</p>
<form action="${pageContext.request.contextPath}/products" method="post">
    <table border="1">
        <tr>
            <td>Id:</td>
            <td>${product.id}</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><label>
                <input type="text" name="name" value="${product.name}">
            </label></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><label>
                <input type="text" name="price" value="${product.price}">
            </label></td>
        </tr>
        <tr>
            <td>Quantity:</td>
            <td><label>
                <input type="text" name="quantity" value="${product.quantity}">
            </label></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><label>
                <input type="text" name="country" value="${product.country}">
            </label></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="reset" value="Reset">
                <input type="submit" value="Edit">
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="edit">
    <label>
        <input type="hidden" name="id" value="${product.id}">
    </label>
</form>
</body>
</html>
