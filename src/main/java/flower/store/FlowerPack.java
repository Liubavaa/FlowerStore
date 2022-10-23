package lab5.FlowerStore.src.main.java.flower.store;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower flower, int quantity) {setFlower(flower); setQuantity(quantity);}

    public Double getPrice() {return flower.getPrice()*quantity;}
}
