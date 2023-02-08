<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 04/01/2023
  Time: 9:00 SA
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
        <p><a href="/user?action=create">Add New User</a></p>
        <table class="table table-striped">
            <tr>
                <th>STT</th>
                <th>Username</th>
                <th>Password</th>
            </tr>
            <c:forEach items="${userList}" var="user" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${user.userName}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<c:import url="/WEB-INF/layout/footer.jsp"></c:import>
</body>
</html>
