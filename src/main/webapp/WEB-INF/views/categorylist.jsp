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
                <div class="panel-heading"><span class="lead">List of Categories</span></div>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${categoryList}" var="category">
                        <tr>
                            <td>${category.id}</td>
                            <td>${category.name}</td>
                            <td><a href="<c:url value='/edit-category-${category.id}' />"
                                   class="btn btn-success custom-width">edit</a></td>
                                <%--<td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>--%>
                                <%--<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>--%>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="well">
                <a href="<c:url value='/newcategory' />">Add New Product</a>
            </div>
        </div>
    </div>
</div>

<c:import url="common/scripts.jsp"/>

</body>
</html>