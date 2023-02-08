<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 03/01/2023
  Time: 7:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/contract">Back To List</a></p>
<p><span>${mess}</span></p>
<form action="/contract" method="post">
    <table>
        <tr>
            <td>Start Date</td>
            <td><input type="text" name="start"></td>
        </tr>
        <tr>
            <td>End Date</td>
            <td><input type="text" name="end"></td>
        </tr>
        <tr>
            <td>Deposit</td>
            <td><input type="text" name="deposit"></td>
        </tr>
        <tr>
            <td>Total Money</td>
            <td><input type="text" name="total"></td>
        </tr>
        <tr>
            <td>Employee</td>
            <td>
                <select name="employeeId" id="">
                    <c:forEach items="${employeeList}" var="employee">
                        <option value="${employee.employeeId}">${employee.employeeName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Customer</td>
            <td>
                <select name="customerId" id="">
                    <c:forEach items="${customerList}" var="customer">
                        <option value="${customer.customerId}">${customer.customerName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Service</td>
            <td>
                <select name="serviceId" id="">
                    <c:forEach items="${serviceList}" var="service">
                        <option value="${service.serviceId}">${service.serviceName}</option>
                    </c:forEach>
                </select>
            </td>
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
