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

    <title>Shop Shoe - Product management</title>

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
            <h1 class="page-title">Product management</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">

            <form:form method="POST" modelAttribute="productDto" class="form-horizontal" role="form">
                <form:input type="hidden" path="id" id="id"/>
                <div class="form-group form-group-lg">
                    <label for="name" class="col-sm-3 control-label">Name</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="name" id="name" class="form-control"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="name" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="price" class="col-sm-3 control-label">Price</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="price" id="price" class="form-control"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="price" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="categoryDto" class="col-sm-3 control-label">Category</label>
                    <div class="col-sm-9">
                        <form:select type="text" path="categoryDto" id="categoryDto" class="form-control">
                            <c:forEach var="category" items="${categoryList}">
                                <c:choose>
                                    <c:when test="${productDto.categoryDto.id == category.id}">
                                        <form:option value="${category.id}" label="${category.name}" selected="true"/>
                                    </c:when>
                                    <c:otherwise>
                                        <form:option value="${category.id}" label="${category.name}"/>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="weight" class="col-sm-3 control-label">Weight</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="weight" id="weight" class="form-control"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="weight" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="volume" class="col-sm-3 control-label">Volume</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="volume" id="volume" class="form-control"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="volume" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="stock" class="col-sm-3 control-label">Stock</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="stock" id="stock" class="form-control"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="stock" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="brandDto" class="col-sm-3 control-label">Brand</label>
                    <div class="col-sm-9">
                        <form:select type="text" path="brandDto" id="brandDto" class="form-control">
                            <c:forEach var="brand" items="${brandList}">
                                <c:choose>
                                    <c:when test="${productDto.brandDto.id == brand.id}">
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
                <div class="form-group form-group-lg">
                    <label for="backlight" class="col-sm-3 control-label">Backlight</label>
                    <div class="col-sm-9 custom-checkbox">
                        <form:checkbox path="backlight" id="backlight"/>
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label for="clockFace" class="col-sm-3 control-label">Clock face</label>
                    <div class="col-sm-9">
                        <form:select type="text" path="clockFace" id="clockFace" class="form-control">
                            <c:forEach var="clockFaceType" items="${clockFaceList}">
                                <c:choose>
                                    <c:when test="${productDto.clockFace == clockFaceType}">
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
                <div class="form-group form-group-lg">
                    <label for="glass" class="col-sm-3 control-label">Glass</label>
                    <div class="col-sm-9">
                        <form:select type="text" path="glass" id="glass" class="form-control">
                            <c:forEach var="glassType" items="${glassList}">
                                <c:choose>
                                    <c:when test="${productDto.glass == glassType}">
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
                <div class="form-group form-group-lg">
                    <label for="gender" class="col-sm-3 control-label">Gender</label>
                    <div class="col-sm-9">
                        <form:select type="text" path="gender" id="gender" class="form-control">
                            <c:forEach var="genderType" items="${genderList}">
                                <c:choose>
                                    <c:when test="${productDto.gender == genderType}">
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
                <div class="form-group form-group-lg">
                    <label for="waterResistant" class="col-sm-3 control-label">Water resistant</label>
                    <div class="col-sm-9">
                        <form:select type="text" path="waterResistant" id="waterResistant" class="form-control">
                            <c:forEach var="waterResistantType" items="${waterResistantList}">
                                <c:choose>
                                    <c:when test="${productDto.waterResistant == waterResistantType}">
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
                <div class="form-group form-group-lg">
                    <label for="description" class="col-sm-3 control-label">Description</label>
                    <div class="col-sm-9">
                        <form:textarea type="text" path="description" id="description" class="form-control"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="description" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <div class="row row-bottom-padding">
                    <div class="col-sm-offset-3 col-sm-3">
                        <button type="submit" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg" >Save</button>
                    </div>
                    <div class="col-sm-3">
                        <a class="btn btn-rounded-2x btn-outline btn-danger btn-block btn-lg" href="<c:url value='/admin/products/' />" >Cancel</a>
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
<!-- JAVASCRIPTS -->
<script src="<c:url value='/static/js/jquery-2.1.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/autohidingnavbar/jquery.bootstrap-autohidingnavbar.min.js' />"></script>
<script src="<c:url value='/static/js/repute-scripts.js' />"></script>
<script src="<c:url value='/static/js/repute-shop.js' />"></script>

</body>

</html>
