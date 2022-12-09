<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 05/12/2022
  Time: 8:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      input{
        margin-bottom: 10px;
      }
    </style>
  </head>
  <body>
  <form action="/product" method="post">
    <label>Product Description</label>
    <br>
    <input type="text" name="product" placeholder="Enter the Product Description" value="${product}">
    <br>
    <label>List Price</label>
    <br>
    <input type="text" name="price" placeholder="Enter the List Price" value="${price}">
    <br>
    <label for="">Discount Percent</label>
    <br>
    <input type="text" name="discount" placeholder="Enter the Discount Percent" value="${discount}">
    <br>
    <input type="submit" value="Submit">
  </form>
  <b><span>Discount Amount: </span>${discountAmount}</b>
  <br>
  <b><span>Discount Price: </span>${discountPrice}</b>
  </body>
</html>
