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

            <h3>${title}</h3>
            <form:form method="POST" modelAttribute="user" class="form-horizontal form-label-left">
                <form:input type="hidden" path="id" id="id"/>
                <form:input type="hidden" path="password" id="password"/>


                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12"
                           for="firstName">First name</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <form:input type="text" path="firstName" id="firstName" required="required" class="form-control col-md-7 col-xs-12"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12"
                           for="lastName">Last name</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <form:input type="text" path="lastName" id="lastName" required="required" class="form-control col-md-7 col-xs-12"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12"
                           for="dateOfBirth">Date Of Birth</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <form:input type="text" path="dateOfBirth" id="dateOfBirth" required="required" class="form-control col-md-7 col-xs-12"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12"
                           for="emailAddress">E-mail address</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <form:input type="text" path="emailAddress" id="emailAddress" required="required" class="form-control col-md-7 col-xs-12"/>
                    </div>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-success">Update info</button>
                </div>

            </form:form>
        </div>
    </div>
</div>


<c:import url="common/scripts.jsp"/>

</body>
</html>