<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop</title>
</head>

<body>
<!-- WRAPPER -->
<div class="wrapper">

    <!-- NAVBAR -->
    <c:import url="common/navBar.jsp"/>
    <!-- END NAVBAR -->

    <div class="shop-main">
        <div class="container-fluid">

            <!-- HERO UNIT -->
            <div class="row">
                <div class="col-md-12">
                    <section class="hero-unit-slider shop-hero-unit">
                        <div id="carousel-home" class="slick-carousel slick-text-pagination">
                            <div class="carousel-inner" role="listbox">
                                <div class="item active" data-pagination-title="EVERYDAY">
                                    <img src="<c:url value='/static/img/everyday.png' />" alt="Slider Image">
                                    <div class="carousel-caption bottom-caption">
                                        <h2 class="hero-heading">EVERYDAY WATCHES</h2>
                                        <a href="<c:url value='/category/1' />" class="btn btn-lg hero-button">DIVE IN CATALOG</a>
                                    </div>
                                </div>
                                <div class="item" data-pagination-title="CLASSIC">
                                    <img src="<c:url value='/static/img/classic.png' />" alt="Slider Image">
                                    <div class="carousel-caption bottom-caption">
                                        <h2 class="hero-heading">OLD FASHIONED CLASSIC</h2>
                                        <%--<p class="lead">Fashionable and functional, watches are the ultimate accessory and never go out of style</p>--%>
                                        <a href="<c:url value='/category/2' />" class="btn btn-lg hero-button">DIVE IN CATALOG</a>
                                    </div>
                                </div>
                                <div class="item" data-pagination-title="SPORT">
                                    <img src="<c:url value='/static/img/sport-watches.png' />" alt="Slider Image">
                                    <div class="carousel-caption bottom-caption">
                                        <h2 class="hero-heading">SPORT WATCHES</h2>
                                        <%--<p class="lead">Latest collections for women</p>--%>
                                        <a href="<c:url value='/category/4' />" class="btn btn-lg hero-button">DIVE IN CATALOG</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <!-- END HERO UNIT -->

            <!-- SERVICES -->
            <div class="row">
                <div class="col-md-12">
                    <div class="services">
                        <div class="row">
                            <div class="col-md-offset-2 col-md-4">
                                <div class="service-item">
                                    <i class="fa fa-truck"></i>
                                    <h2 class="service-title">FREE SHIPPING</h2>
                                    <p>For all orders.</p>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="service-item">
                                    <i class="fa fa-phone-square"></i>
                                    <h2 class="service-title">24/7 CUSTOMER SUPPORT</h2>
                                    <p>Always in touch</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END SERVICES -->
    <!-- FOOTER -->
    <c:import url="common/footer.jsp" />
    <!-- END FOOTER -->
</div>
<!-- END WRAPPER -->

<!-- JAVASCRIPTS -->
<c:import url="common/scriptsTag.jsp" />
<script src="<c:url value='/static/js/plugins/slick/slick.min.js' />"></script>

</body>
</html>
