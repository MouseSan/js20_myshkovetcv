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

            <span class="lead">${title}</span>

            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">First name</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.firstName}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Last name</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.lastName}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Date of birth</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.dateOfBirth}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">E-mail address</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.emailAddress}</p>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <a href="<c:url value='/userSettings/editInfo' />" class="btn btn-primary">Edit</a>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h3>Addresses</h3>
            <table class="table table-hover product-list-table" id="addressTable">
                <thead>
                <tr>
                    <th>Country</th>
                    <th>City</th>
                    <th>Zip code</th>
                    <th>Street</th>
                    <th>Apt. number</th>
                    <th width="100"></th>
                    <%--<th width="100"></th>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${user.userAddressList}" var="address">
                    <tr>
                        <td>${address.country}</td>
                        <td>${address.city}</td>
                        <td>${address.zipCode}</td>
                        <td>${address.street}</td>
                        <td>${address.apartmentNumber}</td>
                        <td>
                            <a href="<c:url value='/userSettings/editUserAddress-${address.id}' />" class="btn btn-success custom-width">edit</a>
                        </td>
                        <%--<td>--%>
                            <%--<button class="btn btn-danger removeAddress"--%>
                                    <%--type="button"--%>
                                    <%--name="Button"--%>
                                    <%--value="${address.id}"--%>
                                    <%--id="btn-${address.id}">--%>
                                <%--<span class="glyphicon glyphicon-minus"></span>--%>
                            <%--</button>--%>
                            <%--&lt;%&ndash;<a href="<c:url value='/userSettings/deleteUserAddress-${address.id}' />" class="btn btn-danger custom-width">delete</a>&ndash;%&gt;--%>
                        <%--</td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <a href="<c:url value='/userSettings/createNewAddress' />" class="btn btn-primary">Add new address</a>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h3>Password</h3>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <a href="<c:url value='/userSettings/changePassword' />" class="btn btn-primary">Change password</a>
        </div>
    </div>
</div>


<c:import url="common/scripts.jsp"/>

<script src="<c:url value='/static/removeAddress.js' />"></script>

</body>
</html>