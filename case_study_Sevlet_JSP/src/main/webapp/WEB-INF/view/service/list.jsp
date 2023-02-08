<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 26/12/2022
  Time: 4:06 CH
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
<c:import url="/WEB-INF/layout/header.jsp"></c:import>
<c:import url="/WEB-INF/layout/navbar.jsp"></c:import>
<div class="row">
    <div class="col-md-3">
        <c:import url="/WEB-INF/layout/sidebar.jsp"></c:import>
    </div>
    <div class="col-md-9">
        <h1 style="text-align: center">List Service</h1>
        <p><a href="/service?action=create">Add New Service Form</a></p>
        <table class="table table-striped">
            <tr>
                <th>STT</th>
                <th>Id</th>
                <th>Name</th>
                <th>Area</th>
                <th>Cost</th>
                <th>Max People</th>
                <th>Rent Type</th>
                <th>Service Type</th>
                <th>Standard Room</th>
                <th>Description Other Convenience</th>
                <th>Pool Area</th>
                <th>Number Of Floors</th>
            </tr>
            <c:forEach items="${serviceList}" var="service" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${service.getServiceId()}</td>
                    <td>${service.getServiceName()}</td>
                    <td>${service.getServiceArea()}</td>
                    <td>${service.getServiceCost()}</td>
                    <td>${service.getServiceMaxPeople()}</td>
                    <td>${service.getRentType().getRentTypeName()}</td>
                    <td>${service.getServiceType().getServiceTypeName()}</td>
                    <td>${service.getStandardRoom()}</td>
                    <td>${service.getDescriptionOtherConvenience()}</td>
                    <td>${service.getPoolArea()}</td>
                    <td>${service.getNumberOfFloors()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<c:import url="/WEB-INF/layout/footer.jsp"></c:import>
</body>
</html>
