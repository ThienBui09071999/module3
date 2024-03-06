<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 3/2/2024
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Country</title>
</head>
<body>
<center>
    <h1>Add Country</h1>
    <h2>
<%--        <a href="users?action=edit&id=?">Edit User</a>--%>
    <a href="users?action=edit&id=<%= request.getParameter("id") %>">Edit User</a>

    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Country</h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.getId()}' />"/>
            </c:if>
            <tr>
                <th>Country Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>