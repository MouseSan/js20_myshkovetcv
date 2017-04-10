<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>${title}</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/static/bootstrap/dist/css/bootstrap.min.css' />" rel="stylesheet"/>

</head>

<body>

<c:import url="common/MainNavigation.jsp">

    <c:param name="categoryList" value="${categoryList}"/>
    <c:param name="quantityInCart" value="${quantityInCart}"/>
</c:import>

<div class="container theme-showcase" role="main">

    <div class="row">
        <div class="col-md-12">

        </div>
    </div>


</div>

<c:import url="common/scripts.jsp"/>

</body>
</html>