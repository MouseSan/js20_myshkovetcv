<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<c:import url="common/headtag.jsp">
    <c:param name="title" value="${title}"/>
</c:import>

<body>

<c:import url="common/header.jsp"/>

<div class="container theme-showcase" role="main">

    <div class="well lead">Category Registration Form</div>
    <form:form method="POST" modelAttribute="category" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-label" for="name">Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                    href="<c:url value='/categories' />">Cancel</a>
            </div>
        </div>
    </form:form>

</div>

<c:import url="common/scripts.jsp"/>

</body>
</html>