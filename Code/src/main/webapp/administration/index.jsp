<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 24/04/2021
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration</title>
</head>
<body>
<c:set var="ishomepage" value="${true}" scope="request"></c:set>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>

<h1>Administration panel</h1>
<h3><a href="newquestionnaire">Create questionnaire</a></h3>
<h3><a href="manageproducts">Manage products</a></h3>
<h3>View questionnaire and responses</h3>
<p>Select date</p>
<form action="getquestionnaire" method="get">
    <input type="date" required name="date">
    <input type="submit" value="View">
</form>
</body>
</html>
