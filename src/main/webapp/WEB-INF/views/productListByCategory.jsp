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
                            <div class="form-group">
                                <%--<label for="brandDto" class="control-label sr-only">Brand</label>--%>
                                <form:select type="text" path="brandDto" id="brandDto" class="form-control">
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
                            <div class="form-group">
                                <%--<label for="backlight" class="control-label sr-only">Backlight</label>--%>
                                <form:checkbox path="backlight" id="backlight"/>
                            </div>
                            <div class="form-group">
                                <%--<label for="clockFace" class="control-label sr-only">Name</label>--%>
                                <form:select type="text" path="clockFace" id="clockFace" class="form-control">
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
                            <div class="form-group">
                                <%--<label for="glass" class="control-label sr-only">Name</label>--%>
                                <form:select type="text" path="glass" id="glass" class="form-control">
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
                            <div class="form-group">
                                <%--<label for="gender" class="control-label sr-only">Name</label>--%>
                                <form:select type="text" path="gender" id="gender" class="form-control">
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
                            <div class="form-group">
                                <%--<label for="waterResistant" class="control-label sr-only">Name</label>--%>
                                <form:select type="text" path="waterResistant" id="waterResistant" class="form-control">
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
                            <button type="submit" class="btn btn-shop-filter btn-block btn-lg" >Filter</button>
                        </form:form>
                        <%--<div class="filter-item">--%>
                            <%--<h3>FILTER BY CATEGORY</h3>--%>
                            <%--<ul class="list-unstyled">--%>
                                <%--<li><a href="#">Women's Fahsion</a> <span>(40)</span></li>--%>
                                <%--<li><a href="#">Men's Fashion</a> <span>(30)</span></li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                        <%--<div class="filter-item">--%>
                            <%--<h3>FILTER BY BRAND</h3>--%>
                            <%--<ul class="list-unstyled">--%>
                                <%--<li><a href="#">Beauty Fashion</a> <span>(22)</span></li>--%>
                                <%--<li><a href="#">ManOnly</a> <span>(30)</span></li>--%>
                                <%--<li><a href="#">J Apparel</a> <span>(18)</span></li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                        <%--<div class="filter-item">--%>
                            <%--<h3>FILTER BY PRICE</h3>--%>
                            <%--<input type="text" class="input-range" name="price-range" value="">--%>
                        <%--</div>--%>
                    </section>
                    <%--<a class="btn btn-shop-filter btn-block btn-lg" href="<c:url value='/category/${categoryName}' />" >Filter</a>--%>
                    <!-- END FILTERS -->
                </div>
                <div class="col-md-9">
                    <!-- PRODUCT GRID -->
                    <section class="product-grid">
                        <div class="row">
                            <c:forEach items="${productList}" var="product" varStatus="productListCount">
                                <div class="col-lg-4 col-sm-6">
                                    <div class="product-item">
                                        <a href="single-product-page.html"><img src="<c:url value='/static/img/products/wfashion1.png' />" class="img-responsive center-block" alt="Product Item"></a>
                                        <div class="info">
                                            <h3 class="title"><a href="single-product-page.html" title="${product.name}">${product.name}</a></h3>
                                            <div class="price"><strong>$${product.price}</strong></div>
                                        </div>
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
<script src="<c:url value='/static/js/jquery-2.1.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/bootstrap-multiselect/bootstrap-multiselect.js' />"></script>
<script src="<c:url value='/static/js/plugins/range-slider/ion.rangeSlider.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/slick/slick.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/autohidingnavbar/jquery.bootstrap-autohidingnavbar.min.js' />"></script>
<script src="<c:url value='/static/js/repute-scripts.js' />"></script>
<script src="<c:url value='/static/js/repute-shop.js' />"></script>

</body>

</html>
