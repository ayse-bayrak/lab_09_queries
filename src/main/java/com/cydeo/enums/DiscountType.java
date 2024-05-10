package com.cydeo.enums;

public enum DiscountType {

    AMOUNT_BASED("AMOUNT_BASED"), RATE_BASED("RATE_BASED");

    private String value;

    DiscountType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DiscountType{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }
}
