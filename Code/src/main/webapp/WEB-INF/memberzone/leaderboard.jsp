<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 23/04/2021
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Leaderboard</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
<h1>Leaderboard</h1>
<c:choose>
    <c:when test="${responses!=null && responses.size()>0}">
<c:forEach var="response" items="${responses}">
    <p><c:out value="${response.points}"></c:out> points, user: <c:out value="${response.author.username}"></c:out>, time: <c:out value="${response.timestamp}"></c:out></p>
</c:forEach>
    </c:when>
    <c:otherwise>No one has submitted a response to today questionnaire yet. <a href="questionnaire/part1">Be the first!</a></c:otherwise>
</c:choose>
</body>
</html>
