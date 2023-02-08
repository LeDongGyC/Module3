<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 03/01/2023
  Time: 9:36 CH
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
    <div class="col-md-4">
        <c:import url="/WEB-INF/layout/sidebar.jsp"></c:import>
    </div>
    <div class="col-md-8">
        <p><a href="/customerType?action=create">Add New Customer Type</a></p>
        <p><span>${mess}</span></p>
        <table class="table table-striped">
            <tr>
                <th>STT</th>
                <th>Id</th>
                <th>Type Name</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${customerTypeList}" var="customerType" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${customerType.customerTypeId}</td>
                    <td>${customerType.customerTypeName}</td>
                    <td>
                        <button type="button" onclick="deleteInfo('${customerType.customerTypeId}','${customerType.customerTypeName}')"
                                class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/customerType?action=delete" method="post">
                <div class="modal-body">
                    <input name="deleteId" id="deleteId">
                    <span>Bạn có muốn xoá </span><span style="color: #ff0000" id="deleteName"></span><span> không?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<c:import url="/WEB-INF/layout/footer.jsp"></c:import>
</body>
<script>
    function deleteInfo(id, name) {
        document.getElementById("deleteName").innerText = name;
        document.getElementById("deleteId").value = id;
    }
</script>
</html>
