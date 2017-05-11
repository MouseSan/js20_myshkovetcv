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
                <div class="panel-heading"><span class="lead">List of Products</span></div>
                <table class="table table-hover product-list-table">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Weight</th>
                        <th>Volume</th>
                        <th width="200">Quantity</th>
                        <th width="200">Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${productMap}" var="product" varStatus="productListCount">
                        <tr>
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
                        <td><b>Total</b></td>
                        <td><b>${quantityInCart}</b></td>
                        <td><b>${totalPrice}</b></td>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">

            <form:form method="POST" modelAttribute="order" class="form-horizontal form-label-left">
                <form:input type="hidden" path="id" id="id"/>

                <h3>Delivery method</h3>

                <div class="form-group deliveryAddressClose">
                    <label class="control-label col-md-2" for="deliveryMethodPickUp">Pickup</label>
                    <div class="col-md-10">
                        <form:radiobutton id="deliveryMethodPickUp" path="deliveryMethod" value="Pickup"/>
                    </div>
                </div>

                <div class="form-group deliveryAddressOpen">
                    <label class="control-label col-md-2" for="deliveryMethodExpressDelivery">Express delivery</label>
                    <div class="col-md-10">
                        <form:radiobutton id="deliveryMethodExpressDelivery" path="deliveryMethod" value="ExpressDelivery"/>
                    </div>
                </div>

                <div class="deliveryAddress" style="display: none">
                    <h4>Delivery addresses</h4>
                    <c:forEach items="${userAddressList}" var="address">
                        <div class="form-group">
                            <label class="control-label col-md-5" for="deliveryMethodPickUp${address.id}">${address.country}, ${address.city}, ${address.zipCode}, ${address.street}, ${address.apartmentNumber}</label>
                            <div class="col-md-7">
                                <form:radiobutton id="deliveryMethodPickUp${address.id}" path="deliveryAddress"
                                                  value="${address.country}, ${address.city}, ${address.zipCode}, ${address.street}, ${address.apartmentNumber}"/>
                            </div>

                        </div>
                    </c:forEach>
                </div>

                <h3>Payment method</h3>

                <div class="form-group cardInfoClose">
                    <label class="control-label col-md-2" for="paymentMethodCash">Cash</label>
                    <div class="col-md-10">
                        <form:radiobutton id="paymentMethodCash" path="paymentMethod" value="Cash" />
                    </div>
                </div>

                <div class="form-group cardInfoOpen">
                    <label class="control-label col-md-2" for="paymentMethodCard">Card</label>
                    <div class="col-md-10">
                        <form:radiobutton id="paymentMethodCard" path="paymentMethod" value="Card"/>
                    </div>
                </div>

                <div class="cardInfo" style="display: none">
                    <h4>Card info</h4>

                    <div class="form-group">
                        <label for="cardNumber" class="col-md-2 control-label">Card number</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="cardNumber" placeholder="XXXX XXXX XXXX XXXX">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cardHolder" class="col-md-2 control-label">Card holder</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="cardHolder">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cardExpDate" class="col-md-2 control-label">Card exp. date</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="cardExpDate" placeholder="MM/YY">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cardCvv" class="col-md-2 control-label">CVV</label>
                        <div class="col-md-10">
                            <input type="password" class="form-control" id="cardCvv" placeholder="***">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <a href="<c:url value='/cart' />" class="btn btn-primary">Cancel</a>
                        <button type="submit" class="btn btn-success">Submit</button>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>


<c:import url="common/scripts.jsp"/>

<script src="<c:url value='/static/js/createOrder.js' />"></script>

</body>
</html>