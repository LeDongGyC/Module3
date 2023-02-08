<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 03/01/2023
  Time: 9:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/customerType">Back to List</a></p>
<p><span>${mess}</span></p>
<form action="/customerType" method="post">
    <table border="1">
        <tr>
            <td><label for="name">Type Name</label></td>
            <td><input type="text" name="name" id="name"><br></td>
        </tr>
        <tr>
            <td></td>
            <td><button value="Save" type="submit" >Save</button></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
