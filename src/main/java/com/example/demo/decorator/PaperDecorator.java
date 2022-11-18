package com.example.demo.decorator;

import com.example.demo.flowers.Item;

public class PaperDecorator extends ItemDecorator {
    private final double price = 13;

    public PaperDecorator(Item item){
        super(item);
        setDescription(item.getDescription()+" decorated with paper");
    }
}
