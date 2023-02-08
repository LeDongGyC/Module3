<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 02/01/2023
  Time: 6:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/employee">Back To List</a></p>
<p><span>${mess}</span></p>
<form action="/employee" method="post">
    <table border="1">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" name="birthday"></td>
        </tr>
        <tr>
            <td>Id Card</td>
            <td><input type="text" name="idCard"></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input type="text" name="salary"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Position</td>
            <td>
                <select name="positionId" id="">
                    <c:forEach items="${positionList}" var="position">
                        <option value="${position.positionId}">${position.positionName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Education Degree</td>
            <td>
                <select name="educationDegreeId" id="">
                    <c:forEach items="${educationDegreeList}" var="education">
                        <option value="${education.educationDegree}">${education.educationDegreeName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Division</td>
            <td>
                <select name="divisionId" id="">
                    <c:forEach items="${divisionList}" var="division">
                        <option value="${division.divisionId}">${division.divisionName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>User</td>
            <td>
                <select name="username" id="">
                    <c:forEach items="${userList}" var="user">
                        <option value="${user.userName}">${user.password}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Save</button>
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
