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

var removeOneFromCart_Handler = function () {
    var buttonValue = this.value;
    removeOneFromCart(buttonValue);
};

var removeFromCart_Handler = function () {
    var buttonValue = this.value;
    removeFromCart(buttonValue);
};

$(function () {
    assignClickHandler($(".removeFromCart"), removeFromCart_Handler);
    assignClickHandler($(".removeOneFromCart"), removeOneFromCart_Handler);
});

function removeFromCart(productId) {
    $.ajax({
        method: "GET",
        url: "/removeFromCart",
        data: {
            productId: parseInt(productId)
        },
        success: function (result) {
            var urlStr = window.location.pathname + ' #wrap';
            $('#wrap').load(urlStr, function () {
                removeClickHandler($(".removeOneFromCart"), removeOneFromCart_Handler);
                removeClickHandler($(".removeFromCart"), removeFromCart_Handler);
                assignClickHandler($(".removeOneFromCart"), removeOneFromCart_Handler);
                assignClickHandler($(".removeFromCart"), removeFromCart_Handler);
            });
            // alert(window.location.toString())
        },
        error: function (a) {
            alert(a);
        }
    })
}

function removeOneFromCart(productId) {
    $.ajax({
        method: "GET",
        url: "/removeOneFromCart",
        data: {
            productId: parseInt(productId)
        },
        success: function (result) {
            var urlStr = window.location.pathname + ' #wrap';
            $('#wrap').load(urlStr, function () {
                removeClickHandler($(".removeOneFromCart"), removeOneFromCart_Handler);
                removeClickHandler($(".removeFromCart"), removeFromCart_Handler);
                assignClickHandler($(".removeOneFromCart"), removeOneFromCart_Handler);
                assignClickHandler($(".removeFromCart"), removeFromCart_Handler);
            });
            // alert(window.location.toString())
        },
        error: function (a) {
            alert(a);
        }
    })
}