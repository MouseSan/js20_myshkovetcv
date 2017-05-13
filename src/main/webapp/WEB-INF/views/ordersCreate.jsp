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
                        <form:form method="POST" modelAttribute="ordersDto" class="form-horizontal margin-bottom-50px form-billing-shipping" role="form">
                            <%--<form class="form-horizontal margin-bottom-50px form-billing-shipping left-aligned" id="form2" data-parsley-validate novalidate role="form" method="post">--%>
                            <div class="step-pane active" data-step="2">
                                <h2 class="sr-only">Shipping</h2>
                                    <%--<p>Proactively streamline world-class experiences without front-end networks. Progressively utilize quality e-services via front-end processes. Conveniently re-engineer client-based mindshare vis-a-vis optimal synergy.</p>--%>
                                <br>
                                    <%--<form class="form-horizontal margin-bottom-50px form-billing-shipping" id="form2" data-parsley-validate novalidate role="form">--%>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="payment-method">
                                            <h3>DELIVERY METHOD</h3>
                                            <label class="fancy-radio payment-option option-credit-card">
                                                <input type="radio" name="delivery-method" id="radio-express" checked="checked">
                                                <span><i></i> <span><i class="fa fa-truck"></i> Express delivery</span>fa fa-truck</span>
                                            </label>
                                            <div class="credit-card-box">
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="billing-address">
                                                            <h3>BILLING ADDRESS</h3>

                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <div class="shipping-address">
                                                            <h3>NEW ADDRESS</h3>
                                                            <div id="shipping-inputs" class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="shp-firstname" class="control-label sr-only">First Name</label>
                                                                        <input type="text" class="form-control" id="shp-firstname" placeholder="First Name">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="shp-address1" class="control-label sr-only">Address Line 1</label>
                                                                        <input type="text" class="form-control" id="shp-address1" placeholder="Address Line 1">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="shp-city" class="control-label sr-only">City</label>
                                                                        <input type="text" class="form-control" id="shp-city" placeholder="City">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label class="control-label sr-only">Country</label>
                                                                        <select name="country" id="shp-country" class="form-control" required data-parsley-error-message="Please select your country">
                                                                            <option value="">-- Select Country --</option>
                                                                            <option value="TO">Tonga</option>
                                                                            <option value="TT">Trinidad and Tobago</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="shp-lastname" class="control-label sr-only">Last Name</label>
                                                                        <input type="text" class="form-control" id="shp-lastname" placeholder="Last Name">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="shp-address2" class="control-label sr-only">Address Line 2</label>
                                                                        <input type="text" class="form-control" id="shp-address2" placeholder="Address Line 2">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="shp-zipcode" class="control-label sr-only">Zip Code</label>
                                                                        <input type="text" class="form-control" id="shp-zipcode" placeholder="Zip Code">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="shp-phone" class="control-label sr-only">Phone</label>
                                                                        <input type="text" class="form-control" id="shp-phone" placeholder="Phone">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <label class="fancy-radio payment-option option-paypal">
                                                <input type="radio" name="delivery-method" id="radio-self-pickup">
                                                <span><i></i> <span><i class="fa fa-paypal"></i> Self pickup</span></span>
                                            </label>
                                            <div class="paypal-input hide-first">
                                                <div class="form-group">
                                                    <label for="shp-phone" class="control-label sr-only">Phone</label>
                                                    <input type="text" class="form-control" id="shp-phone" placeholder="Phone">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                    <%--</form>--%>
                            </div>
                            <!-- END SHIPPING -->
                            <!-- PAYMENT -->
                            <div class="step-pane" data-step="3">
                                <h2 class="sr-only">Payment</h2>
                                    <%--<form id="form-payment" class="form-horizontal left-aligned" data-parsley-validate novalidate>--%>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="payment-method">
                                            <h3>PAYMENT METHOD</h3>
                                            <label class="fancy-radio payment-option option-credit-card">
                                                <input type="radio" name="payment-method" id="radio-credit-card" checked="checked">
                                                <span><i></i> <span><i class="fa fa-credit-card"></i> Credit Card</span></span>
                                            </label>
                                            <div class="credit-card-box">
                                                <p class="header-message"><i class="fa fa-lock"></i> This is a secure 128-bit SSL Encrypted payment. You are safe.</p>
                                                <div class="credit-card-inputs">
                                                    <div class="form-group">
                                                        <label for="inputCardName" class="col-sm-4 control-label">Name on Card</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" id="inputCardName" required>
                                                            <p class="help-block"><em>As it appears on your card</em></p>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputCardNumber" class="col-sm-4 control-label">Card Number</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" id="inputCardNumber" data-parsley-type="number" required>
                                                            <p class="help-block"><em>No dashes or spaces</em></p>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">Expiration Date</label>
                                                        <div class="col-sm-8">
                                                            <select name="expiryMonth" id="inputExpiryMonth" class="form-control control-inline" data-parsley-error-message="Please specify month" data-parsley-errors-container="#error-expiry" required>
                                                                <option value="">Month</option>
                                                                <option value="01">01</option>
                                                                <option value="02">02</option>
                                                                <option value="03">03</option>
                                                                <option value="04">04</option>
                                                                <option value="05">05</option>
                                                                <option value="06">06</option>
                                                                <option value="07">07</option>
                                                                <option value="08">08</option>
                                                                <option value="09">09</option>
                                                                <option value="10">10</option>
                                                                <option value="11">11</option>
                                                                <option value="12">12</option>
                                                            </select> <span class="date-separator">/</span>
                                                            <select name="expiryYear" id="inputExpiryYear" class="form-control control-inline" data-parsley-error-message="Please specify year" data-parsley-errors-container="#error-expiry" required>
                                                                <option value="">Year</option>
                                                                <option value="2015">2015</option>
                                                                <option value="2016">2016</option>
                                                                <option value="2017">2017</option>
                                                                <option value="2018">2018</option>
                                                                <option value="2019">2019</option>
                                                                <option value="2020">2020</option>
                                                                <option value="2021">2021</option>
                                                                <option value="2022">2022</option>
                                                                <option value="2023">2023</option>
                                                            </select>
                                                            <span id="error-expiry"></span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputSecurityCode" class="col-sm-4 control-label">Security Code</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control input-security-code" id="inputSecurityCode" data-parsley-type="number" data-parsley-errors-container="#error-security-code" required> <img src="assets/img/cards/credit.png" class="img-security-code" alt="Security Code">
                                                            <div class="clearfix"></div>
                                                            <span id="error-security-code"></span>
                                                            <p class="help-block"><em>The last 3 digits displayed on the back of your credit card</em></p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <label class="fancy-radio payment-option option-paypal">
                                                <input type="radio" name="payment-method" id="radio-paypal">
                                                <span><i></i> <span><i class="fa fa-paypal"></i> Paypal</span></span>
                                            </label>
                                            <div class="paypal-input hide-first">
                                                <div class="form-group">
                                                    <label for="inputPaypalEmail" class="col-sm-3 control-label">Email Address</label>
                                                    <div class="col-sm-6">
                                                        <input type="email" class="form-control" id="inputPaypalEmail">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-md-offset-2">
                                        <div class="payment-summary">
                                            <h3>SUMMARY</h3>
                                            <p>Below is the summary of your purchase</p>
                                            <table class="table payment-summary-table">
                                                <tbody>
                                                <tr>
                                                    <td>Subtotal</td>
                                                    <td>$22.25</td>
                                                </tr>
                                                <tr>
                                                    <td>Coupon</td>
                                                    <td class="discount">- $2.25</td>
                                                </tr>
                                                <tr>
                                                    <td>Shipping</td>
                                                    <td>$0</td>
                                                </tr>
                                                <tr class="row-total">
                                                    <td>Total</td>
                                                    <td>$20.00</td>
                                                </tr>
                                                <tr class="row-payment-method">
                                                    <td>Payment Method</td>
                                                    <td>Credit Card
                                                        <br>xxxx-xxxx-xxxx-3456</td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2">
                                                        <label class="fancy-checkbox">
                                                            <input type="checkbox" name="checkTerms" data-parsley-required="true" data-parsley-error-message="You must agree with the terms &amp; conditions" data-parsley-errors-container="#error-terms">
                                                            <span>I agree with <a href="#">Terms &amp; Conditions</a></span>
                                                        </label>
                                                        <p id="error-terms"></p>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                    <%--</form>--%>
                            </div>
                            <%--</form>--%>
                        </form:form>
                        <!-- END PAYMENT -->
                    </div>
                    <!-- BUTTONS -->
                    <div class="actions">
                        <%--<a href="<c:url value='/' />" id="btn-continue-shopping" class="btn btn-default">CONTINUE SHOPPING</a>--%>
                        <%--<a href="<c:url value='/orders/create' />" id="btn-checkout-next" class="btn btn-primary">CHECKOUT</a>--%>
                        <a href="#" id="btn-continue-shopping" class="btn btn-default">CONTINUE SHOPPING</a>
                        <button id="btn-checkout-prev" type="button" class="btn btn-default btn-prev hide-first">PREVIOUS</button>
                        <button id="btn-checkout-next" type="button" class="btn btn-primary btn-next">CHECKOUT</button>
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
