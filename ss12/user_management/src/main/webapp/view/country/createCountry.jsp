<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 3/1/2024
  Time: 8:08 PM
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
        <a href="users?action=create">Add user</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Country</h2>
            </caption>
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
