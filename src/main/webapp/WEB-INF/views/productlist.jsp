<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<c:import url="common/headtag.jsp">
    <c:param name="title" value="${title}"/>
</c:import>

<body>

<c:import url="common/header.jsp"/>

<div class="container theme-showcase" role="main">

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Products </span></div>
                <table class="table table-hover">
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
                    <c:forEach items="${productList}" var="product">
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
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="well">
                <a href="<c:url value='/newproduct' />">Add New Product</a>
            </div>
        </div>
    </div>
</div>

<c:import url="common/scripts.jsp"/>

</body>
</html>