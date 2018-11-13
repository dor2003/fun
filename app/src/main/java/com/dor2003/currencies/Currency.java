package com.dor2003.currencies;

public class Currency {

    double value;
    String name;

    public Currency(double value) {
        this.value = value;
    }

    public Currency(double value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
