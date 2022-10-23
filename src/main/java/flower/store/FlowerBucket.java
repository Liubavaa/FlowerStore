package lab5.FlowerStore.src.main.java.flower.store;

import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class FlowerBucket {
    private final LinkedList<FlowerPack> FlowerPacks = new LinkedList<>();

    public void add(FlowerPack pack) {FlowerPacks.add(pack);}

    public double getPrice() {
        return FlowerPacks.stream().mapToDouble(FlowerPack::getPrice).sum();
    }
}
