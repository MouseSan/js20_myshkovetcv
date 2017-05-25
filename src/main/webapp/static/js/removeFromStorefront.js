var assignClickHandler = function (selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function () {
        };
    selector.on("click", handler);
};

var removeClickHandler = function (selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function () {
        };
    selector.off("click", handler);
};

var removeProductFromStorefront_Handler = function () {
    var buttonValue = this.value;
    removeProductFromStorefront(buttonValue);
};

$(function () {
    assignClickHandler($(".removeFromCustomStorefrontList"), removeProductFromStorefront_Handler);
});

function removeProductFromStorefront(productId) {
    $.ajax({
        method: "GET",
        url: "/admin/removeFromCustomList",
        data: {
            productId: parseInt(productId)
        },
        success: function (result) {
            var urlStr = window.location.pathname + ' #storefront-form';
            $('#storefront-form').load(urlStr, function () {
                removeClickHandler($(".removeFromCustomStorefrontList"), removeProductFromStorefront_Handler);
                assignClickHandler($(".removeFromCustomStorefrontList"), removeProductFromStorefront_Handler);
            });
        },
        error: function (a) {
            alert(a);
        }
    })
}


