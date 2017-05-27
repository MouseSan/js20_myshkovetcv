<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Product management</title>
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
            <h1 class="page-title">Product management</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">

            <form:form method="POST" modelAttribute="productDto" class="form-horizontal" role="form" enctype="multipart/form-data">
                <form:input type="hidden" path="id" id="id"/>
                <form:input type="hidden" path="imageId" id="imageId"/>
                <form:input type="hidden" path="imageURL" id="imageURL"/>
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
                    <label class="col-sm-3 control-label">Backlight</label>
                    <div class="col-sm-9">
                        <label class="switch-input" for="backlight">
                            <c:choose>
                                <c:when test="${productDto.backlight}">
                                    <input type="checkbox" name="backlight" id="backlight" checked>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="backlight" id="backlight">
                                </c:otherwise>
                            </c:choose>
                            <i data-swon-text="YES" data-swoff-text="NO"></i>
                        </label>
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
                <c:choose>
                    <c:when test="${product.imageId == null || product.imageId.isEmpty()}">
                    </c:when>
                    <c:otherwise>
                        <div class="form-group form-group-lg">
                            <label for="image-url" class="col-sm-3 control-label">Current image</label>
                            <div class="col-sm-9">
                                <img src="<c:url value="http://res.cloudinary.com/mousesan/image/upload/w_300,h_300,c_pad,b_rgb:FFFFFF/${product.imageId}.png"/>" class="img-responsive center-block" alt="Product image" id="image-url">
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
                <div class="form-group form-group-lg">
                    <c:choose>
                        <c:when test="${product.imageId == null || product.imageId.isEmpty()}">
                            <label for="multipartFile" class="col-sm-3 control-label">Image</label>
                        </c:when>
                        <c:otherwise>
                            <label for="multipartFile" class="col-sm-3 control-label">Replacing image</label>
                        </c:otherwise>
                    </c:choose>
                    <div class="col-sm-9">
                        <input type="file" accept=".png" name="multipartFile" id="multipartFile" class="form-control"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="multipartFile" class="help-inline-lg"/>
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
<c:import url="common/scriptsTag.jsp" />

</body>

</html>
