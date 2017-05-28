<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Reports</title>
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
                                                    <c:choose>
                                                        <c:when test="${soldProduct.productDto.imageId == null || soldProduct.productDto.imageId.isEmpty()}">
                                                            <img src="<c:url value='/static/img/small-product-plug.png' />" class="product-image" alt="Product Image">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="<c:url value='http://res.cloudinary.com/mousesan/image/upload/w_75,h_75,c_pad,b_rgb:FFFFFF/${soldProduct.productDto.imageId}.png' />" class="product-image" alt="Product Image">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <div class="media-body">
                                                    <a href="<c:url value='/products/${soldProduct.productDto.id}' />" class="product-title">${soldProduct.productDto.name}</a>
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
<c:import url="common/scriptsTag.jsp" />

</body>

</html>
