<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 03/01/2023
  Time: 7:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<c:import url="/WEB-INF/layout/header.jsp"></c:import>
<c:import url="/WEB-INF/layout/navbar.jsp"></c:import>
<div class="row">
    <div class="col-md-3">
        <c:import url="/WEB-INF/layout/sidebar.jsp"></c:import>
    </div>
    <div class="col-md-9">
        <p><a href="/contract?action=create">Add New Contract</a></p>
        <table class="table table-striped">
            <tr>
                <th>STT</th>
                <th>Id</th>
                <th>Start</th>
                <th>End</th>
                <th>Deposit</th>
                <th>Total Money</th>
                <th>Employee</th>
                <th>Customer</th>
                <th>Service</th>
            </tr>
            <c:forEach items="${contractList}" var="contract" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${contract.contractId}</td>
                    <td>${contract.contractStartDate}</td>
                    <td>${contract.contractEndDate}</td>
                    <td>${contract.contractDeposit}</td>
                    <td>${contract.contractTotalMoney}</td>
                    <td>${contract.employee.employeeName}</td>
                    <td>${contract.customer.customerName}</td>
                    <td>${contract.service.serviceName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
