<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Catalog</title>
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
            <h1 class="page-title">Catalog</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">
            <!-- SEARCH RESULT AND FILTER -->
            <div class="row">
                <div class="col-md-3">
                    <!-- FILTERS -->
                    <section class="filters">
                        <form:form method="GET" modelAttribute="filterDto" class="form-horizontal" role="form">
                            <div class="filter-item">
                                <h3>SORT BY</h3>
                                <div class="custom-form-group">
                                    <form:select type="text" path="sorting" id="sorting" class="form-control">
                                        <c:choose>
                                            <c:when test="${filterDto.sorting == 'highPrice'}">
                                                <form:option value="lowPrice" label="Low price"/>
                                                <form:option value="highPrice" label="High price" selectrd="true"/>
                                                <form:option value="nameAsc" label="Name A-Z"/>
                                                <form:option value="nameDesc" label="Name Z-A"/>
                                            </c:when>
                                            <c:when test="${filterDto.backlight == 'nameAsc'}">
                                                <form:option value="lowPrice" label="Low price"/>
                                                <form:option value="highPrice" label="High price"/>
                                                <form:option value="nameAsc" label="Name A-Z" selectrd="true"/>
                                                <form:option value="nameDesc" label="Name Z-A"/>
                                            </c:when>
                                            <c:when test="${filterDto.backlight == 'nameDesc'}">
                                                <form:option value="lowPrice" label="Low price"/>
                                                <form:option value="highPrice" label="High price"/>
                                                <form:option value="nameAsc" label="Name A-Z"/>
                                                <form:option value="nameDesc" label="Name Z-A" selectrd="true"/>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="lowPrice" label="Low price" selectrd="true"/>
                                                <form:option value="highPrice" label="High price"/>
                                                <form:option value="nameAsc" label="Name A-Z"/>
                                                <form:option value="nameDesc" label="Name Z-A"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </form:select>
                                </div>
                            </div>
                            <div class="filter-item">
                                <h3>Brand</h3>
                                <div class="custom-form-group">
                                    <form:select type="text" path="brandDto" id="brandDto" class="form-control">
                                        <option value="any">--All brands--</option>
                                        <c:forEach var="brand" items="${brandList}">
                                            <c:choose>
                                                <c:when test="${filterDto.brandDto.id == brand.id}">
                                                    <form:option value="${brand.id}" label="${brand.name}" selected="true"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:option value="${brand.id}" label="${brand.name}"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="filter-item">
                                <h3>Clock face</h3>
                                <div class="custom-form-group">
                                    <form:select type="text" path="clockFace" id="clockFace" class="form-control">
                                        <option value="any">--Any--</option>
                                        <c:forEach var="clockFaceType" items="${clockFaceList}">
                                            <c:choose>
                                                <c:when test="${filterDto.clockFace == clockFaceType}">
                                                    <form:option value="${clockFaceType}" label="${clockFaceType}" selected="true"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:option value="${clockFaceType}" label="${clockFaceType}"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="filter-item">
                                <h3>Glass</h3>
                                <div class="custom-form-group">
                                    <form:select type="text" path="glass" id="glass" class="form-control">
                                        <option value="any">--Any--</option>
                                        <c:forEach var="glassType" items="${glassList}">
                                            <c:choose>
                                                <c:when test="${filterDto.glass == glassType}">
                                                    <form:option value="${glassType}" label="${glassType}" selected="true"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:option value="${glassType}" label="${glassType}"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="filter-item">
                                <h3>Gender</h3>
                                <div class="custom-form-group">
                                    <form:select type="text" path="gender" id="gender" class="form-control">
                                        <option value="any">--Any--</option>
                                        <c:forEach var="genderType" items="${genderList}">
                                            <c:choose>
                                                <c:when test="${filterDto.gender == genderType}">
                                                    <form:option value="${genderType}" label="${genderType}" selected="true"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:option value="${genderType}" label="${genderType}"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="filter-item">
                                <h3>Water Resistant</h3>
                                <div class="custom-form-group">
                                    <form:select type="text" path="waterResistant" id="waterResistant" class="form-control">
                                        <option value="any">--Any--</option>
                                        <c:forEach var="waterResistantType" items="${waterResistantList}">
                                            <c:choose>
                                                <c:when test="${filterDto.waterResistant == waterResistantType}">
                                                    <form:option value="${waterResistantType}" label="${waterResistantType}" selected="true"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:option value="${waterResistantType}" label="${waterResistantType}"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="filter-item">
                                <h3>Backlight</h3>
                                <div class="custom-form-group">
                                    <form:select type="text" path="backlight" id="backlight" class="form-control">
                                        <c:choose>
                                            <c:when test="${filterDto.backlight == true}">
                                                <form:option value="any" label="--Any--"/>
                                                <form:option value="true" label="With backlight" selectrd="true"/>
                                                <form:option value="false" label="Without backlight"/>
                                            </c:when>
                                            <c:when test="${filterDto.backlight == false}">
                                                <form:option value="any" label="--Any--"/>
                                                <form:option value="true" label="With backlight"/>
                                                <form:option value="false" label="Without backlight" selectrd="true"/>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="any" label="--Any--" selectrd="true"/>
                                                <form:option value="true" label="With backlight"/>
                                                <form:option value="false" label="Without backlight"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </form:select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-shop-filter btn-block btn-lg" >Filter</button>
                        </form:form>
                    </section>
                    <!-- END FILTERS -->
                </div>
                <div class="col-md-9">
                    <!-- PRODUCT GRID -->
                    <section class="product-grid">
                        <div class="row">
                            <sec:authorize access="hasRole('ADMIN')" var="admin"/>
                            <c:forEach items="${productList}" var="product" varStatus="productListCount">
                                <div class="col-lg-4 col-sm-6">
                                    <div class="product-item">
                                        <a href="<c:url value='/products/${product.id}' />">
                                            <c:choose>
                                                <c:when test="${product.imageId == null || product.imageId.isEmpty()}">
                                                    <img src="<c:url value='/static/img/big-product-plug.png' />" class="img-responsive center-block" alt="Product Item">
                                                </c:when>
                                                <c:otherwise>
                                                    <img src="<c:url value='http://res.cloudinary.com/mousesan/image/upload/w_300,h_300,c_pad,b_rgb:FFFFFF/${product.imageId}.png' />" class="img-responsive center-block" alt="Product image">
                                                </c:otherwise>
                                            </c:choose>
                                        </a>
                                        <c:choose>
                                            <c:when test="${admin}">
                                                <div class="row">
                                                    <div class="col-sm-5">
                                                        <div class="info">
                                                            <h3 class="title">
                                                                <a>${product.name}</a>
                                                            </h3>
                                                            <div class="price">
                                                                <strong>$${product.price}</strong>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-7">
                                                        <div class="info-btn-group">
                                                            <a href="<c:url value='/admin/products/edit-${product.id}' />" class="btn btn-warning"><i class="fa fa-pencil"></i></a>
                                                            <button class="btn btn-primary addToCart" type="button" name="Button" value="${product.id}">ADD TO <i class="fa fa-shopping-cart"></i></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="row">
                                                    <div class="col-sm-7">
                                                        <div class="info">
                                                            <h3 class="title">
                                                                <a>${product.name}</a>
                                                            </h3>
                                                            <div class="price">
                                                                <strong>$${product.price}</strong>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="info-btn-group">
                                                            <button class="btn btn-primary addToCart" type="button" name="Button" value="${product.id}">ADD TO <i class="fa fa-shopping-cart"></i></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <br>
                    </section>
                    <!-- END PRODUCT GRID -->
                </div>
            </div>
            <!-- END SEARCH RESULT AND FILTER -->
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
