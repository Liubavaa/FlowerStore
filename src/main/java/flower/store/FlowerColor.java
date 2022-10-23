package lab5.FlowerStore.src.main.java.flower.store;

public enum FlowerColor {
    RED("#FF0000"), BLUE("#0000FF"),
    YELLOW("#FFFF00"), WHITE("FFFFFF");
    private final String stringRepresentation;

    FlowerColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
