package ru.tsystems.js20.myshkovetcv.model.enums;

public enum OrderState {
    New,
    Pending,
    WaitingForShipment,
    Shipped,
    Delivered,
    Completed;

    OrderState() {
    }
}
