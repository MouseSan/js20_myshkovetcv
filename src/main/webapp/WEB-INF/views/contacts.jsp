<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="common/headTag.jsp"/>
    <title>Watch shop - Contacts</title>
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
            <h1 class="page-title">Contacts</h1>
        </div>
    </div>
    <!-- END BREADCRUMBS -->

    <div class="shop-main">
        <div class="container-fluid">
            <!-- SERVICES -->
            <div class="row">
                <div class="col-md-12">
                    <div class="custom-contacts-box">
                        <span class="custom-bold-text">E-mail address:</span> info@watchshop.com
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="custom-contacts-box">
                        <span class="custom-bold-text">Office address:</span> V.O. 13th line, 14, 199034 St. Petersburg, Russia
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="custom-map-box">
                        <script type="text/javascript" charset="utf-8" async src="https://api-maps.yandex.ru/services/constructor/1.0/js/?um=constructor%3A842e442e32417e6ab6ba3022b537b0d1c25c574a8a638723bf8f9ffad51815aa&amp;width=100%25&amp;height=300&amp;lang=ru_RU&amp;scroll=true"></script>
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

</body>
</html>
