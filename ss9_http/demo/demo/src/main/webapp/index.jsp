<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
<%--    <style type="text/css">--%>
<%--        .login {--%>
<%--            height:180px; width:230px;--%>
<%--            margin:0;--%>
<%--            padding:10px;--%>
<%--            border:1px #CCC solid;--%>
<%--        }--%>
<%--        .login input {--%>
<%--            padding:5px; margin:5px--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--&lt;%&ndash;<a href="hello-servlet">Hello Servlet</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="index">ServerTimeServlet</a>&ndash;%&gt;--%>
<%--<form action="/login" method="post">--%>
<%--    <div class="login">--%>
<%--        <h2>Login</h2>--%>
<%--        <input type="text" name="username" size="30" placeholder="username" />--%>
<%--        <input type="password" name="password" size="30" placeholder="password" />--%>
<%--        <input type="submit" value="Sign in"/>--%>
<%--    </div>--%>
<%--</form>--%>
<form action="/display-discount" method="post">
    <table>
        <tr>
            <td>
                <label for="productDescription">Product Description</label>
            </td>
            <td>
                <input type="text" name="productDescription" id="productDescription" placeholder="Product Description">
            </td>
        </tr>
        <tr>
            <td><label for="listPrice">List Price</label></td>
            <td><input type="number" name="listPrice" id="listPrice" placeholder="List Price"></td>
        </tr>
        <tr>
            <td><label for="discountPercent">Discount Percent</label></td>
            <td><input type="number" name="discountPercent" id="discountPercent" placeholder="Discount Percent"></td>
        </tr>
    </table>
    <button type="submit">Calculate</button>
    <button type="reset">Reset</button>
</form>
</body>
</html>