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
                <form:form method="POST" modelAttribute="ordersDto" class="form-horizontal margin-bottom-50px form-billing-shipping" role="form" id="checkout-form">
                    <div id="checkout-wizard" class="wizard checkout-wizard">
                        <div class="steps-container">
                            <ul class="list-inline steps">
                                <li data-step="1" data-name="shopping-cart"><span class="step-number">1</span><span class="title">Shopping Cart</span></li>
                                <li data-step="2" data-name="shipping" class="active"><span class="step-number">2</span><span class="title">Shipping</span></li>
                                <li data-step="3" data-name="payment"><span class="step-number">3</span><span class="title">Payment</span></li>
                            </ul>
                        </div>
                        <div class="step-content">
                            <!-- SHOPPING CART -->
                            <div class="step-pane" data-step="1">
                            </div>
                            <!-- END SHOPPING CART -->
                            <!-- SHIPPING -->

                            <div class="step-pane active" data-step="2">
                                <h2 class="sr-only">Shipping</h2>
                                <br>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="delivery-method">
                                            <h3>DELIVERY METHOD</h3>
                                            <label class="fancy-radio delivery-option option-express-delivery">
                                                <input type="radio" name="deliveryMethod" id="radio-express" checked="checked" value="ExpressDelivery">
                                                <span><i></i> <span><i class="fa fa-truck"></i> Express delivery</span></span>
                                            </label>
                                            <div class="express-delivery-box">
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="billing-address">
                                                            <h3>BILLING ADDRESS</h3>
                                                            <div class="express-delivery-addresses">
                                                                <label class="fancy-radio delivery-option option-credit-card">
                                                                    <input type="radio" name="deliveryAddress" id="new-address-radio" checked="checked"
                                                                           value="New Address">
                                                                    <span><i></i> <span>NEW ADDRESS</span></span>
                                                                </label>
                                                                <c:forEach items="${addressList}" var="address">
                                                                    <label class="fancy-radio delivery-option option-credit-card">
                                                                        <input type="radio" name="deliveryAddress" id="address-${address.id}"
                                                                               value="${address.zipCode}, ${address.country}, ${address.city}, ${address.street}, ${address.apartmentNumber}">
                                                                        <span><i></i> <span>${address.zipCode}, ${address.country}, ${address.city}, ${address.street}, ${address.apartmentNumber}</span></span>
                                                                    </label>
                                                                </c:forEach>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6 new-address-box">
                                                        <div class="shipping-address">
                                                            <h3>NEW ADDRESS</h3>
                                                            <div id="shipping-inputs" class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="newAddressCountry" class="control-label sr-only">Country</label>
                                                                        <input type="text" class="form-control" name="newAddressCountry" id="newAddressCountry" placeholder="Country">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="newAddressCity" class="control-label sr-only">City</label>
                                                                        <input type="text" class="form-control" name="newAddressCity" id="newAddressCity" placeholder="City">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-12">
                                                                    <div class="form-group">
                                                                        <label for="newAddressStreet" class="control-label sr-only">Street</label>
                                                                        <input type="text" class="form-control" name="newAddressStreet" id="newAddressStreet" placeholder="Street">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="newAddressApartmentNumber" class="control-label sr-only">Apartment number</label>
                                                                        <input type="text" class="form-control" name="newAddressApartmentNumber" id="newAddressApartmentNumber" placeholder="Apartment number">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="newAddressZipCode" class="control-label sr-only">Zip Code</label>
                                                                        <input type="text" class="form-control" name="newAddressZipCode" id="newAddressZipCode" placeholder="Zip Code">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <label class="fancy-radio delivery-option option-self-pickup">
                                                <input type="radio" name="deliveryMethod" id="radio-self-pickup" value="Pickup">
                                                <span><i></i> <span><i class="fa fa-child"></i> Self pickup</span></span>
                                            </label>
                                            <div class="self-pickup-box hide-first">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <!-- END SHIPPING -->
                            <!-- PAYMENT -->
                            <div class="step-pane" data-step="3">
                                <h2 class="sr-only">Payment</h2>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="payment-method">
                                            <h3>PAYMENT METHOD</h3>
                                            <label class="fancy-radio payment-option option-credit-card">
                                                <input type="radio" name="paymentMethod" id="radio-credit-card" checked="checked" value="Card">
                                                <span><i></i> <span><i class="fa fa-credit-card"></i> Card upon receipt</span></span>
                                            </label>
                                            <div class="credit-card-box">
                                            </div>
                                            <label class="fancy-radio payment-option option-paypal">
                                                <input type="radio" name="paymentMethod" id="radio-paypal" value="Cash">
                                                <span><i></i> <span><i class="fa fa-dollar"></i> Cash</span></span>
                                            </label>
                                            <div class="paypal-input hide-first">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-md-offset-2">
                                        <div class="payment-summary">
                                            <h3>SUMMARY</h3>
                                            <p>Below is the summary of your purchase</p>
                                            <table class="table payment-summary-table">
                                                <tbody>
                                                <tr class="row-total">
                                                    <td>Total</td>
                                                    <td>$${totalPrice}</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- END PAYMENT -->
                        </div>
                        <!-- BUTTONS -->
                        <div class="actions">
                            <a id="btn-back-to-cart" class="btn btn-primary btn-prev" href="<c:url value='/cart'/>">PREVIOUS</a>
                            <button id="btn-checkout-next" type="button" class="btn btn-primary btn-next">NEXT</button>
                            <button id="btn-checkout-prev" type="button" class="btn btn-primary btn-prev hide-first">PREVIOUS</button>
                            <button id="btn-checkout-submit" type="submit" class="btn btn-success btn-next hide-first">SUBMIT</button>
                        </div>
                        <!-- END BUTTONS -->
                    </div>
                </form:form>
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
