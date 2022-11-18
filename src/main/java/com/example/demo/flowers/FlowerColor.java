package com.example.demo.flowers;


public enum FlowerColor {
    RED("red"), BLUE("blue"),
    YELLOW("yellow"), WHITE("white");
    private final String stringRepresentation;

    FlowerColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}

