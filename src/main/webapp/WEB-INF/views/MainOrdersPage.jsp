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


    <div class="row" id="errMsg">
        <div class="col-md-12">
            <c:if test="${param.enoughquantity != null}">
                <div class="alert alert-danger">
                    <p>Not enough quantity in stock to repeat order.</p>
                </div>
            </c:if>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">

            <span class="lead">${title}</span>

            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">ID</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${order.id}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Delivery address</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${order.deliveryAddress}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Payment method</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${order.paymentMethod}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Delivery method</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${order.deliveryMethod}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Payment state</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${order.paymentState}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Order state</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${order.ordersState}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Date of order</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${order.dateOfOrder}</p>
                    </div>
                </div>
            </form>
        </div>
    </div>


    <div class="row">
        <div class="col-md-12">
            <h3>Addresses</h3>
            <table class="table table-hover product-list-table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th width="100">Weight</th>
                    <th width="100">Volume</th>
                    <th width="150">Quantity</th>
                    <th width="150">Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ordersProductList}" var="product" varStatus="productListCount">
                    <tr>
                        <td>${product.key.id}</td>
                        <td>${product.key.name}</td>
                        <td>${product.key.weight}</td>
                        <td>${product.key.volume}</td>
                        <td>${product.value}</td>
                        <td>${product.key.price}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><b>Total</b></td>
                    <td><b>${order.totalQuantity}</b></td>
                    <td><b>${order.totalPrice}</b></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <a href="<c:url value='/orders/all' />" class="btn btn-primary">Back</a>
            <%--<a href="<c:url value='/orders/repeat-${order.id}' />" class="btn btn-primary">Repeat</a>--%>
        </div>
    </div>
</div>


<c:import url="common/scripts.jsp"/>

</body>
</html>