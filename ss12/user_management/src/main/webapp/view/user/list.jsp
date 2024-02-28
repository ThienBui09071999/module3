<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 2/28/2024
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<div>
    <center  >
        <h1>User Management</h1>
        <h2>
            <a href="/users?action=create">Add New User</a>
            <br>
            <a href="/users?action=sortByName">Sort by name</a>
        </h2>
        <form action="/users" method="get">
            <label >Filter by Country:</label>
            <input type="text" name="action" value="find" hidden>
            <input type="text" name="countryName" value="${countryName}">
            <button type="submit">Search</button>
        </form>
    </center>
</div>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
