package com.example.demo.decorator;

import com.example.demo.flowers.Item;

public abstract class ItemDecorator extends Item {
    protected Item item;
    private double price;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public double getPrice() {
        return item.getPrice()+price;
    }
}
