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
            <a href="<c:url value='/orders/all' />" class="btn btn-primary">All</a>
            <a href="<c:url value='/orders/pending' />" class="btn btn-primary">Pending</a>
            <a href="<c:url value='/orders/waitingforshipment' />" class="btn btn-primary">Waiting for shipment</a>
            <a href="<c:url value='/orders/shipped' />" class="btn btn-primary">Shipped</a>
            <a href="<c:url value='/orders/completed' />" class="btn btn-primary">Completed</a>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">${title}</span></div>
                <table class="table table-hover product-list-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Date</th>
                        <th>paymentMethod</th>
                        <th>deliveryMethod</th>
                        <th>paymentState</th>
                        <th>ordersState</th>
                        <th>Total quantity</th>
                        <th>Total price</th>
                        <th width="100></th>
                        <th width="100></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ordersList}" var="orders">
                        <tr>
                            <td>${orders.id}</td>
                            <td>${orders.dateOfOrder}</td>
                            <td>${orders.paymentMethod}</td>
                            <td>${orders.deliveryMethod}</td>
                            <td>${orders.paymentState}</td>
                            <td>${orders.ordersState}</td>
                            <td>${orders.totalQuantity}</td>
                            <td>${orders.totalPrice}</td>
                            <td>
                                <a href="<c:url value='/orders/${orders.id}' />"
                                   class="btn btn-success custom-width">View</a>
                            </td>
                            <%--<td>--%>
                                <%--<a href="<c:url value='/orders/repeat-${orders.id}' />"--%>
                                   <%--class="btn btn-success custom-width">Repeat</a>--%>
                            <%--</td>--%>
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