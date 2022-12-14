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
    <title>Title</title>
</head>
<body>
<h1>EDIT THE PRODUCT</h1>
<p><a href="/products">BACK TO LIST PRODUCT</a></p>
<form action="/products?action=edit&&id=${product.id}" METHOD="post">
    <table border="1" style="text-align: center">
        <tr>
            <td>ID</td>
            <td>${product.id}</td>
        </tr>
        <tr>
            <td>NAME</td>
            <td><input type="text" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <td>PRICE</td>
            <td><input type="text" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <td>QUANTITY</td>
            <td><input type="text" name="quantity" value="${product.quantity}"></td>
        </tr>
        <tr>
            <td>COUNTRY</td>
            <td><input type="text" name="country" value="${product.country}"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="reset" value="RESET"></input>
                <input type="submit" value="UPDATE"></input>
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${product.id}">
</form>
</body>
</html>
