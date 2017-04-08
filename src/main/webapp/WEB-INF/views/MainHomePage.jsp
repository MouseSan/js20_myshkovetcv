<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>${title}</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/static/bootstrap/dist/css/bootstrap.min.css' />"
          rel="stylesheet"></link>

</head>

<body>

<c:import url="common/MainNavigation.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h1>Welcome to E-shop project!</h1>
    </div>
</div>

<c:import url="common/scripts.jsp"/>

</body>
</html>