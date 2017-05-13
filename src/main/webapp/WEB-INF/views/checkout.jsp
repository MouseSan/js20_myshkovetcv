<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive Multipurpose Bootstrap Theme">
    <meta name="author" content="MyshkovetcVV">

    <title>Shop Shoe</title>

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
<div class="wrapper" id="wrap">

    <!-- NAVBAR -->
    <c:import url="common/navBar.jsp">
        <c:param name="categoryList" value="${categoryList}"/>
        <c:param name="quantityInCart" value="${quantityInCart}"/>
    </c:import>
    <!-- END NAVBAR -->

    <!-- BREADCRUMBS -->
    <div class="page-header one-column">
        <div class="container">
            <h1 class="page-title">Checkout</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->
    <!-- MAIN -->
    <div class="shop-main checkout">
        <div class="container">
            <div class="fuelux">
                <div id="checkout-wizard" class="wizard checkout-wizard">
                    <div class="steps-container">
                        <ul class="list-inline steps">
                            <li data-step="1" data-name="shopping-cart" class="active"><span class="step-number">1</span><span class="title">Shopping Cart</span></li>
                            <li data-step="2" data-name="shipping"><span class="step-number">2</span><span class="title">Shipping</span></li>
                            <li data-step="3" data-name="payment"><span class="step-number">3</span><span class="title">Payment</span></li>
                        </ul>
                    </div>
                    <div class="step-content">
                        <div class="row" id="errMsg">
                            <div class="col-md-12">
                                <c:choose>
                                    <c:when test="${notEnoughQuantity}">
                                        <div class="alert alert-danger" role="alert">
                                            <p>Not enough quantity in stock. Subtract items.</p>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>
                        <!-- SHOPPING CART -->
                        <div class="step-pane active" data-step="1">
                            <h2 class="sr-only">Shopping Cart</h2>
                            <form action="#" id="form1">
                                <table class="table shopping-cart-table" id="cartTable">
                                    <thead>
                                    <tr>
                                        <th>PRODUCTS</th>
                                        <th>PRICE</th>
                                        <th>QUANTITY</th>
                                        <th>STOCK</th>
                                        <th>TOTAL</th>
                                        <th>&nbsp;</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${productMap}" var="product" varStatus="productListCount">
                                        <tr>
                                            <td class="item">
                                                <div class="media">
														<span class="media-left">
															<img src="<c:url value='/static/img/products/furniture1.png' />" class="product-image" alt="Product Image">
														</span>
                                                    <div class="media-body">
                                                        <a href="#" class="product-title">${product.key.name}</a>
                                                        <span class="brief-desc">Brand: ${product.key.brandDto.name}, Backlight: ${product.key.backlight}, Clock face: ${product.key.clockFace}, Glass: ${product.key.glass}, Gender: ${product.key.gender}, Water resistant: ${product.key.waterResistant}.</span>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="unit-price">${product.key.price}</td>
                                            <td class="qty">${product.value}</td>
                                            <td class="qty">${product.key.stock}</td>
                                            <td class="total-price">${product.value * product.key.price}</td>
                                            <td class="remove">
                                                <button class="btn btn-link btn-remove removeOneFromCart" type="button" title="Remove this item" value="${product.key.id}"> <i class="fa fa-minus"></i> </button>
                                            </td>
                                            <td class="remove">
                                                <button class="btn btn-link btn-remove removeFromCart" type="button"  title="Remove this item" value="${product.key.id}"> <i class="fa fa-remove"></i> </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <hr>
                                <div class="shopping-cart-bottom">
                                    <div class="row">
                                        <div class="col-xs-6">
                                        </div>
                                        <div class="col-xs-5 col-xs-offset-1">
                                            <table class="table shopping-cart-summary text-right" id="totalPrice">
                                                <tbody>
                                                <tr>
                                                    <td><strong>Total</strong></td>
                                                    <td class="grand-total"><strong>${totalPrice}</strong></td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- END SHOPPING CART -->
                        <!-- SHIPPING -->
                        <div class="step-pane" data-step="2">
                        </div>
                        <!-- END SHIPPING -->
                        <!-- PAYMENT -->
                        <div class="step-pane" data-step="3">
                        </div>
                        <!-- END PAYMENT -->
                    </div>
                    <!-- BUTTONS -->
                    <div class="actions">
                        <a href="<c:url value='/' />" id="btn-continue-shopping" class="btn btn-default">CONTINUE SHOPPING</a>
                        <a href="<c:url value='/orders/create' />" id="btn-checkout-next" class="btn btn-primary">CHECKOUT</a>
                    </div>
                    <!-- END BUTTONS -->
                </div>
            </div>
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
<script src="<c:url value='/static/js/plugins/parsley-validation/parsley.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/fuelux-wizard/wizard.js' />"></script>
<script src="<c:url value='/static/js/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.min.js' />"></script>
<script src="<c:url value='/static/js/repute-scripts.js' />"></script>
<script src="<c:url value='/static/js/repute-shop.js' />"></script>
<script src="<c:url value='/static/js/cart.js' />"></script>

</body>

</html>
