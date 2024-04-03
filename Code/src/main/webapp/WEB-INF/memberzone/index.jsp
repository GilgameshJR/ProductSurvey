<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 21/04/2021
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="currcontext" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Product of the day</title>
</head>
<body>
<c:set var="ishomepage" value="${true}" scope="request"></c:set>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
    <c:choose>
        <c:when test="${product!=null}">
    <section>
        <h1>Product of the day: <c:out value="${product.name}"></c:out></h1>
        <img style="max-width: 600px" src="data:image/png;base64,${product.picture}"/>
    </section>
    <section>
        <h3><a href="${currcontext}/memberzone/questionnaire/part1">Go to questionnaire</a></h3>
        <h3><a href="${currcontext}/memberzone/leaderboard">Go to leaderboard</a></h3>
    </section>
            <c:if test="${product.reviews!=null && product.reviews.size()>0}">
    <section>
        <h3>Lastest 5 reviews:</h3>
        <c:forEach var="review" items="${product.reviews}" end="4">
            <p>Date: <c:out value="${review.timestamp}"></c:out> Review: <c:out value="${review.review}"></c:out></p>
        </c:forEach>
        <h3><a href="${currcontext}/memberzone/reviews">Read all reviews</a></h3>
    </section>
            </c:if>
        </c:when>
        <c:otherwise>
            <h2>No questionnaire available today. Please come back later.</h2>
        </c:otherwise>
    </c:choose>
</body>
</html>
