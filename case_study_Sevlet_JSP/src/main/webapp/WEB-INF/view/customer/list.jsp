<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 24/12/2022
  Time: 6:28 CH
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
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
    <title>Title</title>
</head>
<body>
<c:import url="/WEB-INF/layout/header.jsp"></c:import>
<c:import url="/WEB-INF/layout/navbar.jsp"></c:import>
<div class="row">
    <div class="col-md-3">
        <c:import url="/WEB-INF/layout/sidebar.jsp"></c:import>
    </div>
    <div class="col-md-8">
        <h1>LIST CUSTOMER</h1>
        <p><a href="/customer?action=create">ADD NEW CUSTOMER</a></p>
        <p><span>${mess}</span></p>
        <table id="tableStudent" class="table table-striped">
            <thead>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>TYPE</th>
                <th>NAME</th>
                <th>BIRTHDAY</th>
                <th>GENDER</th>
                <th>ID CARD</th>
                <th>PHONE</th>
                <th>EMAIL</th>
                <th>ADDRESS</th>
                <th>EDIT</th>
                <th>DELETE</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customerList}" var="customer" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${customer.getCustomerId()}</td>
                    <td>${customer.getCustomerType().getCustomerTypeName()}</td>
                    <td>${customer.getCustomerName()}</td>
                    <td>${customer.getCustomerBirthday()}</td>
                    <c:if test="${customer.getCustomerGender()==1}">
                        <td>Nam</td>
                    </c:if>
                    <c:if test="${customer.getCustomerGender()==0}">
                        <td>Nữ</td>
                    </c:if>
                    <td>${customer.getCustomerIdCard()}</td>
                    <td>${customer.getCustomerPhone()}</td>
                    <td>${customer.getCustomerEmail()}</td>
                    <td>${customer.getCustomerAddress()}</td>
                    <td><a href="/customer?action=edit&&customer_id=${customer.getCustomerId()}">edit</a></td>
                        <%--                    <td><a href="/customer?action=delete&&customer_id=${customer.getCustomerId()}">delete</a></td>--%>
                    <td>
                        <button type="button" onclick="deleteInfo('${customer.customerId}','${customer.customerName}')"
                                class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

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
            <form action="/customer?action=delete" method="post">
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
<c:import url="/WEB-INF/layout/footer.jsp"></c:import>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    function deleteInfo(id, name) {
        document.getElementById("deleteName").innerText = name;
        document.getElementById("deleteId").value = id;
    }
</script>
<script>
    $(document).ready(function() {
        $('#tableStudent').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        } );
    } );
</script>
</body>
</html>
