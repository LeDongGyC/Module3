<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 10/12/2022
  Time: 4:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create New Product</h1>
<p>
    <a href="${pageContext.request.contextPath}/products">Back to List</a>
</p>
<form action="${pageContext.request.contextPath}/products" method="post">
    <table border="1">
        <tr>
            <td>ID:</td>
            <td><label>
                <input type="text" name="id">
            </label></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><label>
                <input type="text" name="name">
            </label></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><label>
                <input type="text" name="price">
            </label></td>
        </tr>
        <tr>
            <td>Quantity:</td>
            <td><label>
                <input type="text" name="quantity">
            </label></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><label>
                <input type="text" name="country">
            </label></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="reset" value="Reset">
                <input type="submit" value="Create">
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
