<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 2/26/2024
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<c:import url="../layout/head.jsp"></c:import>
<head>
  <title>Title</title>
</head>
<body>
<form method="post">
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Name:</td>
        <td><input name="name" placeholder="Enter a name" required><br></td>
      </tr>
      <tr>
        <td>Price:</td>
        <td><input name="price" type="number" placeholder="Enter a number" required></td>
      </tr>
      <tr>
        <td>Quantity:</td>
        <td><input name="quantity" type="number" placeholder="Enter a number" required></td>
      </tr>
      <tr>
        <td><button class="btn btn-primary btn-lg" type="submit">Save</button></td>
        <td><a role="button" class="btn btn-primary btn-lg" href="/Product">Cancle</a></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
