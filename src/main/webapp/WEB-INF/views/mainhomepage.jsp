<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<c:import url="common/headtag.jsp">
    <c:param name="title" value="${title}"/>
</c:import>

<body>

<c:import url="common/header.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h1>Welcome to E-shop project!</h1>
        <p><a class="btn btn-primary btn-lg" href="<c:url value='/products' />" role="button">Dive
            in catalog »</a></p>
    </div>
</div>

<c:import url="common/scripts.jsp"/>

</body>
</html>