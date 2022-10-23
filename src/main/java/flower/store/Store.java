package flower.store;

import java.util.LinkedList;
import java.util.List;

public class Store {
    private final List<FlowerBucket> buckets = new LinkedList<>();

    public void addBucket(FlowerBucket flowerbucket) {
        buckets.add(flowerbucket);
    }

    public List<FlowerBucket> search(double minPrice, double maxPrice, int roseQuantity,
                                     int tulipQuantity, int chamomileQuantity) {
        List<FlowerBucket> matchingBuckets = new LinkedList<>();
        for (FlowerBucket bucket : buckets) {
            if (roseQuantity != bucket.getFlowerPacks().stream().
                    filter(x -> x.getFlower().getFlowerType() == FlowerType.ROSE).
                    mapToInt(FlowerPack::getQuantity).sum()) {
                continue;
            }
            if (tulipQuantity != bucket.getFlowerPacks().stream().
                    filter(x -> x.getFlower().getFlowerType() == FlowerType.TULIP).
                    mapToInt(FlowerPack::getQuantity).sum()) {
                continue;
            }
            if (chamomileQuantity != bucket.getFlowerPacks().stream().
                    filter(x -> x.getFlower().getFlowerType() == FlowerType.CHAMOMILE).
                    mapToInt(FlowerPack::getQuantity).sum()) {
                continue;
            }
            if (minPrice > bucket.getPrice() && bucket.getPrice() > maxPrice) {
                continue;
            }
            matchingBuckets.add(bucket);
        }
        return matchingBuckets;
    }
}
