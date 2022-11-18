package com.example.demo.delivery;

import com.example.demo.flowers.Item;

import java.util.List;

public class PostDelivery implements Delivery{
    @Override
    public double deliver(List<? extends Item> items) {
        return 100;
    }
}
