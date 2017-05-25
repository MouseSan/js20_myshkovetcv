<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Edit general settings</title>
</head>

<body>

<!-- WRAPPER -->
<div class="wrapper">

    <!-- NAVBAR -->
    <c:import url="common/navBar.jsp"/>
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
