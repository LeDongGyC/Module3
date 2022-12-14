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
<p><a href="/products">BACK TO LIST</a></p>
<p style="color: red">${message}</p>
<form action="/products" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>NAME</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>PRICE</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>QUANTITY</td>
            <td><input type="text" name="quantity"></td>
        </tr>
        <tr>
            <td>COUNTRY</td>
            <td><input type="text" name="country"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="reset" value="RESET"></input>
                <input type="submit" value="CREATE"></input>
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
