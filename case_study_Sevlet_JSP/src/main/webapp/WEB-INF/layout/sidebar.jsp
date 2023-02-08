    <%--
      Created by IntelliJ IDEA.
      User: fpt
      Date: 23/12/2022
      Time: 4:30 CH
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
        <style>
        .sidebar{
        height: 100%;
        /*width: 25%;*/
        background-color: aqua;
        }
        .sidebar ul {
        width: 100%;
        }
        .sidebar ul li {
        position: relative;
        width: 100%;
        }

        .list__menu{
        /*margin-left: 30px;*/
        margin-bottom: 10px;

        }
        .list__menu li{
        margin-bottom: 10px;
        }
        .list__menu li a:hover {
        border-bottom: 1px solid black ;
        color: black;
        }
        </style>
        </head>
        <body>
        <div class="row sidebar">
        <div class="col-md-4">
        <ul class="list-unstyled list__menu">
        <li><a href="/customerType">Customer Type</a></li>
        <li><a href="/rentType">Rent Type</a></li>
        <li><a href="/serviceType">Service Type</a></li>
        <li><a href="/user">User</a></li>
        </ul>
        </div>
        </div>
        </body>
        </html>
