<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 24/04/2021
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
  <title>Create product</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
<h1>Product management</h1>
<section>
  <h2>Delete a product</h2>
  <h3>Warning: all associated questionnaires with their data will be deleted</h3>
  <form action="deleteproduct" method="get">
    <c:choose>
      <c:when test="${products!=null && products.size()>0}">
        <label for="product">Product </label>
        <select required name="product" id="product">
      <c:forEach var="product" items="${products}">
        <option value="${product.id}"><c:out value="${product.name} (ID: ${product.id})"></c:out></option>
      </c:forEach>
    </select>
    <input type="submit" value="Delete">
      </c:when>
      <c:otherwise>
          No product to delete
      </c:otherwise>
    </c:choose>
  </form>
</section>
<section>
  <h2>Create a product</h2>
  <form action="createproduct" method="post" enctype="multipart/form-data">
    <p><label for="name">Name </label><input name="name" required id="name"></p>
    <p><label for="picture">Picture </label><input type="file" name="picture" id="picture" required></p>
    <input type="submit" value="Create">
  </form>
</section>
</body>
</html>
