package com.example.demo;

import com.example.demo.delivery.DHLDelivery;
import com.example.demo.delivery.PostDelivery;
import com.example.demo.flowers.FlowerController;
import com.example.demo.flowers.Item;
import com.example.demo.payment.CreditCardPayment;
import com.example.demo.payment.PayPalPayment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
class FlowerApplicationTests {

	@Autowired
	private FlowerController controller;

	@Test
	public void testDelivery(){
		DHLDelivery delivery1 = new DHLDelivery();
		PostDelivery delivery2 = new PostDelivery();
		assert (delivery1.deliver(controller.getFlowers()) == 15);
		assert (delivery2.deliver(controller.getFlowers()) == 100);
	}

	@Test
	public void testPayment(){
		PayPalPayment payment1 = new PayPalPayment();
		CreditCardPayment payment2 = new CreditCardPayment();
		assert (payment1.pay(controller.getFlowers().stream().
				mapToDouble(Item::getPrice).
				sum()) == 153);
		assert (payment2.pay(controller.getFlowers().stream().
				mapToDouble(Item::getPrice).
				sum()) == 157.5);
	}
}
