package ru.tsystems.js20.myshkovetcv.model.enums;

public enum OrdersState {
    New,
    Pending,
    WaitingForShipment,
    Shipped,
    Delivered,
    Completed;

    OrdersState() {
    }
}
