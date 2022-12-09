<%--
  Created by IntelliJ IDEA.
  User: fpt
  Date: 09/12/2022
  Time: 1:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="post">
    <fieldset>
        <legend>
            Calculator
        </legend>
        <table>
            <tr>
                <td>First Operand:</td>
                <td><input type="text" name="first" value="${first}"></td>
            </tr>
            <tr>
                <td>Second Operand:</td>
                <td><input type="text" name="second" value="${second}"></td>
            </tr>
            <tr>
                <td>Operator</td>
                <td>
                    <select name="ope">
                        <option ${add}>+</option>
                        <option ${sub}>-</option>
                        <option ${multi}>*</option>
                        <option ${divv}>/</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="text" value="${result}"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
