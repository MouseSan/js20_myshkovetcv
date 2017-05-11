<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive Multipurpose Bootstrap Theme">
    <meta name="author" content="MyshkovetcVV">

    <title>Shop Shoe - Your settings</title>

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
    <c:import url="common/navBar.jsp"/>
    <!-- END NAVBAR -->

    <!-- BREADCRUMBS -->
    <div class="page-header one-column">
        <div class="container">
            <h1 class="page-title">Your settings</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">

            <!-- CUSTOM TABS TOP -->
            <div class="custom-tabs-line tabs-line-bottom">
                <ul class="nav" role="tablist">
                    <li class="active"><a href="#tab-top1" role="tab" data-toggle="tab">General</a></li>
                    <li><a href="#tab-top2" role="tab" data-toggle="tab">Addresses</a></li>
                    <li><a href="#tab-top3" role="tab" data-toggle="tab">Password</a></li>
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="tab-top1">
                    <form class="form-horizontal">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-6 control-label">First name</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">${userDto.firstName}</p>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-6 control-label">Last name</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">${userDto.lastName}</p>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-6 control-label">Date of birth</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">${userDto.dateOfBirth}</p>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-6 control-label">E-mail address</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">${userDto.emailAddress}</p>
                            </div>
                        </div>
                    </form>
                    <div class="custom-button-box">
                        <a href="<c:url value='/userSettings/editGeneral' />" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg">Edit</a>
                    </div>

                </div>
                <div class="tab-pane fade" id="tab-top2">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-hover product-list-table" id="addressTable">
                                <thead>
                                <tr>
                                    <th>Country</th>
                                    <th>City</th>
                                    <th>Zip code</th>
                                    <th>Street</th>
                                    <th>Apt. number</th>
                                    <th width="100"></th>
                                    <th width="100"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${addressList}" var="address">
                                    <tr>
                                        <td>${address.country}</td>
                                        <td>${address.city}</td>
                                        <td>${address.zipCode}</td>
                                        <td>${address.street}</td>
                                        <td>${address.apartmentNumber}</td>
                                        <td>
                                            <a href="<c:url value='/userSettings/editUserAddress-${address.id}' />" class="btn btn-rounded-2x btn-primary btn-block">Edit</a>
                                        </td>
                                        <td>
                                            <a href="<c:url value='/userSettings/removeUserAddress-${address.id}' />" class="btn btn-rounded-2x btn-danger btn-block">Remove</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="custom-button-box">
                        <a href="<c:url value='/userSettings/createNewAddress' />" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg">Add new address</a>
                    </div>
                </div>
                <div class="tab-pane fade" id="tab-top3">
                    <div class="custom-button-box">
                        <a href="<c:url value='/userSettings/changePassword' />" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg">Change password</a>
                    </div>
                </div>
            </div>
            <!-- END CUSTOM TABS TOP -->
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
<script src="<c:url value='/static/js/repute-scripts.js' />"></script>
<script src="<c:url value='/static/js/repute-shop.js' />"></script>

</body>

</html>
