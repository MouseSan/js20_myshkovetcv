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
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover product-list-table" id="addressTable">
                        <thead>
                        <tr>
                            <th width="100">ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Category</th>
                            <th>Weight</th>
                            <th>Volume</th>
                            <th>Stock</th>
                            <th>Brand</th>
                            <th>Backlight</th>
                            <th>Clock face</th>
                            <th>Glass</th>
                            <th>Gender</th>
                            <th>Water resistant</th>
                            <th width="100"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${productList}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>${product.categoryDto.name}</td>
                                <td>${product.weight}</td>
                                <td>${product.volume}</td>
                                <td>${product.stock}</td>
                                <td>${product.brandDto.name}</td>
                                <td>${product.backlight}</td>
                                <td>${product.clockFace}</td>
                                <td>${product.glass}</td>
                                <td>${product.gender}</td>
                                <td>${product.waterResistant}</td>
                                <td>
                                    <a href="<c:url value='/admin/products/edit-${product.id}' />" class="btn btn-rounded-2x btn-primary btn-block">Edit</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="custom-button-box">
                <a href="<c:url value='/admin/products/create' />" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg">Create</a>
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
