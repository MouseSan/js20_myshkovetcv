/**
 * Created by Viacheslav on 05.04.2017.
 */
var assignClickHandler = function (selector, handler) {
    // selector is a jquery object
    selector = selector || $(".some-class-which-doesnot-exist");
    handler = handler || function () {
        };
    selector.on("click", handler);
};

var addToCart_Handler = function () {
    var buttonValue = this.value;
    addToCard(buttonValue);
};

$(function () {
    assignClickHandler($(".addToCard"), addToCart_Handler);
});

function addToCard(productIndex) {
    $.ajax({
        method: "POST",
        url: "/AddTOCard",
        data: {
            productIndex: parseInt(productIndex)
        },
        success: function (result) {
            //прописать перезагрузку элемента

            alert(result)
        },
        error: function (a) {
            alert(a);
        }
    })
}