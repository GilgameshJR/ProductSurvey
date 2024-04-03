<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 25/04/2021
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Response</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>

<h1>Response by <c:out value="${response.author.username}"></c:out> to questionnaire of <c:out
        value="${response.questionnaire.date}"></c:out> about <c:out
        value="${response.questionnaire.product.name}"></c:out></h1>
<h3><c:out value="${response.points}"></c:out> points scored</h3>
<h3>Personal answers:</h3>
<c:choose>
    <c:when test="${response.userAge!=null || response.userSex!=null || response.userExperience!=null}">
        <c:if test="${response.userAge!=null}">
            <p>Age: <c:out value="${response.userAge}"></c:out></p>
        </c:if>
        <c:if test="${response.userSex!=null}">
            <p>Sex: <c:out value="${response.userSex.label}"></c:out></p>
        </c:if>
        <c:if test="${response.userExperience!=null}">
<p>Experience: <c:out value="${response.userExperience.label}"></c:out></p>
</c:if>
    </c:when>
    <c:otherwise>
        <p>No personal answer</p>
    </c:otherwise>
</c:choose>
<h3>Marketing answers:</h3>
<c:forEach var="answer" items="${response.answers}">
    <p>
        Question: <c:out value="${answer.question.question}"></c:out>
        <br>
        Answer: <c:out value="${answer.answer}"></c:out>
    </p>
</c:forEach>
</body>
</html>
