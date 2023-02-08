<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 25/12/2022
  Time: 9:34 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Customer</h1>
<p><a href="/customer">Back To List</a></p>
<form action="/customer" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><c:out value="${customer.getCustomerId()}"></c:out></td>
        </tr>
        <tr>
            <td>Type</td>
            <td>
                <select name="customerTypeId">
                    <option value="">${customer.customerType.customerTypeName}</option>
                    <c:forEach items="${customerTypeList}" var="customerType">
                        <c:if test="${customerType.getCustomerTypeId()!=customer.customerType.customerTypeId}">
                            <option value="${customerType.getCustomerTypeId()}">${customerType.getCustomerTypeName()}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${customer.getCustomerName()}"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="text" name="birthday" value="${customer.getCustomerBirthday()}"></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <input type="radio" name="gender" value=1 checked="checked">Nam
                <input type="radio" name="gender" value=0 ${checked}}>Nu
            </td>
        </tr>
        <tr>
            <td>Id Card</td>
            <td><input type="text" name="idCard" value="${customer.getCustomerIdCard()}"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="${customer.getCustomerPhone()}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${customer.getCustomerEmail()}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${customer.getCustomerAddress()}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="customer_id" value="${customer.getCustomerId()}">
</form>
</body>
</html>
