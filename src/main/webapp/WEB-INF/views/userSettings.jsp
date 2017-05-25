<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Your settings</title>
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
            <h1 class="page-title">Your settings</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">

            <!-- CUSTOM TABS TOP -->
            <div class="custom-tabs-line tabs-line-bottom">
                <ul class="nav" role="tablist">
                    <li class="active"><a href="#tab-top1" role="tab" data-toggle="tab">General</a></li>
                    <li><a href="#tab-top2" role="tab" data-toggle="tab">Addresses</a></li>
                    <li><a href="#tab-top3" role="tab" data-toggle="tab">Password</a></li>
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="tab-top1">
                    <form class="form-horizontal">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-6 control-label">First name</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">${userDto.firstName}</p>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-6 control-label">Last name</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">${userDto.lastName}</p>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-6 control-label">Date of birth</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">${userDto.dateOfBirth}</p>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-6 control-label">E-mail address</label>
                            <div class="col-sm-6">
                                <p class="form-control-static">${userDto.emailAddress}</p>
                            </div>
                        </div>
                    </form>
                    <div class="custom-button-box">
                        <a href="<c:url value='/userSettings/editGeneral' />" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg">Edit</a>
                    </div>

                </div>
                <div class="tab-pane fade" id="tab-top2">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-hover product-list-table" id="addressTable">
                                <thead>
                                <tr>
                                    <th>Country</th>
                                    <th>City</th>
                                    <th>Zip code</th>
                                    <th>Street</th>
                                    <th>Apt. number</th>
                                    <th width="100"></th>
                                    <th width="100"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${addressList}" var="address">
                                    <tr>
                                        <td>${address.country}</td>
                                        <td>${address.city}</td>
                                        <td>${address.zipCode}</td>
                                        <td>${address.street}</td>
                                        <td>${address.apartmentNumber}</td>
                                        <td>
                                            <a href="<c:url value='/userSettings/editUserAddress-${address.id}' />" class="btn btn-rounded-2x btn-primary btn-block">Edit</a>
                                        </td>
                                        <td>
                                            <a href="<c:url value='/userSettings/removeUserAddress-${address.id}' />" class="btn btn-rounded-2x btn-danger btn-block">Remove</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="custom-button-box">
                        <a href="<c:url value='/userSettings/createNewAddress' />" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg">Add new address</a>
                    </div>
                </div>
                <div class="tab-pane fade" id="tab-top3">
                    <div class="custom-button-box">
                        <a href="<c:url value='/userSettings/changePassword' />" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg">Change password</a>
                    </div>
                </div>
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
