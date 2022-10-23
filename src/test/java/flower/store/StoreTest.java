
package flower.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class StoreTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 10;
    private static final int MAX_PRICE = 100;

    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    public void testSearch() {
        int priceRose = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantityRose = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower rose = new Rose();
        rose.setPrice(priceRose);
        FlowerPack flowerPackRose = new FlowerPack(rose, quantityRose);
        FlowerBucket flowerBucketRose = new FlowerBucket();
        flowerBucketRose.add(flowerPackRose);

        int priceTulip = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantityTulip = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower tulip = new Tulip();
        tulip.setPrice(priceTulip);
        FlowerPack flowerPackTulip = new FlowerPack(tulip, quantityTulip);
        FlowerBucket flowerBucketTulipRose = new FlowerBucket();
        flowerBucketTulipRose.add(flowerPackRose);
        flowerBucketTulipRose.add(flowerPackTulip);

        int priceChamomile = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantityChamomile = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower chamomile = new Chamomile();
        chamomile.setPrice(priceChamomile);
        FlowerPack flowerPackChamomile = new FlowerPack(chamomile, quantityChamomile);
        FlowerBucket flowerBucketChamomileTulip = new FlowerBucket();
        flowerBucketChamomileTulip.add(flowerPackChamomile);
        flowerBucketChamomileTulip.add(flowerPackTulip);

        store.addBucket(flowerBucketRose);
        store.addBucket(flowerBucketTulipRose);
        store.addBucket(flowerBucketChamomileTulip);

        Assertions.assertTrue(store.search
                (priceRose * quantityRose, priceRose * quantityRose,
                        quantityRose, 0, 0).contains(flowerBucketRose));
        Assertions.assertTrue(store.search(priceTulip * quantityTulip,
                priceTulip * quantityTulip + priceRose * quantityRose,
                quantityRose, quantityTulip, 0).contains(flowerBucketTulipRose));
        Assertions.assertTrue(store.search
                (0, 3 * MAX_PRICE * MAX_QUANTITY,
                        0, quantityTulip, quantityChamomile).contains(flowerBucketChamomileTulip));
    }
}
