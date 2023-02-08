<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 23/12/2022
  Time: 4:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <title>Title</title>
    <style>
        .navbar{
    border: 1px solid black;
         }
        .row div ul li a{
            text-decoration: none;
        }
        .list-inline-item a{
            margin-right: 65px;
        }
        .list-inline-item:first-child{
            margin-left: 100px;
        }
        .input__search{
            border-radius:40px;
            text-align: center;
            margin-left: 0 auto;
        }
    </style>
</head>
<body>
    <div class="row navbar">
        <div class="col-md-9">
                <ul class="list-unstyled list-inline">
                        <li class="list-inline-item"><a href="/home">Home</a></li>
                        <li class="list-inline-item"><a href="/employee">Employee</a></li>
                        <li class="list-inline-item"><a href="/customer">Customer </a></li>
                        <li class="list-inline-item"><a href="/service">Service</a></li>
                        <li class="list-inline-item"><a href="/contract">Contract</a></li>
                </ul>
        </div>
        <div class="col-md-3">
                <input type="search" placeholder="Input to search" class="input__search">
        </div>
    </div>
</body>
</html>
