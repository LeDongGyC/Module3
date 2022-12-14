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
<h1>DETAIL THE PRODUCT</h1>
<table border="1" style="text-align: center">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>QUANTITY</th>
        <th>COUNTRY</th>
    </tr>
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.quantity}</td>
        <td>${product.country}</td>
    </tr>
</table>
</body>
</html>
