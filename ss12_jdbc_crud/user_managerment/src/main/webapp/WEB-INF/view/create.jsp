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
<p><a href="/users">BACK TO LIST USER</a></p>
<p>${message}</p>
<form action="/users" method="post">
    <table border="1">
        <tr>
            <td>NAME</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>EMAIL</td>
            <td><input type="text" name="email"></td>
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
