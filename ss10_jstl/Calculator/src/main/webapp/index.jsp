<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First Operand: </td>
                <td><input type="number" name="op1"></td>
            </tr>
            <tr>
                <td>Operator: </td>
                <td><select name="operation">
                    <option value="add">Addition</option>
                    <option value="subtract">Subtraction</option>
                    <option value="multiply">Multiplication</option>
                    <option value="divide">Division</option>
                </select></td>
            </tr>
            <tr>
                <td>Second operand: </td>
                <td><input type="number" name="op2"></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Submit</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>