<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="currcontext" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
    <form action="${currcontext}/login">
        <table>
            <tr>
                <td><label for="username">Username: </label></td>
                <td><input id="username" name="username" required></td>
            </tr>
            <tr>
                <td><label for="password">Password: </label></td>
                <td><input id="password" name="password" type="password" required><br></td>
            </tr>
        </table>
        <input type="submit" value="Login">

    </form>
</body>
</html>