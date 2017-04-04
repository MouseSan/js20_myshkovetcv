<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- nav bar -->
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i class="fa fa-paw"></i>
                <span>E-shop</span></a>
        </div>
        <div class="clearfix"></div>
        <br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-shopping-bag"></i>Products<span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="index.html">All Products</a></li>
                            <li><a href="index2.html">Categories</a></li>
                            <li><a href="index3.html">Parameters</a></li>
                            <li><a href="index3.html">Parameter values</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-users"></i>Users<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="form.html">All Users</a></li>
                            <li><a href="form_advanced.html">User addresses</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-bars"></i>Orders<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="general_elements.html">Orders</a></li>
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
                        <li><a href="javascript:;">Profile</a></li>
                        <li><a href="javascript:;">Go back to shop</a></li>
                        <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i>Log
                            Out</a></li>
                    </ul>
                </li>


            </ul>
        </nav>
    </div>
</div>
<!-- /top navigation -->