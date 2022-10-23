package flower.store;

public enum FlowerType {
    CHAMOMILE, ROSE, TULIP;

    public String toString() {
        return switch (this) {
            case ROSE -> "Rose";
            case CHAMOMILE -> "Chamomile";
            default -> "Tulip";
        };
    }
}
