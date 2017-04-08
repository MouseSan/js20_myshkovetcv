<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>${title}</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/static/bootstrap/dist/css/bootstrap.min.css' />"
          rel="stylesheet"></link>

</head>

<body>

<c:import url="common/MainNavigation.jsp"/>

<div class="container theme-showcase" role="main">

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Products </span></div>
                <table class="table table-hover product-list-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th width="100">Weight</th>
                        <th width="100">Volume</th>
                        <th width="100">Stock</th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ProductList}" var="product" varStatus="productListCount">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.category.name}</td>
                            <td>${product.weight}</td>
                            <td>${product.volume}</td>
                            <td>${product.stock}</td>
                            <td><a href="<c:url value='/edit-product-${product.id}' />"
                                   class="btn btn-success custom-width">edit</a></td>
                            <td>
                                <button class="btn btn-danger addToCard"
                                        type="button"
                                        name="Button"
                                        value="${productListCount.index}"
                                        id="btn-${productListCount.index}">
                                    <span class="glyphicon glyphicon-plus"></span>
                                </button>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<c:import url="common/scripts.jsp"/>

</body>
</html>