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

var removeAddress_Handler = function () {
    var buttonValue = this.value;
    removeAddress(buttonValue);
};

$(function () {
    assignClickHandler($(".removeAddress"), removeAddress_Handler);
});

function removeAddress(addressId) {
    $.ajax({
        method: "GET",
        url: "/userSettings/removeAddress",
        data: {
            addressId: parseInt(addressId)
        },
        success: function (result) {
            var urlStr = window.location.pathname + ' #addressTable';
            $('#addressTable').load(urlStr, function () {
                removeClickHandler($(".removeAddress"), removeAddress_Handler);
                assignClickHandler($(".removeAddress"), removeAddress_Handler);
            });
            // alert(window.location.toString())
        },
        error: function (a) {
            alert(a);
        }
    })
}
