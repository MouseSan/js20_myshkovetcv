<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive Multipurpose Bootstrap Theme">
    <meta name="author" content="MyshkovetcVV">

    <title>Shop Shoe - Category management</title>

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
    <c:import url="common/navBar.jsp">
        <c:param name="categoryList" value="${categoryList}"/>
        <c:param name="quantityInCart" value="${quantityInCart}"/>
    </c:import>
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
                        <div id="product-images" class="carousel slide product-images" data-ride="carousel" data-interval="false">
                            <div class="carousel-inner">
                                <div class="item active">
                                    <a href="assets/img/products/single-product/single-product1.png" rel="gallery[pp_gal]"><img src="assets/img/products/single-product/single-product1.png" class="img-responsive" alt="Product Image"></a>
                                </div>
                                <div class="item">
                                    <a href="assets/img/products/single-product/single-product2.png" rel="gallery[pp_gal]"><img src="assets/img/products/single-product/single-product2.png" class="img-responsive" alt="Product Image"></a>
                                </div>
                                <div class="item">
                                    <a href="assets/img/products/single-product/single-product3.png" rel="gallery[pp_gal]"><img src="assets/img/products/single-product/single-product3.png" class="img-responsive" alt="Product Image"></a>
                                </div>
                                <div class="item">
                                    <a href="assets/img/products/single-product/single-product4.png" rel="gallery[pp_gal]"><img src="assets/img/products/single-product/single-product4.png" class="img-responsive" alt="Product Image"></a>
                                </div>
                                <div class="item">
                                    <a href="assets/img/products/single-product/single-product5.png" rel="gallery[pp_gal]"><img src="assets/img/products/single-product/single-product5.png" class="img-responsive" alt="Product Image"></a>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div id="product-image-thumbnails" class="carousel slide product-image-thumbnails" data-interval="false">
                            <div class="carousel-inner">
                                <div class="item active">
                                    <div data-target="#product-images" data-slide-to="0" class="thumb"><img src="assets/img/products/single-product/single-product1-thumb.png" alt="Product Image"></div>
                                    <div data-target="#product-images" data-slide-to="1" class="thumb"><img src="assets/img/products/single-product/single-product2-thumb.png" alt="Product Image"></div>
                                    <div data-target="#product-images" data-slide-to="2" class="thumb"><img src="assets/img/products/single-product/single-product3-thumb.png" alt="Product Image"></div>
                                    <div data-target="#product-images" data-slide-to="3" class="thumb"><img src="assets/img/products/single-product/single-product4-thumb.png" alt="Product Image"></div>
                                </div>
                                <div class="item">
                                    <div data-target="#product-images" data-slide-to="4" class="thumb"><img src="assets/img/products/single-product/single-product5-thumb.png" alt="Product Image"></div>
                                    <div data-target="#product-images" data-slide-to="3" class="thumb"><img src="assets/img/products/single-product/single-product4-thumb.png" alt="Product Image"></div>
                                    <div data-target="#product-images" data-slide-to="2" class="thumb"><img src="assets/img/products/single-product/single-product3-thumb.png" alt="Product Image"></div>
                                    <div data-target="#product-images" data-slide-to="1" class="thumb"><img src="assets/img/products/single-product/single-product2-thumb.png" alt="Product Image"></div>
                                </div>
                            </div>
                            <a href="#product-image-thumbnails" class="left carousel-control" data-role="button" data-slide="prev">
                                <i class="fa fa-chevron-left"></i>
                            </a>
                            <a href="#product-image-thumbnails" class="right carousel-control" data-role="button" data-slide="next">
                                <i class="fa fa-chevron-right"></i>
                            </a>
                        </div>
                    </div>
                    <!-- END PRODUCT GALLERY -->
                    <!-- PRODUCT INFO -->
                    <div class="col-md-8">
                        <section class="product-info no-margin">
                            <div class="product-price">
                                <span class="current-price">$${productDto.price}</span>
                            </div>
                            <div class="product-brief-description">
                                <p>${productDto.description}</p>
                            </div>
                            <form id="product-single-form" action="#" class="form-inline" role="form">
                                <div class="row">
                                    <div class="col-sm-4">
                                        <div class="product-variance">
                                            <div class="variance-item">
                                                <div class="form-group form-group-sm">
                                                    <label class="control-label">Brand: </label>
                                                    <p class="form-control-static">${productDto.brandDto.name}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-variance">
                                            <div class="variance-item">
                                                <div class="form-group form-group-sm">
                                                    <label class="control-label">Backlight: </label>
                                                    <c:choose>
                                                        <c:when test="${productDto.backlight}">
                                                            <p class="form-control-static">Yes</p>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <p class="form-control-static">No</p>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-variance">
                                            <div class="variance-item">
                                                <div class="form-group form-group-sm">
                                                    <label class="control-label">Clock face: </label>
                                                    <p class="form-control-static">${productDto.clockFace}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-variance">
                                            <div class="variance-item">
                                                <div class="form-group form-group-sm">
                                                    <label class="control-label">Glass: </label>
                                                    <p class="form-control-static">${productDto.glass}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-variance">
                                            <div class="variance-item">
                                                <div class="form-group form-group-sm">
                                                    <label class="control-label">Gender: </label>
                                                    <p class="form-control-static">${productDto.gender}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-variance">
                                            <div class="variance-item">
                                                <div class="form-group form-group-sm">
                                                    <label class="control-label">Water resistant: </label>
                                                    <p class="form-control-static">${productDto.waterResistant}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-variance">
                                            <div class="variance-item">
                                                <div class="form-group form-group-sm">
                                                    <label class="control-label">Weight: </label>
                                                    <p class="form-control-static">${productDto.weight}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-variance">
                                            <div class="variance-item">
                                                <div class="form-group form-group-sm">
                                                    <label class="control-label">Volume: </label>
                                                    <p class="form-control-static">${productDto.volume}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group form-group-sm">
                                            <label class="control-label">Quantity:</label>
                                            <input type="number" class="form-control" min="1" max="${productDto.stock}" value="1" required>
                                        </div>
                                        <div class="product-availability">
                                            <strong>Stock:</strong>
                                            <c:choose>
                                                <c:when test="${productDto.stock > 0}">
                                                    <span class="stock-indicator available">
                                                    <i class="fa fa-check"></i> Available ${productDto.stock}
                                                    </span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="stock-indicator unavailable hide">
                                                    <i class="fa fa-close"></i> Out of Stock
                                                    </span>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <a href="checkout.html" class="btn btn-primary btn-add-to-cart"><i class="fa fa-cart-plus"></i> Add to cart</a>
                                        <br>
                                    </div>
                                </div>
                            </form>
                        </section>
                    </div>
                    <!-- END PRODUCT INFO -->
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
<script src="<c:url value='/static/js/jquery-2.1.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/autohidingnavbar/jquery.bootstrap-autohidingnavbar.min.js' />"></script>
<script src="<c:url value='/static/js/repute-scripts.js' />"></script>
<script src="<c:url value='/static/js/repute-shop.js' />"></script>

</body>

</html>
