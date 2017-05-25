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

var addProductToStorefront_Handler = function () {
    var buttonValue = this.value;
    addProductToStorefront(buttonValue);
};

$(function () {
    assignClickHandler($(".addToCustomStorefrontList"), addProductToStorefront_Handler);
});

function addProductToStorefront(productId) {
    $.ajax({
        method: "GET",
        url: "/admin/addToCustomList",
        data: {
            productId: parseInt(productId)
        },
        success: function (result) {
            alert("Product successfully added.")
        },
        error: function (a) {
            alert(a);
        }
    })
}

