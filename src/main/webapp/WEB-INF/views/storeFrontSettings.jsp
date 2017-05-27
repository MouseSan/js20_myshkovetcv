<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Storefront settings</title>
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
            <h1 class="page-title">Storefront settings</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">
            <form:form method="POST" modelAttribute="storefrontSettingsDto" class="form-horizontal" role="form" id="storefront-form">
                <form:input type="hidden" path="id" id="id"/>
                <div class="row">
                    <div class="col-md-12">
                        <c:if test="${param.saved != null}">
                            <div class="alert alert-success">
                                <p>Settings saved successfully.</p>
                            </div>
                        </c:if>
                        <div class="delivery-method">
                            <c:choose>
                                <c:when test="${storefrontSettingsDto.storefrontType == 'TopTenProducts'}">
                                    <label class="fancy-radio delivery-option option-express-delivery">
                                        <input type="radio" name="storefrontType" id="radio-top-ten" value="TopTenProducts" checked>
                                        <span><i></i> <span><i class="fa fa-truck"></i> Top ten products</span></span>
                                    </label>
                                    <div class="top-ten-box">
                                        <div class="row">
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
                                                                    <a href="#" class="product-title">${soldProduct.productDto.name}</a>
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
                                </c:when>
                                <c:otherwise>
                                    <label class="fancy-radio delivery-option option-express-delivery">
                                        <input type="radio" name="storefrontType" id="radio-top-ten" value="TopTenProducts">
                                        <span><i></i> <span><i class="fa fa-truck"></i> Top ten products</span></span>
                                    </label>
                                    <div class="top-ten-box hide-first">
                                        <div class="row">
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
                                                                    <a href="#" class="product-title">${soldProduct.productDto.name}</a>
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
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${storefrontSettingsDto.storefrontType == 'TopTenProducts'}">
                                    <label class="fancy-radio delivery-option option-self-pickup">
                                        <input type="radio" name="storefrontType" id="radio-custom-list" value="CustomList">
                                        <span><i></i> <span><i class="fa fa-child"></i> Custom list</span></span>
                                    </label>
                                    <div class="custom-list-box hide-first">
                                        <div class="row">
                                            <table class="table shopping-cart-table">
                                                <thead>
                                                <tr>
                                                    <th>Product</th>
                                                    <th>Parameters</th>
                                                    <th width="100"></th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${storefrontProductsList}" var="product">
                                                    <tr>
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
                                                                    <a href="#" class="product-title">${product.name}</a>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td class="item-parameters">
                                                            <div class="media">
                                                                <div class="media-body">
                                                                    <a href="#" class="product-title"></a>
                                                                    <span class="brief-desc">Brand: ${product.brandDto.name}, Backlight: ${product.backlight}, Clock face: ${product.clockFace}, Glass: ${product.glass}, Gender: ${product.gender}, Water resistant: ${product.waterResistant}.</span>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <button class="btn btn-rounded-2x btn-primary btn-block removeFromCustomStorefrontList"
                                                                    type="button" name="Button"
                                                                    value="${product.id}">Remove
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <label class="fancy-radio delivery-option option-self-pickup">
                                        <input type="radio" name="storefrontType" id="radio-custom-list" value="CustomList" checked>
                                        <span><i></i> <span><i class="fa fa-child"></i> Custom list</span></span>
                                    </label>
                                    <div class="custom-list-box">
                                        <div class="row">
                                            <table class="table shopping-cart-table">
                                                <thead>
                                                <tr>
                                                    <th>Product</th>
                                                    <th>Parameters</th>
                                                    <th width="100"></th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${storefrontProductsList}" var="product">
                                                    <tr>
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
                                                                    <a href="#" class="product-title">${product.name}</a>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td class="item-parameters">
                                                            <div class="media">
                                                                <div class="media-body">
                                                                    <a href="#" class="product-title"></a>
                                                                    <span class="brief-desc">Brand: ${product.brandDto.name}, Backlight: ${product.backlight}, Clock face: ${product.clockFace}, Glass: ${product.glass}, Gender: ${product.gender}, Water resistant: ${product.waterResistant}.</span>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <button class="btn btn-rounded-2x btn-primary btn-block removeFromCustomStorefrontList"
                                                                    type="button" name="Button"
                                                                    value="${product.id}">Remove
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <div class="row row-bottom-padding">
                    <div class="col-sm-offset-4 col-sm-4">
                        <button type="submit" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg" >Save</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <!-- END MAIN -->

    <!-- FOOTER -->
    <c:import url="common/footer.jsp" />
    <!-- END FOOTER -->

</div>
<!-- END WRAPPER -->

<%--<c:import url="common/scriptsTag.jsp" />--%>
<%--<script src="<c:url value='/static/js/plugins/fuelux-wizard/wizard.js' />"></script>--%>
<%--<script src="<c:url value='/static/js/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.min.js' />"></script>--%>

<script src="<c:url value='/static/js/jquery-2.1.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/autohidingnavbar/jquery.bootstrap-autohidingnavbar.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/parsley-validation/parsley.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/fuelux-wizard/wizard.js' />"></script>
<script src="<c:url value='/static/js/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.min.js' />"></script>
<script src="<c:url value='/static/js/repute-scripts.js' />"></script>
<script src="<c:url value='/static/js/repute-shop.js' />"></script>
<script src="<c:url value='/static/js/cart.js' />"></script>
<script src="<c:url value='/static/js/removeFromStorefront.js' />"></script>


</body>
</html>
