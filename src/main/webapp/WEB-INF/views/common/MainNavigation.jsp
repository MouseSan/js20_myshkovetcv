<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse">
    <div class="container" id="header">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value='/' />">Shoe shop</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">Catalog<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${categoryList}" var="category">
                            <li>
                                <a href="<c:url value='/category/${category.name}' />">${category.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAuthenticated()" var="isLoggedIn"/>

                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="<c:url value='/admin/products' />">Admin panel</a></li>
                </sec:authorize>

                <c:choose>
                    <c:when test="${isLoggedIn}">
                        <li><a href="<c:url value='/orders/all' />">Orders</a></li>
                        <li><a href="<c:url value='/userSettings/' />">Settings</a></li>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>

                <li><a href="<c:url value='/cart' />">Cart (${quantityInCart})</a></li>

                <c:choose>
                    <c:when test="${isLoggedIn}">
                        <li><a href="<c:url value='/logout' />">Log out</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="<c:url value='/login#signin' />">Log in</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>