package flower.store;

import java.util.LinkedList;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class FlowerBucket {
    private final LinkedList<FlowerPack> flowerPacks = new LinkedList<>();

    public void add(FlowerPack pack) { flowerPacks.add(pack); }

    public double getPrice() {
        return flowerPacks.stream().mapToDouble(FlowerPack::getPrice).sum();
    }
}
