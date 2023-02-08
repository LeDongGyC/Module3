<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 09/01/2023
  Time: 4:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .abc{
            text-decoration: none;
            padding: 3.8px;
            border: 1px black solid;
            background-color: #e5e5e5;
        }
    </style>
</head>
<body>
<p><a href="/phongtro">Quay về danh sách phòng trọ</a></p>
<p><span>${mess}</span></p>
<form action="/phongtro" method="post">
    <table border="1">
        <tr>
            <td>Tên người thuê trọ</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Số điện thoại</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>Ngày bắt đầu thuê</td>
            <td><input type="date" name="ngayThue"></td>
        </tr>
        <tr>
            <td>Hình thức thuê</td>
            <td>
                <select name="idType">
                    <c:forEach items="${hinhThucList}" var="hinhthuc">
                        <option value="${hinhthuc.idType}">${hinhthuc.nameType}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Ghi chu</td>
            <td><input type="textarea" maxlength="200" name="ghiChu"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <a href="/phongtro" class="abc">Hủy</a>
                <input type="submit" value="Save">
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
