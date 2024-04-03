<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 28/04/2021
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.db2.productsurvey.Error" %>
<c:set var="username" value="${sessionScope.user.username}" scope="request"/>

<html>
<head>
    <title>Error</title>
</head>
<body>
  <jsp:include page="WEB-INF/header.jsp"></jsp:include>
  <c:set var="errorenum" value="${Error.valueOf((param.code).toUpperCase())}"></c:set>
  <h1>Error!</h1>
  <h2><c:out value="${errorenum.getDescription()}"></c:out></h2>
</body>
</html>
