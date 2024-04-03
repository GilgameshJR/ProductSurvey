<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 23/04/2021
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="currcontext" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Part 2</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>

<h1>Please insert your personal informations</h1>
<form action="part2submit">
    <div>
        <p>Age</p>
        <input id="age" name="age" type="number" min="1" placeholder="No answer">
        <p>Sex</p>
        <select name="sex" id="sex">
            <option value="">No answer</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
    </select>
    <p>Expertise level</p>
    <select name="experience" id="experience">
        <option value="">No answer</option>
        <option value="low">Low</option>
        <option value="medium">Medium</option>
        <option value="high">High</option>
    </select>
    </div><br>
    <button type="submit">Confirm</button>
</form>
<button onclick="location.href='${currcontext}/memberzone/questionnaire/part1'" type="button">Go back</button></body>
</html>
