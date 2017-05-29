<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default navbar-fixed-top navbar-auto-hiding" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-nav">
                <span class="sr-only">Toggle Navigation</span>
                <i class="fa fa-bars"></i>
            </button>
            <a href="<c:url value='/' />" class="navbar-brand navbar-logo">
                <img src="<c:url value='/static/img/watch-shop-logo.png' />" alt="Repute - Responsive Multipurpose Bootstrap Theme">
            </a>
        </div>
        <!-- MAIN NAVIGATION -->
        <div id="main-nav" class="navbar-collapse collapse navbar-mega-menu">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value='/' />">HOME</a>
                </li>
                <li class="dropdown ">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">CATEGORIES  <i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu" role="menu">
                        <c:forEach items="${categoryList}" var="category">
                            <li><a href="<c:url value='/category/${category.id}' />">${category.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <sec:authorize access="hasRole('ADMIN')">
                    <li class="dropdown ">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">ADMIN PANEL  <i class="fa fa-angle-down"></i></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="<c:url value='/admin/storefront/' />">Storefront settings</a></li>
                            <li><a href="<c:url value='/admin/reports/' />">Reports</a></li>
                            <li><a href="<c:url value='/admin/orders/' />">Orders</a></li>
                            <li><a href="<c:url value='/admin/products/' />">Products</a></li>
                            <li><a href="<c:url value='/admin/categories/' />">Categories</a></li>
                            <li><a href="<c:url value='/admin/brands/' />">Brands</a></li>
                        </ul>
                    </li>
                </sec:authorize>
                <li>
                    <a href="<c:url value='/storefront/' />">STOREFRONT</a>
                </li>
                <li class="shopping-cart">
                    <a href="<c:url value='/cart' />" id="cart">CART
                        <i class="fa fa-shopping-cart"></i>
                        <span class="cart-count">${quantityInCart}</span>
                    </a>
                </li>
                <li>
                    <a href="<c:url value='/contacts/' />">CONTACTS</a>
                </li>
                <sec:authorize access="isAuthenticated()" var="isLoggedIn"/>
                <c:choose>
                    <c:when test="${isLoggedIn}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome, ${currentUserName}<i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="<c:url value='/orders/all' />">Orders</a></li>
                                <li><a href="<c:url value='/userSettings/' />">Settings</a></li>
                                <li><a href="<c:url value='/logout' />">Log out</a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="<c:url value='/login' />" >LOG IN</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <!-- END MAIN NAVIGATION -->
    </div>
</nav>