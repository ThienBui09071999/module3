<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 2/26/2024
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<h1>Trang sản phẩm</h1>

<a role="button" class="btn btn-primary btn-lg" href="/Product?action=add">Thêm mới</a>

<%
    String mess = request.getParameter("mess");
    if (mess==null){
        mess ="";
    }
%>

<p><%=mess%></p>

<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getQuantity()}</td>
            <td><a role="button" class="btn btn-success btn-lg" href="Product?action=update&name=${product.getName()}">Cập nhật</a></td>
            <td><a role="button" class="btn btn-success btn-lg" href="Product?action=delete&name=${product.getName()}">Xoá</a></td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
