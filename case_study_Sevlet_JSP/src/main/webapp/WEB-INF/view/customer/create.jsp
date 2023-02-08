<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 25/12/2022
  Time: 9:37 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<p><span>Add New Customer Form</span></p>
<p><a href="/customer">Back To Customer List</a></p>
<p><span>${message}</span></p>
<form action="/customer" method="post">
    <select name="customerTypeId">
        <option value="0">Chọn lớp</option>
        <c:forEach items="${customerTypeList}" var="customerType">
            <option value="${customerType.getCustomerTypeId()}">${customerType.getCustomerTypeName()}</option>
        </c:forEach>
    </select><br>
    <input type="text" name="name" placeholder="Input name" value="${customer.getCustomerName()}"><br>
    <input type="text" name="birthday" placeholder="Input birthday" value="${customer.getCustomerBirthday()}"><br>
    <input type="radio" name="gender" value=1 value="${customer.getCustomerGender()}">Nam
    <input type="radio" name="gender" value=0 value="${customer.getCustomerGender()}">Nu <br>
    <input type="text" name="idCard" placeholder="Input card" value="${customer.getCustomerIdCard()}"><br>
    <input type="text" name="phone" placeholder="Input phone" value="${customer.getCustomerPhone()}"><br>
    <input type="text" name="email" placeholder="Input email" value="${customer.getCustomerEmail()}"><br>
    <input type="text" name="address" placeholder="Input address" value="${customer.getCustomerAddress()}"><br>
    <input type="submit" value="Save"><br>
    <input type="hidden" name="action" value="create">
</form>
</body>
</html>
