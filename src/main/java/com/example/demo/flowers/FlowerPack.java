package com.example.demo.flowers;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class FlowerPack extends Item{
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower flower, int quantity) {
        setFlower(flower);
        setQuantity(quantity);
        setDescription(String.format("Flower pack that contains %s %s", quantity, flower.getFlowerType()));
    }

    public double getPrice() { return flower.getPrice()*quantity; }
}
