package com.example.demo.decorator;

import com.example.demo.flowers.Item;

public class RibbonDecorator extends ItemDecorator {
    private final double price = 40;

    public RibbonDecorator(Item item){
        super(item);
        setDescription(item.getDescription()+" decorated with ribbon");
    }
}
