package com.cydeo.enums;

public enum CartState {

    CREATED ("CREATED"), SOLD("SOLD");

    private String value;

    CartState(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CartState{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }
}
