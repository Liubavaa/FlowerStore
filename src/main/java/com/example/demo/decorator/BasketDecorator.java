package com.example.demo.decorator;

import com.example.demo.flowers.Item;

public class BasketDecorator extends ItemDecorator {
    private final double price = 4;

    public BasketDecorator(Item item){
        super(item);
        setDescription(item.getDescription()+" decorated with basket");
    }
}
