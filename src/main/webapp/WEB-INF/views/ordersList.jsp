<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Orders list</title>
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
                        <c:choose>
                            <c:when test="${adminPanel != null}">
                                <a href="<c:url value='/admin/orders/' />" class="btn btn-primary">All</a>
                                <a href="<c:url value='/admin/orders/pending/' />" class="btn btn-primary">Pending</a>
                                <a href="<c:url value='/admin/orders/waitingforshipment/' />" class="btn btn-primary">Waiting for shipment</a>
                                <a href="<c:url value='/admin/orders/shipped/' />" class="btn btn-primary">Shipped</a>
                                <a href="<c:url value='/admin/orders/completed/' />" class="btn btn-primary">Completed</a>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value='/orders/all' />" class="btn btn-primary">All</a>
                                <a href="<c:url value='/orders/pending' />" class="btn btn-primary">Pending</a>
                                <a href="<c:url value='/orders/waitingforshipment' />" class="btn btn-primary">Waiting for shipment</a>
                                <a href="<c:url value='/orders/shipped' />" class="btn btn-primary">Shipped</a>
                                <a href="<c:url value='/orders/completed' />" class="btn btn-primary">Completed</a>
                            </c:otherwise>
                        </c:choose>
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
<c:import url="common/scriptsTag.jsp" />

</body>

</html>
