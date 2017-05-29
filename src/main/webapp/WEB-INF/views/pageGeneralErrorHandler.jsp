<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Trouble page</title>
</head>

<body>
<!-- WRAPPER -->
<div class="wrapper">
    <!-- MAIN -->
    <div class="shop-main login">
        <div class="container">
            <div class="error-container">
                <h1>OOPS!</h1>
                <h2>Something went wrong, try from home page</h2>
                <hr />
                <a class="btn btn-rounded-2x btn-primary btn-block btn-lg" href="<c:url value='/' />" >Home page</a>
            </div>
        </div>
    </div>
    <!-- END MAIN -->
</div>
<!-- END WRAPPER -->

<!-- JAVASCRIPTS -->
<script src="<c:url value='/static/js/jquery-2.1.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/static/js/repute-shop.js' />"></script>

</body>
</html>