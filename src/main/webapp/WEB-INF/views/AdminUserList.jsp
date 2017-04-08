<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-plus"></i></a></li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <table id="datatable-responsive"
                                       class="table table-striped table-bordered dt-responsive nowrap"
                                       cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>First name</th>
                                        <th>Last name</th>
                                        <th>Date of birth</th>
                                        <th>E-mail address</th>
                                        <th>Login name</th>
                                        <th width="100"></th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${userList}" var="user">
                                        <tr>
                                            <td>${user.id}</td>
                                            <td>${user.firstName}</td>
                                            <td>${user.lastName}</td>
                                            <td>${user.dateOfBirth}</td>
                                            <td>${user.emailAddress}</td>
                                            <td>${user.loginName}</td>
                                            <td>
                                                <a href="<c:url value='/admin/users/edit-${user.id}' />"
                                                   class="btn btn-success custom-width">edit</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <a href="<c:url value='/admin/users/createnew' />"
                                           class="btn btn-primary">Add new</a>
                                    </div>
                                </div>


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

<!-- Datatables -->
<script src="<c:url value='/static/datatables.net-bs/js/dataTables.bootstrap.min.js' />"></script>
<%--<script src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>--%>
<%--<script src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>--%>

<!-- Custom Theme Scripts -->
<script src="<c:url value='/static/custom/js/custom.min.js' />"></script>
</body>
</html>
