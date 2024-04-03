<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 25/04/2021
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Reviews</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
<h1>Reviews for <c:out value="${product.name}"></c:out></h1>
<c:choose>
<c:when test="${product.reviews!=null && product.reviews.size()>0}">
<c:forEach var="review" items="${product.reviews}">
  <p>Date: <c:out value="${review.timestamp}"></c:out> Review: <c:out value="${review.review}"></c:out></p>
</c:forEach>
</c:when>
  <c:otherwise>No review for this product</c:otherwise>
</c:choose>
</body>
</html>
