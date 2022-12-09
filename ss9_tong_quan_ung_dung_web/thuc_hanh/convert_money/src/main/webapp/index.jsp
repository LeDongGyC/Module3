<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 05/12/2022
  Time: 8:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Currency Converter</h1>
<form action="/convert" method="post">
    <label for="">Rate</label>
    <br>
    <input type="text" name="rate" placeholder="Rate" value="22000">
    <br>
    <label for="">USD</label>
    <br>
    <input type="text" name="usd" placeholder="USD" value="0">
    <br>
    <button type="submit">Submit</button>
</form>
<input type="text" value="${vnd}">
<%--<b>${vnd}</b>--%>
</body>
</html>
