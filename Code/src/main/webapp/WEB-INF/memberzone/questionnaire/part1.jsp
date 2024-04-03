<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 23/04/2021
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Part 1</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
<h1>Questionnaire about <c:out value="${questionnaire.product.name}"></c:out></h1>
<h3>First part</h3>
<form action="part1submit" method="get" autocomplete="off">
    <div>
        <c:choose>
            <c:when test="${previousanswers==null}">
                <c:forEach var="question" items="${questionnaire.questions}">
                    <p><c:out value="${question.question}"></c:out></p>
                    <input type="text" name="${question.id}" required/>
                </c:forEach>
            </c:when>
        <c:otherwise>
            <c:forEach var="answer" items="${previousanswers}">
                <p><c:out value="${answer.question.question}"></c:out></p>
                <input type="text" name="${answer.question.id}" value="${answer.answer}" required/>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </div>
    <br>
    <input type="submit" value="Next">
</form>
</body>
</html>
