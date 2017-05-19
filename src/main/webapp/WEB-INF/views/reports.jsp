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

    <title>Shop Shoe - Orders list</title>

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
            <h1 class="page-title">Reports</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">
            <!-- CUSTOM TABS TOP -->
            <div class="custom-tabs-line tabs-line-bottom">
                <ul class="nav" role="tablist">
                    <li class="active"><a href="#tab-top1" role="tab" data-toggle="tab">Top 10 products</a></li>
                    <li><a href="#tab-top2" role="tab" data-toggle="tab">Top 10 users</a></li>
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="tab-top1">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table shopping-cart-table">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Parameters</th>
                                    <th>Quantity sold</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listTopSoldProducts}" var="soldProduct">
                                    <tr>
                                        <td class="item-image">
                                            <div class="media">
														<span class="media-left">
															<img src="<c:url value='/static/img/products/furniture1.png' />" class="product-image" alt="Product Image">
														</span>
                                                <div class="media-body">
                                                    <a href="#" class="product-title">${soldProduct.productDto.name}</a>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="item-parameters">
                                            <div class="media">
                                                <div class="media-body">
                                                    <a href="#" class="product-title"></a>
                                                    <span class="brief-desc">Brand: ${soldProduct.productDto.brandDto.name}, Backlight: ${soldProduct.productDto.backlight}, Clock face: ${soldProduct.productDto.clockFace}, Glass: ${soldProduct.productDto.glass}, Gender: ${soldProduct.productDto.gender}, Water resistant: ${soldProduct.productDto.waterResistant}.</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="total-price">${soldProduct.soldQuantity}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="tab-top2">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table shopping-cart-table">
                                <thead>
                                <tr>
                                    <th>User</th>
                                    <th>E-mail</th>
                                    <th>Total purchased</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listTopBuyers}" var="buyer">
                                    <tr>
                                        <td class="item-user-name">
                                            <div class="media">
                                                <div class="media-body">
                                                    <a href="#" class="product-title">${buyer.userDto.firstName} ${buyer.userDto.lastName}</a>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="item-user-email">
                                            <div class="media">
                                                <div class="media-body">
                                                    <a href="#" class="product-title">${buyer.userDto.emailAddress}</a>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="total-price">${buyer.totalPrice}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
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
