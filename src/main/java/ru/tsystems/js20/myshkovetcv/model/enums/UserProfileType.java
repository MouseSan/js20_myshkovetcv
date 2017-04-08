package ru.tsystems.js20.myshkovetcv.model.enums;

public enum UserProfileType {
    USER("USER"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType() {
        return userProfileType;
    }

}