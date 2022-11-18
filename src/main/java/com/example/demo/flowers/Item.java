package com.example.demo.flowers;

import lombok.Setter;

@Setter
public abstract class Item {
    private String description;
    public abstract double getPrice();

    public String getDescription() {
        return description;
    }
}
