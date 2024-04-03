<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 25/04/2021
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="currcontext" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Questionnaire</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
<section>
    <h1>Questionnaire of <c:out value="${questionnaire.date}"></c:out>:</h1>
    <h2>Product: <c:out value="${questionnaire.product.name}"></c:out></h2>
    <img style="max-width: 600px" src="data:image/png;base64,${questionnaire.product.picture}"/>
</section>
<section>
    <h2>Questions:</h2>
    <ul>
        <c:forEach var="question" items="${questionnaire.questions}">
            <li><c:out value="${question.question}"></c:out></li>
        </c:forEach>
    </ul>
</section>
<c:choose>
    <c:when test="${future}">
        <h3><a href="deletequestionnaire?id=${questionnaire.id}">Delete questionnaire</a></h3>
    </c:when>
    <c:otherwise>
        <h3><a href="deletequestionnaire?id=${questionnaire.id}">Delete questionnaire and responses</a></h3>
    </c:otherwise>
</c:choose>
<c:if test="${!future}">
    <section>
        <h2>Submissions:</h2>
        <c:choose>
            <c:when test="${questionnaire.responses!=null && questionnaire.responses.size()>0}">
                <c:forEach var="response" items="${questionnaire.responses}">
                    <p><a href="getresponse?id=${response.id}">Author: <c:out
                            value="${response.author.username}"></c:out> Points:
                        <c:out value="${response.points}"></c:out> Timestamp: <c:out
                                value="${response.timestamp}"></c:out></a></p>
                </c:forEach>
            </c:when>
            <c:otherwise>
                No one has submitted a response yet.
            </c:otherwise>
        </c:choose>
</section>
<section>
<h2>Unsubmitting users:</h2>
    <p>Users who opened the questionnaire but didn't answer</p>
    <c:choose>
        <c:when test="${unsubmissions!=null && unsubmissions.size()>0}">
            <c:forEach var="unsubmission" items="${unsubmissions}">
                <p>User: <c:out value="${unsubmission.user.username}"></c:out> Timestamp: <c:out
                        value="${unsubmission.timestamp}"></c:out></p>
            </c:forEach>
        </c:when>
        <c:otherwise>No one has opened the questionnaire and hasn't submitted</c:otherwise>
    </c:choose>
</section>
</c:if>
</body>
</html>