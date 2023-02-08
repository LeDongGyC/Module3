<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 04/01/2023
  Time: 8:52 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/serviceType">Back To List</a></p>
<p><span>${mess}</span></p>
<form action="/serviceType" method="post">
    <table border="1">
        <tr>
            <td>Service Type Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
