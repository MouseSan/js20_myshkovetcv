<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Product list</title>
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
            <h1 class="page-title">Product list</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">
            <div class="custom-button-box">
                <a href="<c:url value='/admin/products/create' />" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg">Create</a>
            </div>
            <div class="row">
                <div class="col-md-12">

                    <table class="table shopping-cart-table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Category</th>
                            <th>Name</th>
                            <th>Parameters</th>
                            <th>Weight</th>
                            <th>Volume</th>
                            <th>Stock</th>
                            <th>Price</th>
                            <th width="100"></th>
                            <th width="100"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${productList}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.categoryDto.name}</td>
                                <td class="item-image">
                                    <div class="media">
										<span class="media-left">
                                            <c:choose>
                                                <c:when test="${product.imageId == null || product.imageId.isEmpty()}">
                                                    <img src="<c:url value='/static/img/small-product-plug.png' />" class="product-image" alt="Product Image">
                                                </c:when>
                                                <c:otherwise>
                                                    <img src="<c:url value='http://res.cloudinary.com/mousesan/image/upload/w_75,h_75,c_pad,b_rgb:FFFFFF/${product.imageId}.png' />" class="product-image" alt="Product Image">
                                                </c:otherwise>
                                            </c:choose>
										</span>
                                        <div class="media-body">
                                            <a href="<c:url value='/products/${product.id}' />" class="product-title">${product.name}</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="item-parameters">
                                    <div class="media">
                                        <div class="media-body">
                                            <a href="<c:url value='/products/${product.id}' />" class="product-title"></a>
                                            <span class="brief-desc">Brand: ${product.brandDto.name}, Backlight: ${product.backlight}, Clock face: ${product.clockFace}, Glass: ${product.glass}, Gender: ${product.gender}, Water resistant: ${product.waterResistant}.</span>
                                        </div>
                                    </div>
                                </td>
                                <td class="qty">${product.weight}</td>
                                <td class="qty">${product.volume}</td>
                                <td class="qty">${product.stock}</td>
                                <td class="unit-price">${product.price}</td>
                                <td>
                                    <a href="<c:url value='/admin/products/edit-${product.id}' />" class="btn btn-rounded-2x btn-primary btn-block">Edit</a>
                                </td>
                                <td>
                                    <button class="btn btn-rounded-2x btn-primary btn-block addToCustomStorefrontList"
                                            type="button" name="Button"
                                            value="${product.id}">Add to storefront
                                    </button>
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
<script src="<c:url value='/static/js/addToStoreFront.js' />"></script>

</body>

</html>
