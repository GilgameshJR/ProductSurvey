<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 25/04/2021
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="currcontext" value="${pageContext.request.contextPath}"/>
<header>
<c:if test="${not empty username}">
    <div style="position: fixed; right: 50px">
        Logged in as <c:out value="${username}"></c:out><br><a href="${currcontext}/logout">Logout</a>
    </div>
</c:if>
<c:if test="${empty ishomepage || !ishomepage}">
    <h3><a href="${currcontext}">Homepage</a></h3>
</c:if>
</header>