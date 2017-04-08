<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login page</title>


    <!-- Bootstrap -->
    <link href="<c:url value='/static/bootstrap/dist/css/bootstrap.min.css' />" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value='/static/font-awesome/css/font-awesome.min.css' />" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value='/static/nprogress/nprogress.css' />" rel="stylesheet">

    <!-- Animate.css -->
    <link href="<c:url value='/static/animate.css/animate.min.css' />" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value='/static/custom/css/custom.css' />" rel="stylesheet">

</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div id="register" class="animate form registration_form">
            <section class="login_content">

                <%--<form:form method="POST" modelAttribute="user" class="form-horizontal">--%>

                <%--<h1>Create Account</h1>--%>

                <%--<form:input type="hidden" path="id" id="id"/>--%>

                <%--<div>--%>
                <%--<form:input type="text" path="firstName" id="firstName" required="required" class="form-control"/>--%>
                <%--<input type="hidden" class="form-control" id="firstName" name="firstName" placeholder="First name" required>--%>
                <%--</div>--%>

                <%--<div>--%>
                <%--<input type="text" class="form-control" id="firstName" name="firstName" placeholder="First name" required>--%>
                <%--</div>--%>

                <%--<div>--%>
                <%--<input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last name">--%>
                <%--</div>--%>

                <%--<div>--%>
                <%--<input type="text" class="form-control" id="dateOfBirth" name="dateOfBirth" placeholder="Date of birth">--%>
                <%--</div>--%>

                <%--<div>--%>
                <%--<input type="text" class="form-control" id="emailAddress" name="emailAddress" placeholder="E-mail" required>--%>
                <%--</div>--%>
                <%--<div>--%>
                <%--<input type="password" class="form-control" id="password" name="password" placeholder="Password" required>--%>
                <%--</div>--%>

                <%--<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />--%>

                <%--<div>--%>
                <%--<input type="submit" class="btn btn-primary custom-btn" value="Register">--%>
                <%--</div>--%>

                <%--<div class="clearfix"></div>--%>

                <%--<div class="separator">--%>
                <%--<p class="change_link">Already a member ?--%>
                <%--<a href="<c:url value='/login#signin' />" class="to_register"> Log in </a>--%>
                <%--</p>--%>
                <%--<div class="clearfix"></div>--%>
                <%--<br />--%>
                <%--</div>--%>


                <%--</form:form>--%>


                <form action="/register" method="post" class="form-horizontal">


                    <h1>Create Account</h1>

                    <div>
                        <input type="hidden" class="form-control" id="id" name="id">
                    </div>

                    <div>
                        <input type="text" class="form-control" id="firstName" name="firstName"
                               placeholder="First name" required>
                    </div>

                    <div>
                        <input type="text" class="form-control" id="lastName" name="lastName"
                               placeholder="Last name">
                    </div>

                    <div>
                        <input type="text" class="form-control" id="dateOfBirth" name="dateOfBirth"
                               placeholder="Date of birth">
                    </div>

                    <div>
                        <input type="text" class="form-control" id="emailAddress"
                               name="emailAddress" placeholder="E-mail" required>
                    </div>
                    <div>
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="Password" required>
                    </div>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div>
                        <input type="submit" class="btn btn-primary custom-btn" value="Register">
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Already a member ?
                            <a href="<c:url value='/login#signin' />" class="to_register"> Log
                                in </a>
                        </p>
                        <div class="clearfix"></div>
                        <br/>
                    </div>
                </form>

            </section>
        </div>
    </div>
</div>
</body>
</html>

