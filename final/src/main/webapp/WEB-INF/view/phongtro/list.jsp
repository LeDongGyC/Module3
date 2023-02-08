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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        .sidebar {
            overflow-y: scroll;
        }
    </style>
</head>
<body class="container-fluid">
<c:import url="/layout/navbar.jsp"></c:import>
<div class="row" style="height: 80%;">
    <div class="col-md-3 sidebar">
        <c:import url="/layout/sidebar.jsp"></c:import>
    </div>
    <div class="col-md-9">
        <h1>Danh sách phòng trọ</h1>
        <p><a href="/phongtro?action=create">Thêm mới phòng trọ</a></p>
        <form action="/phongtro" method="get">
            <input type="text" name="idSearch" placeholder="Enter Id" value="${idSearch}">
            <input type="text" name="nameSearch" placeholder="Enter name" value="${nameSearch}">
            <input type="text" name="phoneSearch" placeholder="Enter Phone" value="${phoneSearch}">
            <input type="submit" value="Search">
            <input type="hidden" name="action" value="search">
        </form>
        <p><span>${mess}</span></p>
        <table class="table table-striped">
            <tr>
                <th>STT</th>
                <th>Id</th>
                <th>Tên người thuê trọ</th>
                <th>Số điện thoại</th>
                <th>Ngày bắt đầu thuê</th>
                <th>Hình thức thanh toán</th>
                <th>Ghi chú</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${phongTroList}" var="phongtro" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>PT-00${phongtro.id}</td>
                    <td>${phongtro.name}</td>
                    <td>${phongtro.phone}</td>
                    <td>${phongtro.ngayThue}</td>
                    <td>${phongtro.hinhThuc.nameType}</td>
                    <td>${phongtro.ghiChu}</td>
                    <td>
                        <button type="button" onclick="deleteInfo('${phongtro.id}','${phongtro.name}')"
                                class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="/phongtro?action=delete" method="post">
                        <div class="modal-body">
                            <span>Bạn có muốn xoá thông tin thuê phòng trọ </span><input name="deleteId" id="deleteId"></span><span> không?</span>
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
</div>
<c:import url="/layout/footer.jsp"></c:import>
<script>
    function deleteInfo(id, name) {
        // document.getElementById("deleteName").innerText = name;
        document.getElementById("deleteId").value = id;
    }
</script>
</body>
</html>
