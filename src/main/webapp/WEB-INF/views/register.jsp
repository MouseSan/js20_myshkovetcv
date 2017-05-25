<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Register</title>
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