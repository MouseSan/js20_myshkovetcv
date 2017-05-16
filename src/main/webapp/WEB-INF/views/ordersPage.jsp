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
            <h1 class="page-title">Order #${order.id}</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label">ID</label>
                            <div class="col-sm-3">
                                <p class="form-control-static">${order.id}</p>
                            </div>
                            <label class="col-sm-2 control-label">Date of order</label>
                            <div class="col-sm-5">
                                <p class="form-control-static">${order.dateOfOrder}</p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label">Order state</label>
                            <div class="col-sm-3">
                                <p class="form-control-static">${order.ordersState}</p>
                            </div>
                            <label class="col-sm-2 control-label">Payment state</label>
                            <div class="col-sm-5">
                                <p class="form-control-static">${order.paymentState}</p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label">Delivery method</label>
                            <div class="col-sm-3">
                                <p class="form-control-static">${order.deliveryMethod}</p>
                            </div>
                            <label class="col-sm-2 control-label">Payment method</label>
                            <div class="col-sm-5">
                                <p class="form-control-static">${order.paymentMethod}</p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label">Delivery address</label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${order.deliveryAddress}</p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <table class="table shopping-cart-table" id="cartTable">
                        <thead>
                        <tr>
                            <th>PRODUCTS</th>
                            <th>PRICE</th>
                            <th>QUANTITY</th>
                            <th>TOTAL</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${productList}" var="product">
                            <tr>
                                <td class="item">
                                    <div class="media">
										<span class="media-left">
											<img src="<c:url value='/static/img/products/furniture1.png' />" class="product-image" alt="Product Image">
    									</span>
                                        <div class="media-body">
                                            <a href="#" class="product-title">${product.productDto.name}</a>
                                            <span class="brief-desc">Brand: ${product.productDto.brandDto.name}, Backlight: ${product.productDto.backlight}, Clock face: ${product.productDto.clockFace}, Glass: ${product.productDto.glass}, Gender: ${product.productDto.gender}, Water resistant: ${product.productDto.waterResistant}.</span>
                                        </div>
                                    </div>
                                </td>
                                <td class="unit-price">${product.soldPrice}</td>
                                <td class="qty">${product.soldQuantity}</td>
                                <td class="total-price">${product.soldPrice * product.soldQuantity}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="two-button-box">
                <div class="row">
                    <div class="col-md-6">
                        <a href="<c:url value='/orders/all' />" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg">Back</a>
                    </div>
                    <div class="col-md-6">
                        <a href="<c:url value='/orders/repeat-${order.id}' />" class="btn btn-rounded-2x btn-outline btn-success btn-block btn-lg">Repeat</a>
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
