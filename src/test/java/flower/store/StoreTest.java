
package lab5.FlowerStore.src.test.java.flower.store;

import lab5.FlowerStore.src.main.java.flower.store.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StoreTest {
    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    public void testSearch() {
        Flower rose = new Rose();
        rose.setPrice(10);
        FlowerPack flowerPack1 = new FlowerPack(rose, 10);
        FlowerBucket flowerBucket1 = new FlowerBucket();
        flowerBucket1.add(flowerPack1);

        Flower tulip = new Tulip();
        tulip.setPrice(15);
        FlowerPack flowerPack2 = new FlowerPack(tulip, 5);
        FlowerBucket flowerBucket2 = new FlowerBucket();
        flowerBucket2.add(flowerPack1);
        flowerBucket2.add(flowerPack2);

        Flower chamomile = new Chamomile();
        chamomile.setPrice(5);
        FlowerPack flowerPack3 = new FlowerPack(chamomile, 20);
        FlowerBucket flowerBucket3 = new FlowerBucket();
        flowerBucket3.add(flowerPack3);
        flowerBucket3.add(flowerPack2);

        store.addBucket(flowerBucket1);
        store.addBucket(flowerBucket2);
        store.addBucket(flowerBucket3);

        Assertions.assertEquals(flowerBucket1, store.search
                (50, 100, 10, 0, 0).get(0));
        Assertions.assertEquals(flowerBucket2, store.search
                (100, 200, 10, 5, 0).get(0));
        Assertions.assertEquals(flowerBucket3, store.search
                (175, 175, 0, 5, 20).get(0));
    }
}
