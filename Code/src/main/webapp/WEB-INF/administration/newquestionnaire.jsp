<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 24/04/2021
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="currcontext" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Create questionnaire</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>

<h1>Create a questionnaire</h1>
<c:choose>
    <c:when test="${products!=null && products.size()>0}">
        <form method="get" action="createquestionnaire" autocomplete="off">
            <h3>Product:</h3>
            <label for="product">Choose a product </label>
            <select required name="product" id="product">
                <c:forEach var="product" items="${products}">
                    <option value="${product.id}"><c:out value="${product.name} (ID: ${product.id})"></c:out></option>
                </c:forEach>
            </select>
            <p><a href="manageproducts">Create a product</a></p>
            <h3>Date:</h3>
            <input type="date" name="date" required>
            <h3>Questions:</h3>
            <div>
                <div id="questionsBox">
                    <div>
                        <input name="q" required="required">
                    </div>
                </div>
                <button id="plus">Add question</button>
            </div>
            <br>
            <input type="submit" value="Create questionnaire">
        </form>
    </c:when>
    <c:otherwise>
        <h2><a href="manageproducts">Create a product first</a>. Then please come back.</h2>
    </c:otherwise>
</c:choose>
<script src="newquestionnaire.js"></script>
</body>
</html>