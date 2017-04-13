<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- nav bar -->
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i
                    class="fa fa-shopping-bag"></i><span>E-shop</span></a>
        </div>
        <div class="clearfix"></div>
        <br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <c:choose>
                    <c:when test="${title == 'New category'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'Edit category'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'List of categories'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'List of products'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'New product'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'Edit product'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'List of parameters'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'New parameter'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'Edit parameter'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'List of parameter values'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'New parameter value'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'Edit parameter value'}">
                    <li class="active">
                        </c:when>
                        <c:otherwise>
                    <li>
                        </c:otherwise>
                        </c:choose>
                        <a><i class="fa fa-shopping-bag"></i>Products<span
                                class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">

                            <c:choose>
                                <c:when test="${title == 'List of products'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/products' />">All
                                        Products</a></li>
                                </c:when>
                                <c:when test="${title == 'New product'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/products' />">All
                                        Products</a></li>
                                </c:when>
                                <c:when test="${title == 'Edit product'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/products' />">All
                                        Products</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="<c:url value='/admin/products' />">All Products</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>

                            <c:choose>
                                <c:when test="${title == 'List of categories'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/categories' />">Categories</a>
                                    </li>
                                </c:when>
                                <c:when test="${title == 'Edit category'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/categories' />">Categories</a>
                                    </li>
                                </c:when>
                                <c:when test="${title == 'New category'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/categories' />">Categories</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="<c:url value='/admin/categories' />">Categories</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>

                            <c:choose>
                                <c:when test="${title == 'List of parameters'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/parameters' />">Parameters</a>
                                    </li>
                                </c:when>
                                <c:when test="${title == 'New parameter'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/parameters' />">Parameters</a>
                                    </li>
                                </c:when>
                                <c:when test="${title == 'Edit parameter'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/parameters' />">Parameters</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="<c:url value='/admin/parameters' />">Parameters</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>

                            <c:choose>
                                <c:when test="${title == 'List of parameter values'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/parametervalues' />">Parameter
                                        values</a></li>
                                </c:when>
                                <c:when test="${title == 'New parameter value'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/parametervalues' />">Parameter
                                        values</a></li>
                                </c:when>
                                <c:when test="${title == 'Edit parameter value'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/parametervalues' />">Parameter
                                        values</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="<c:url value='/admin/parametervalues' />">Parameter
                                        values</a></li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </li>

                    <c:choose>
                    <c:when test="${title == 'List of users'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'Edit user'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'New user'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'New user address'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'List of user address'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'Edit user address'}">
                    <li class="active">
                        </c:when>
                        <c:otherwise>
                    <li>
                        </c:otherwise>
                        </c:choose>
                        <a><i class="fa fa-users"></i>Users<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">

                            <c:choose>
                                <c:when test="${title == 'List of users'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/users' />">All Users</a></li>
                                </c:when>
                                <c:when test="${title == 'Edit user'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/users' />">All Users</a></li>
                                </c:when>
                                <c:when test="${title == 'New user'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/users' />">All Users</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="<c:url value='/admin/users' />">All Users</a></li>
                                </c:otherwise>
                            </c:choose>

                            <c:choose>
                                <c:when test="${title == 'Edit user address'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/useraddresses' />">User
                                        addresses</a></li>
                                </c:when>
                                <c:when test="${title == 'List of user address'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/useraddresses' />">User
                                        addresses</a></li>
                                </c:when>
                                <c:when test="${title == 'New user address'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/useraddresses' />">User
                                        addresses</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="<c:url value='/admin/useraddresses' />">User
                                        addresses</a></li>
                                </c:otherwise>
                            </c:choose>


                        </ul>
                    </li>

                    <c:choose>
                    <c:when test="${title == 'List of orders'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'New order'}">
                    <li class="active">
                        </c:when>
                        <c:when test="${title == 'Edit order'}">
                    <li class="active">
                        </c:when>
                        <c:otherwise>
                    <li>
                        </c:otherwise>
                        </c:choose>
                        <a><i class="fa fa-bars"></i>Orders<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">

                            <c:choose>
                                <c:when test="${title == 'List of orders'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/orders' />">Orders</a></li>
                                </c:when>
                                <c:when test="${title == 'New order'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/orders' />">Orders</a></li>
                                </c:when>
                                <c:when test="${title == 'Edit order'}">
                                    <li class="current-page"><a
                                            href="<c:url value='/admin/orders' />">Orders</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="<c:url value='/admin/orders' />">Orders</a></li>
                                </c:otherwise>
                            </c:choose>


                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- /nav bar -->

<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle"
                       data-toggle="dropdown" aria-expanded="false">
                        Menu
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="<c:url value='/settings' />">Profile</a></li>
                        <li><a href="<c:url value='/' />">Go back to shop</a></li>
                        <li><a href="<c:url value='/' />"><i class="fa fa-sign-out pull-right"></i>Log
                            Out</a></li>
                    </ul>
                </li>


            </ul>
        </nav>
    </div>
</div>
<!-- /top navigation -->