<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Brand management</title>
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
            <h1 class="page-title">Brand management</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <!-- MAIN -->
    <div class="shop-main">
        <div class="container">
            <form:form method="POST" modelAttribute="brandDto" class="form-horizontal" role="form">
                <form:input type="hidden" path="id" id="id"/>
                <div class="form-group form-group-lg">
                    <label for="name" class="col-sm-3 control-label">Name</label>
                    <div class="col-sm-9">
                        <form:input type="text" path="name" id="name" class="form-control"/>
                    </div>
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="has-error">
                            <form:errors path="name" class="help-inline-lg"/>
                        </div>
                    </div>
                </div>
                <div class="row row-bottom-padding">
                    <div class="col-sm-offset-3 col-sm-3">
                        <button type="submit" class="btn btn-rounded-2x btn-outline btn-primary btn-block btn-lg" >Save</button>
                    </div>
                    <div class="col-sm-3">
                        <a class="btn btn-rounded-2x btn-outline btn-danger btn-block btn-lg" href="<c:url value='/admin/brands/' />" >Cancel</a>
                    </div>
                </div>
            </form:form>
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
