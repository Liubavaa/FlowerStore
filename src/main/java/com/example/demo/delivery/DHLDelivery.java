package com.example.demo.delivery;

import com.example.demo.flowers.Item;

import java.util.List;

public class DHLDelivery implements Delivery {
    @Override
    public double deliver(List<? extends Item> items) {
        return items.stream().mapToDouble(Item::getPrice).sum()*0.1;
    }
}
