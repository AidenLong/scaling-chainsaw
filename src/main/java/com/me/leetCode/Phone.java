package com.me.leetCode;

import java.util.Objects;

public enum Phone {

    PHONE1000("64G", "red", 1000d),
    PHONE3000("128G", "red", 3000d);

    public final String size;
    public final String color;
    public final Double price;

    Phone(String size, String color, Double price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public Double getPrice() {
        return price;
    }

    public static Double parseEnum(String size) {
        if (Objects.equals(size, PHONE1000.size)) {
            return PHONE1000.price;
        } else if (Objects.equals(size, PHONE3000.size)) {
            return PHONE3000.price;
        }
        return null;
    }
}
