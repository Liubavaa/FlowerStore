package com.example.demo.flowers;

import java.util.LinkedList;

public class FlowerBucket extends Item{
    private final LinkedList<FlowerPack> flowerPacks = new LinkedList<>();

    public void add(FlowerPack pack) { flowerPacks.add(pack); }

    @Override
    public double getPrice() {
        return flowerPacks.stream().
                mapToDouble(FlowerPack::getPrice).
                sum();
    }
}
