<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Checkout</title>
</head>

<body>

<!-- WRAPPER -->
<div class="wrapper" id="wrap">

    <!-- NAVBAR -->
    <c:import url="common/navBar.jsp"/>
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
                                <c:if test="${param.notEnoughQuantity != null}">
                                    <div class="alert alert-danger" role="alert">
                                        <p>Not enough quantity in stock. Subtract items.</p>
                                    </div>
                                </c:if>
                                <c:if test="${param.noProductsInCart != null}">
                                    <div class="alert alert-danger" role="alert">
                                        <p>No items items in cart, add products please.</p>
                                    </div>
                                </c:if>
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
                                                        <c:choose>
                                                            <c:when test="${product.key.imageId == null || product.key.imageId.isEmpty()}">
                                                                <img src="<c:url value='/static/img/small-product-plug.png' />" class="product-image" alt="Product Image">
                                                            </c:when>
                                                            <c:otherwise>
                                                                <img src="<c:url value='http://res.cloudinary.com/mousesan/image/upload/w_75,h_75,c_pad,b_rgb:FFFFFF/${product.key.imageId}.png' />" class="product-image" alt="Product Image">
                                                            </c:otherwise>
                                                        </c:choose>
													</span>
                                                    <div class="media-body">
                                                        <a href="<c:url value='/products/${product.key.id}' />" class="product-title">${product.key.name}</a>
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
