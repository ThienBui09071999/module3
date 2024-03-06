<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 2/28/2024
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"
                           value="<c:out value='${user.getName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"
                           value="<c:out value='${user.getEmail()}' />"
                    />
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>Country:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="countryId" size="15"--%>
<%--                           value="<c:out value='${user.countryId}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <th>Country:</th>
                <td>
                    <select name="countryId" id="countryId">
                        <c:forEach var="country" items="${countryList}">
                            <c:if test="${user.getCountryId() == country.getId()}">
                                <option selected value="${country.id}">${country.getName()}</option>
                            </c:if>
                            <c:if test="${user.getCountryId() != country.getId()}">
                                <option value="${country.id}">${country.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    <form method="post">
                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.getId()}' />"/>
                        </c:if>
                        <!-- Các trường nhập liệu trong form -->

                        <!-- Nút button không liên quan đến form -->
                        <button type="button" onclick="redirectToCountryCreate()">New</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
<script>
    function redirectToCountryCreate() {
        // Chuyển hướng đến trang country?action=create
        window.location.href = 'country?action=createOffEdit&id=${user.id}';
    }
</script>
</html>
