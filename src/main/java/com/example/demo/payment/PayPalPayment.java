package com.example.demo.payment;

public class PayPalPayment implements Payment {

    @Override
    public double pay(double price) {
        return price*1.02;
    }
}