package com.example.demo.flowers;

import com.example.demo.delivery.DHLDelivery;
import com.example.demo.delivery.PostDelivery;
import com.example.demo.payment.CreditCardPayment;
import com.example.demo.payment.PayPalPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flowers")
public class FlowerController {
    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }

    @PostMapping
    public void addFlower(@RequestBody Flower flower){
        flowerService.addFlower(flower);
    }

    @RequestMapping("/delivery")
    public List<String> getDelivery() {
        DHLDelivery delivery1 = new DHLDelivery();
        PostDelivery delivery2 = new PostDelivery();
        String del1 = "DHL Delivery of all flowers will cost " + delivery1.deliver(getFlowers());
        String del2 = "Post Delivery of all flowers will cost " + delivery2.deliver(getFlowers());
        return List.of(del1, del2);
    }

    @RequestMapping("/payments")
    public List<String> getPayments() {
        PayPalPayment payment1 = new PayPalPayment();
        CreditCardPayment payment2 = new CreditCardPayment();
        String pay1 = "For all flowers you will pay "+ payment1.
                pay(getFlowers().stream().
                        mapToDouble(Item::getPrice).
                        sum())+" by Pay Pal.";
        String pay2 = "For all flowers you will pay "+ payment2.
                pay(getFlowers().stream().
                        mapToDouble(Item::getPrice).
                        sum())+" by Credit Card.";
        return List.of(pay1, pay2);
    }
}
