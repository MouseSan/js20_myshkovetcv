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
            <h1 class="page-title">Orders list</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">
            <div class="button-box-center">
                <div class="row">
                    <div class="col-md-12">
                        <a href="<c:url value='/orders/all' />" class="btn btn-primary">All</a>
                        <a href="<c:url value='/orders/pending' />" class="btn btn-primary">Pending</a>
                        <a href="<c:url value='/orders/waitingforshipment' />" class="btn btn-primary">Waiting for shipment</a>
                        <a href="<c:url value='/orders/shipped' />" class="btn btn-primary">Shipped</a>
                        <a href="<c:url value='/orders/completed' />" class="btn btn-primary">Completed</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">

                    <table class="table shopping-cart-table" id="cartTable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Orders conditions</th>
                            <th>Date</th>
                            <th>Total quantity</th>
                            <th>Total price</th>
                            <th width="80"></th>
                            <th width="80"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ordersList}" var="orders">
                            <tr>
                                <td>${orders.id}</td>
                                <td class="item">
                                    <div class="media">
                                        <div class="media-body">
                                            <a href="<c:url value='/orders/${orders.id}' />" class="product-title">
                                                <c:choose>
                                                    <c:when test="${orders.ordersState == 'WaitingForShipment'}">
                                                        <span class="brief-desc">Order state: Waiting for shipment. </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="brief-desc">Order state: ${orders.ordersState}. </span>
                                                    </c:otherwise>
                                                </c:choose>

                                                <c:choose>
                                                    <c:when test="${orders.paymentState == 'NotPaid'}">
                                                        <span class="brief-desc">Payment state: Not paid.</span><br>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="brief-desc">Payment state: ${orders.paymentState}.</span><br>
                                                    </c:otherwise>
                                                </c:choose>

                                                <span class="brief-desc">Payment method: ${orders.paymentMethod}. </span>
                                                <c:choose>
                                                    <c:when test="${orders.deliveryMethod == 'ExpressDelivery'}">
                                                        <span class="brief-desc">Delivery method: Express delivery.</span><br>
                                                        <span class="brief-desc">Delivery address: ${orders.deliveryAddress}.</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="brief-desc">Delivery method: ${orders.deliveryMethod}.</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </a>
                                        </div>
                                    </div>
                                </td>
                                <td>${orders.dateOfOrder}</td>
                                <td class="qty">${orders.totalQuantity}</td>
                                <td class="total-price">${orders.totalPrice}</td>
                                <td>
                                    <a href="<c:url value='/orders/${orders.id}' />" class="btn btn-primary btn-block">View</a>
                                </td>
                                <td>
                                    <a href="<c:url value='/orders/repeat-${orders.id}' />" class="btn btn-success custombtn-block">Repeat</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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
