package FlowerStore.src.main.java.flower.store;

import java.util.LinkedList;
import java.util.List;

public class Store {
    private final List<FlowerBucket> buckets = new LinkedList<>();

    public void addBucket(FlowerBucket flowerbucket) {
        buckets.add(flowerbucket);
    }

    public List<FlowerBucket> search(double min_price, double max_price, int rose_quantity,
                                     int tulip_quantity, int chamomile_quantity) {
        List<FlowerBucket> matchingBuckets = new LinkedList<>();
        for (FlowerBucket bucket : buckets) {
            if (rose_quantity != bucket.getFlowerPacks().stream().
                    filter(x -> x.getFlower().getFlowerType() == FlowerType.ROSE).
                    mapToInt(FlowerPack::getQuantity).sum())
                continue;
            if (tulip_quantity != bucket.getFlowerPacks().stream().
                    filter(x -> x.getFlower().getFlowerType() == FlowerType.TULIP).
                    mapToInt(FlowerPack::getQuantity).sum())
                continue;
            if (chamomile_quantity != bucket.getFlowerPacks().stream().
                    filter(x -> x.getFlower().getFlowerType() == FlowerType.CHAMOMILE).
                    mapToInt(FlowerPack::getQuantity).sum())
                continue;
            if (min_price > bucket.getPrice() && bucket.getPrice() > max_price)
                continue;
            matchingBuckets.add(bucket);
        }
        return matchingBuckets;
    }
}
