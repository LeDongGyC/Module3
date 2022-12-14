<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 10/12/2022
  Time: 10:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .message {
        color: red;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <c:if test="${message}!= null">
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form action="/customer" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="Reset"/>
            </td>
            <td>
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create" />
</form>
</body>
</html>
