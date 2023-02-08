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
    <div class="col-md-2">
        <c:import url="/WEB-INF/layout/sidebar.jsp"></c:import>
    </div>
    <div class="col-md-10">
        <p><a href="/employee?action=create">ADD NEW EMPLOYEE</a></p>
        <form action="/employee" method="get">
            <input type="text" name="nameSearch" placeholder="Enter the name" value="${nameSearch}">
            <input type="text" name="emailSearch" placeholder="Enter the email" value="${emailSearch}">
            <select name="positionIdSearch" id="">
                <option value="">Chon Position</option>
                <c:forEach items="${positionList}" var="position">
                    <option value="${position.positionId}">${position.positionName}</option>
                </c:forEach>
            </select>
            <button type="submit">Tìm kiếm</button>
            <input type="hidden" name="action" value="search">
        </form>
        <table class="table table-striped">
            <tr>
                <th>STT</th>
                <th>Id</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Id Card</th>
                <th>Salary</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Position</th>
                <th>Education Degree</th>
                <th>Division</th>
                <th>Username</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${employeeList}" var="employee" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${employee.employeeId}</td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.employeeBirthday}</td>
                    <td>${employee.employeeIdCard}</td>
                    <td>${employee.employeeSalary}</td>
                    <td>${employee.employeePhone}</td>
                    <td>${employee.employeeEmail}</td>
                    <td>${employee.employeeAddress}</td>
                    <td>${employee.position.positionName}</td>
                    <td>${employee.educationDegree.educationDegreeName}</td>
                    <td>${employee.division.divisionName}</td>
                    <td>${employee.user.userName}</td>
                    <td><a href="/employee?action=edit&&employee_id=${employee.employeeId}">edit</a></td>
                        <%--                    <td><a href="/employee?action=delete&&employee_id=${employee.employeeId}">delete</a></td>--%>
                    <td>
                        <button type="button" onclick="deleteInfo('${employee.employeeId}','${employee.employeeName}')"
                                class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="/employee?action=delete" method="post">
                    <div class="modal-body">
                        <input name="deleteId" id="deleteId">
                        <span>Bạn có muốn xoá </span><span style="color: #ff0000"
                                                           id="deleteName"></span><span> không?</span>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<c:import url="/WEB-INF/layout/footer.jsp"></c:import>
<script>
    function deleteInfo(id,name) {
        document.getElementById("deleteName").innerText=name;
        document.getElementById("deleteId").value=id;
    }
</script>
</body>
</html>
