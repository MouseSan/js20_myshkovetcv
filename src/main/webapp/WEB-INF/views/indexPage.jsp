<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive Multipurpose Bootstrap Theme">
    <meta name="author" content="MyshkovetcVV">

    <title>Shoe Shop</title>

    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/bootstrap.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/font-awesome.min.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/main.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/shop-main.css' />" />

    <!-- GOOGLE FONTS -->
    <link rel="stylesheet" type="text/css" href="<c:url value='http://fonts.googleapis.com/css?family=Open+Sans:300,400italic,400,600,700' />" >
    <link rel="stylesheet" type="text/css" href="<c:url value='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,300italic,400italic,700,400,300' />" >

    <!-- FAVICONS -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/static/ico/repute144x144.png' />" >
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value='/static/ico/repute114x114.png' />" >
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/static/ico/repute72x72.png' />" >
    <link rel="apple-touch-icon-precomposed" sizes="57x57" href="<c:url value='/static/ico/repute57x57.png' />" >
    <link rel="shortcut icon" href="<c:url value='/static/ico/favicon.png' />">

</head>

<body>
<!-- WRAPPER -->
<div class="wrapper">

    <!-- NAVBAR -->
    <c:import url="common/navBar.jsp">
        <c:param name="categoryList" value="${categoryList}"/>
        <c:param name="quantityInCart" value="${quantityInCart}"/>
    </c:import>
    <!-- END NAVBAR -->

    <!-- HERO UNIT -->
    <section class="hero-unit-slider no-margin">
        <div id="carousel-hero" class="slick-carousel">
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="<c:url value='/static/img/sliders/slider3-h500.png' />" alt="Slider Image">
                    <div class="carousel-caption">
                        <h2 class="hero-heading">CLEAN &amp; ELEGANT DESIGN</h2>
                        <p class="lead">Giving valuable reputation and credibility to your business</p>
                        <a href="#" class="btn btn-lg hero-button">LEARN MORE</a>
                    </div>
                </div>
                <div class="item">
                    <img src="<c:url value='/static/img/sliders/slider2-h500.png' />" alt="Slider Image">
                    <div class="carousel-caption">
                        <h2 class="hero-heading">ULTRA RESPONSIVE</h2>
                        <p class="lead">Leave it to the theme, it knows how to deal with screen sizes</p>
                        <a href="#" class="btn btn-lg hero-button">LEARN MORE</a>
                    </div>
                </div>
                <div class="item">
                    <img src="<c:url value='/static/img/sliders/slider1-h500.png' />" alt="Slider Image">
                    <div class="carousel-caption">
                        <h2 class="hero-heading">EASY TO CUSTOMIZE</h2>
                        <p class="lead">Readable code, well documented and FREE support</p>
                        <a href="#" class="btn btn-lg hero-button">LEARN MORE</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- END HERO UNIT -->

    <!-- PAGE CONTENT -->
    <div class="page-content">
        <div class="container">

            <hr>
            <h2 class="section-heading">Main page</h2>
            <div class="row">
                <div class="col-md-6">
                    <p>Completely monetize cooperative alignments vis-a-vis empowered leadership skills. Assertively empower maintainable intellectual capital with extensive total linkage. Enthusiastically synthesize bleeding-edge intellectual capital after market-driven initiatives. Enthusiastically enhance turnkey architectures before backward-compatible deliverables. Collaboratively drive virtual solutions vis-a-vis multimedia based data. Dynamically transition emerging leadership skills after long-term high-impact human capital. Competently reintermediate 24/365 quality vectors rather than sticky bandwidth. Authoritatively.</p>
                    <p>Professionally facilitate orthogonal leadership whereas customer directed testing procedures. Credibly incubate ubiquitous human capital without efficient expertise. Intrinsicly optimize ubiquitous web-readiness through standards compliant metrics. Intrinsicly drive ethical technologies whereas installed base interfaces. Credibly expedite backward-compatible e-markets before viral opportunities.</p>
                </div>
                <div class="col-md-6">
                    <p>Quickly embrace mission-critical action items vis-a-vis backend infomediaries. Globally recaptiualize maintainable infomediaries via client-centered e-tailers. Objectively maximize prospective relationships and highly efficient applications. Intrinsicly coordinate quality "outside the box" thinking vis-a-vis collaborative web-readiness. Monotonectally coordinate distinctive results rather than wireless collaboration and idea-sharing.</p>
                    <p>Intrinsicly productize 2.0 total linkage with interdependent e-services. Monotonectally incubate fully researched manufactured products before cutting-edge solutions. Dramatically reinvent long-term high-impact strategic theme areas for timely paradigms. Professionally engage unique potentialities rather than end-to-end communities. Continually scale go forward catalysts for change without 24/7 manufactured products. Intrinsicly utilize just in time human capital via 24/7 processes. Synergistically predominate turnkey ideas after progressive intellectual capital. Progressively extend user-centric supply chains.</p>
                </div>
            </div>
        </div>
    </div>
    <!-- END PAGE CONTENT -->

    <!-- FOOTER -->
    <c:import url="common/footer.jsp" />
    <!-- END FOOTER -->
</div>
<!-- END WRAPPER -->

<!-- JAVASCRIPTS -->
<script src="<c:url value='/static/js/jquery-2.1.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/slick/slick.min.js' />"></script>
<script src="<c:url value='/static/js/plugins/autohidingnavbar/jquery.bootstrap-autohidingnavbar.min.js' />"></script>
<script src="<c:url value='/static/js/repute-scripts.js' />"></script>

</body>
</html>
