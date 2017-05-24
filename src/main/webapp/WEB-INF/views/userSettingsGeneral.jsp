<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive Multipurpose Bootstrap Theme">
    <meta name="author" content="MyshkovetcVV">

    <title>Shop Shoe - Edit general settings</title>

    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/bootstrap.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/font-awesome.min.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/main.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/shop-main.css' />" />

    <!-- GOOGLE FONTS -->
    <link rel="stylesheet" type="text/css" href="<c:url value='http://fonts.googleapis.com/css?family=Open+Sans:300,400italic,400,600,700' />" >
    <link rel="stylesheet" type="text/css" href="<c:url value='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,300italic,400italic,700,400,300' />" >

    <!-- FAVICONS -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/static/ico/repute144x144.png' />" >
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value='/static/ico/repute114x114.png' />" >
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/static/ico/repute72x72.png' />" >
    <link rel="apple-touch-icon-precomposed" sizes="57x57" href="<c:url value='/static/ico/repute57x57.png' />" >
    <link rel="shortcut icon" href="<c:url value='/static/ico/favicon.png' />">

</head>

<body>

<!-- WRAPPER -->
<div class="wrapper">

    <!-- NAVBAR -->
    <c:import url="common/navBar.jsp">
        <c:param name="categoryList" value="${categoryList}"/>
        <c:param name="quantityInCart" value="${quantityInCart}"/>
    </c:import>
    <!-- END NAVBAR -->

    <!-- BREADCRUMBS -->
    <div class="page-header one-column">
        <div class="container">
            <h1 class="page-title">General settings</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">
            <form:form method="POST" modelAttribute="userDto" class="form-horizontal" role="form">
                <form:input type="hidden" path="id" id="id"/>
                <div class="form-group form-group-lg">
                    <label for="firstName" class="col-sm-3 control-label">First name</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="firstName" id="firstName" class="form-control" placeholder="First name"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="firstName" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="lastName" class="col-sm-3 control-label">Last name</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="lastName" id="lastName" class="form-control" placeholder="Last name"/>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="datepicker" class="col-sm-3 control-label">Date of birth</label>
                    <div class="col-sm-9">
                        <div id="date-picker-demo">
                            <form:input type="text" path="dateOfBirth" id="datepicker" class="form-control" placeholder="Date of birth"/>
                        </div>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="dateOfBirth" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="emailAddress" class="col-sm-3 control-label">E-mail address</label>
                    <div class="col-sm-9">
                        <form:input type="email" path="emailAddress" id="emailAddress" class="form-control" placeholder="E-mail"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="emailAddress" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="row row-bottom-padding">
                    <div class="col-sm-offset-3 col-sm-3">
                        <button type="submit" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg" >Save</button>
                    </div>
                    <div class="col-sm-3">
                        <a class="btn btn-rounded-2x btn-outline btn-danger btn-block btn-lg" href="<c:url value='/userSettings/' />" >Cancel</a>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <!-- END MAIN -->

    <!-- FOOTER -->
    <c:import url="common/footer.jsp" />
    <!-- END FOOTER -->

</div>
<!-- END WRAPPER -->
<!-- JAVASCRIPTS -->
<script src="<c:url value='/static/js/jquery-2.1.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/autohidingnavbar/jquery.bootstrap-autohidingnavbar.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/jquery-maskedinput/jquery.masked-input.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/moment/moment.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/bootstrap-datepicker/bootstrap-datepicker.js' />"></script>
<script src="<c:url value='/static/js/repute-scripts.js' />"></script>
<script src="<c:url value='/static/js/repute-shop.js' />"></script>

</body>

</html>
