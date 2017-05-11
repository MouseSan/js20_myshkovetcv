<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive Multipurpose Bootstrap Theme">
    <meta name="author" content="MyshkovetcVV">

    <title>Log in</title>

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
    <!-- MAIN -->
    <div class="shop-main login">
        <div class="container">
            <div class="custom-login-box">
                <!-- LOGIN BOX -->
                <div class="row">
                    <div class="account-box login-box box-with-help">
                        <h1>Create an account</h1>
                        <form:form method="POST" modelAttribute="userDto" class="form-horizontal" role="form">
                            <form:input type="hidden" path="userDtoValidationType" id="userDtoValidationType" title="Registration"/>
                            <div class="form-group">
                                <label for="userName" class="control-label sr-only">User name</label>
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user-circle"></i></span>
                                        <form:input type="text" path="userName" id="userName" class="form-control" placeholder="User name"/>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="has-error">
                                        <form:errors path="userName" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="firstName" class="control-label sr-only">Firs name</label>
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-address-book"></i></span>
                                        <form:input type="text" path="firstName" id="firstName" class="form-control" placeholder="First name"/>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="has-error">
                                        <form:errors path="firstName" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastName" class="control-label sr-only">Last name</label>
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-address-book"></i></span>
                                        <form:input type="text" path="lastName" id="lastName" class="form-control" placeholder="Last name"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="datepicker" class="control-label sr-only">Date of birth</label>
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                        <div id="date-picker-demo">
                                            <form:input type="text" path="dateOfBirth" id="datepicker" class="form-control" placeholder="Date of birth"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="has-error">
                                        <form:errors path="dateOfBirth" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="emailAddress" class="control-label sr-only">E-mail</label>
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                        <form:input type="email" path="emailAddress" id="emailAddress" class="form-control" placeholder="E-mail"/>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="has-error">
                                        <form:errors path="emailAddress" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label sr-only">Password</label>
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <form:password path="password" showPassword="false" id="password" class="form-control" placeholder="Password"/>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="has-error">
                                        <form:errors path="password" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="passwordRepeat" class="control-label sr-only">Repeat password</label>
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <form:password path="passwordRepeat" showPassword="false" id="passwordRepeat" class="form-control" placeholder="Repeat password"/>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="has-error">
                                        <form:errors path="passwordRepeat" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <button type="submit" class="btn btn-primary btn-block"><i class="fa fa-sign-in"></i> Sign up</button>
                                </div>
                            </div>
                        </form:form>
                        <p><em>Already a member?</em> <a href="<c:url value='/login' />"><strong>Log in</strong></a></p>
                    </div>
                </div>
                <!-- END LOGIN BOX -->
            </div>
        </div>
    </div>
    <!-- END MAIN -->
</div>
<!-- END WRAPPER -->
<!-- JAVASCRIPTS -->
<script src="<c:url value='/static/js/jquery-2.1.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/jquery-maskedinput/jquery.masked-input.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/moment/moment.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/bootstrap-datepicker/bootstrap-datepicker.js' />"></script>
<script src="<c:url value='/static/js/repute-scripts.js' />"></script>

</body>
</html>