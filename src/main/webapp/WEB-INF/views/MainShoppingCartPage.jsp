<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>${title}</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/static/bootstrap/dist/css/bootstrap.min.css' />" rel="stylesheet"/>

</head>

<body>

<c:import url="common/MainNavigation.jsp">

    <c:param name="categoryList" value="${categoryList}"/>
    <c:param name="quantityInCart" value="${quantityInCart}"/>
</c:import>

<div class="container theme-showcase" role="main">

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default" id="cartTable">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Products </span></div>
                <table class="table table-hover product-list-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th width="100">Weight</th>
                        <th width="100">Volume</th>
                        <th width="150">Price</th>
                        <th width="150">Quantity</th>
                        <th width="150"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${productMap}" var="product" varStatus="productListCount">
                        <tr>
                            <td>${product.key.id}</td>
                            <td>${product.key.name}</td>
                            <td>${product.key.weight}</td>
                            <td>${product.key.volume}</td>
                            <td>${product.key.price}</td>
                            <td>${product.value}</td>
                            <td>
                                <button class="btn btn-danger removeFromCart"
                                        type="button"
                                        name="Button"
                                        value="${product.key.id}"
                                        id="btn-${productListCount.index}">
                                    <span class="glyphicon glyphicon-minus"></span>
                                </button>
                            </td>

                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><b>Total</b></td>
                        <td><b>${quantityInCart}</b></td>
                        <td><b>${totalPrice}</b></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <a href="<c:url value='/orders/create' />" class="btn btn-primary">Checkout</a>
        </div>
    </div>


</div>

<c:import url="common/scripts.jsp"/>

<script src="<c:url value='/static/cart.js' />"></script>

</body>
</html>