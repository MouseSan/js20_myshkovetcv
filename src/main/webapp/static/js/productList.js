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

var addToCart_Handler = function () {
    var buttonValue = this.value;
    addToCart(buttonValue);
};

$(function () {
    assignClickHandler($(".addToCart"), addToCart_Handler);
});

function addToCart(productId) {
    $.ajax({
        method: "GET",
        url: "/addToCart",
        data: {
            productId: parseInt(productId)
        },
        success: function (result) {
            var urlStr = window.location.pathname + ' #header';
            $('#header').load(urlStr, function () {
                removeClickHandler($(".addToCart"), addToCart_Handler);
                assignClickHandler($(".addToCart"), addToCart_Handler);
            });
            // alert(window.location.toString())
        },
        error: function (a) {
            alert(a);
        }
    })
}