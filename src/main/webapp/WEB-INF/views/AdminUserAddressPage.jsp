<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${title}</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/static/bootstrap/dist/css/bootstrap.min.css' />" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value='/static/font-awesome/css/font-awesome.min.css' />" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value='/static/nprogress/nprogress.css' />" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value='/static/custom/css/custom.min.css' />" rel="stylesheet">

</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <c:import url="common/AdminNavigation.jsp">
            <c:param name="title" value="${title}"/>
        </c:import>

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="clearfix"></div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>${title}</h2>

                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br>
                                <form:form method="POST" modelAttribute="userAddress"
                                           class="form-horizontal form-label-left">
                                    <form:input type="hidden" path="id" id="id"/>


                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                               for="country">Country</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <form:input type="text" path="country" id="country"
                                                        required="required"
                                                        class="form-control col-md-7 col-xs-12"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                               for="city">City</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <form:input type="text" path="city" id="city"
                                                        required="required"
                                                        class="form-control col-md-7 col-xs-12"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                               for="zipCode">Zip code</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <form:input type="text" path="zipCode" id="zipCode"
                                                        required="required"
                                                        class="form-control col-md-7 col-xs-12"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                               for="street">Street</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <form:input type="text" path="street" id="street"
                                                        required="required"
                                                        class="form-control col-md-7 col-xs-12"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                               for="apartmentNumber">Apt. number</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <form:input type="text" path="apartmentNumber"
                                                        id="apartmentNumber" required="required"
                                                        class="form-control col-md-7 col-xs-12"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12"
                                               for="user">User</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <form:select path="user" id="user" items="${userList}"
                                                         itemValue="id" itemLabel="loginName"
                                                         class="form-control input-sm"/>
                                        </div>
                                    </div>


                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                            <a href="<c:url value='/admin/useraddresses' />"
                                               class="btn btn-primary">Cancel</a>
                                            <button type="submit" class="btn btn-success">Submit
                                            </button>
                                        </div>
                                    </div>

                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="<c:url value='/static/jquery/dist/jquery.min.js' />"></script>
<!-- Bootstrap -->
<script src="<c:url value='/static/bootstrap/dist/js/bootstrap.min.js' />"></script>
<!-- FastClick -->
<script src="<c:url value='/static/fastclick/lib/fastclick.js' />"></script>
<!-- NProgress -->
<script src="<c:url value='/static/nprogress/nprogress.js' />"></script>

<!-- Custom Theme Scripts -->
<script src="<c:url value='/static/custom/js/custom.min.js' />"></script>
</body>
</html>

