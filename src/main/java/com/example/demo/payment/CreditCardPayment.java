package com.example.demo.payment;

public class CreditCardPayment implements Payment{
    @Override
    public double pay(double price) {
        return price*1.05;
    }
}
