<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Log in</title>
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
                        <h1>Log in to your account</h1>
                        <form action="/login" method="post" class="form-horizontal" role="form">
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username or password.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.registersuccess != null}">
                                <div class="alert alert-success">
                                    <p>You have been registered successfully. Please, log in.</p>
                                </div>
                            </c:if>
                            <div class="form-group">
                                <label for="userName" class="control-label sr-only">User name</label>
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user-circle"></i></span>
                                        <input type="text" class="form-control" id="userName" name="userName" placeholder="User name" required>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label sr-only">Password</label>
                                <div class="col-sm-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <button type="submit" class="btn btn-primary btn-block"><i class="fa fa-sign-in"></i> Sign in</button>
                                </div>
                            </div>
                        </form>
                        <p><em>Don't have an account yet?</em> <a href="<c:url value='/register' />"><strong>Sign Up</strong></a></p>
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
<script src="<c:url value='/static/js/repute-shop.js' />"></script>

</body>
</html>