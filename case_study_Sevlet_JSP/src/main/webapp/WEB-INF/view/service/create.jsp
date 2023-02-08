<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 26/12/2022
  Time: 8:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/service">Back To Service List</a></p>
<p><span>Add New Service Form</span></p>
<p><span>${message}</span></p>
<form action="/service" method="post">
    <table border="1">
        <tr>
            <td>Service Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Service Area</td>
            <td><input type="text" name="area"></td>
        </tr>
        <tr>
            <td>Service Cost</td>
            <td><input type="text" name="cost"></td>
        </tr>
        <tr>
            <td>Service Max People</td>
            <td><input type="text" name="maxPeople"></td>
        </tr>
        <tr>
            <td>Select Rent Type</td>
            <td>
                <select name="rentTypeId" id="">
                    <c:forEach items="${rentTypeList}" var="rentType">
                        <option value="${rentType.getRentTypeId()}">${rentType.getRentTypeName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Select Service Type</td>
            <td>
                <select name="serviceTypeId" id="">
                    <c:forEach items="${serviceTypeList}" var="serviceType">
                        <option value="${serviceType.getServiceTypeId()}">${serviceType.getServiceTypeName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Standard Room</td>
            <td><input type="text" name="standardRoom"></td>
        </tr>
        <tr>
            <td>Description Other Convenience</td>
            <td><input type="text" name="descriptionOtherConvenience"></td>
        </tr>
        <tr>
            <td>Pool Area</td>
            <td><input type="text" name="poolArea"></td>
        </tr>
        <tr>
            <td>Number Of Floors</td>
            <td><input type="text" name="numberOfFloors"></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Save</button></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
