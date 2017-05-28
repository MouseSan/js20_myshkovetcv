<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - ${productDto.name}</title>
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
            <h1 class="page-title">${productDto.name}</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">
            <!-- SINGLE PRODUCT -->
            <div class="single-product">
                <div class="row">
                    <!-- PRODUCT GALLERY -->
                    <div class="col-md-4">
                        <c:choose>
                            <c:when test="${productDto.imageId == null || productDto.imageId.isEmpty()}">
                                <img src="<c:url value='/static/img/big-product-plug.png' />" class="img-responsive center-block" alt="Product Item">
                            </c:when>
                            <c:otherwise>
                                <img src="<c:url value='http://res.cloudinary.com/mousesan/image/upload/w_400,h_400,c_pad,b_rgb:FFFFFF/${productDto.imageId}.png' />" class="img-responsive center-block" alt="Product image">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <!-- END PRODUCT GALLERY -->
                    <!-- PRODUCT INFO -->
                    <div class="col-md-8">
                        <div class="row product-price">
                            <div class="col-sm-4">
                                <span class="current-price">$${productDto.price}</span>
                            </div>
                            <div class="col-sm-offset-4 col-sm-4">
                                <c:choose>
                                    <c:when test="${productDto.stock > 0}">
                                        <button class="btn btn-primary btn-add-to-cart btn-block addToCart" type="button" name="Button" value="${productDto.id}">ADD TO <i class="fa fa-shopping-cart"></i></button>
                                        <div class="product-availability">
                                            <span class="stock-indicator available">
                                                <i class="fa fa-check"></i> AVAILABLE  ${productDto.stock}
                                            </span>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn btn-default btn-add-to-cart btn-block disabled" type="button" name="Button" value="${productDto.id}">ADD TO <i class="fa fa-shopping-cart"></i></button>
                                        <div class="product-availability">
                                            <span class="stock-indicator unavailable">
                                                <i class="fa fa-close"></i> Out of Stock
                                            </span>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <hr class="parameter-line" align="center" size="2"/>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p class="parameter">
                                            <span class="parameter-name">Brand: </span>
                                            ${productDto.brandDto.name}
                                        </p>
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="parameter">
                                            <span class="parameter-name">Water resistant: </span>
                                            ${productDto.waterResistant}
                                        </p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p class="parameter">
                                            <span class="parameter-name">Clock face: </span>
                                            ${productDto.clockFace}
                                        </p>
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="parameter">
                                            <span class="parameter-name">Backlight: </span>
                                            <c:choose>
                                                <c:when test="${productDto.backlight}">
                                                    YES
                                                </c:when>
                                                <c:otherwise>
                                                    NO
                                                </c:otherwise>
                                            </c:choose>
                                        </p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p class="parameter">
                                            <span class="parameter-name">Glass: </span>
                                            ${productDto.glass}
                                        </p>
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="parameter">
                                            <span class="parameter-name">Weight: </span>
                                            ${productDto.weight}
                                        </p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p class="parameter">
                                            <span class="parameter-name">Gender: </span>
                                            ${productDto.gender}
                                        </p>
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="parameter">
                                            <span class="parameter-name">Volume: </span>
                                            ${productDto.volume}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END PRODUCT INFO -->
                </div>
                <hr class="parameter-line" align="center" size="2"/>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="product-brief-description">
                            <p>${productDto.description}</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END SINGLE PRODUCT -->
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
<script src="<c:url value='/static/js/productList.js' />"></script>

</body>

</html>
