package org.example.Kata2;

public abstract class Product {
    protected double basePrice;

    public Product(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice(){
        return basePrice;
    }

    public abstract  double calculaterPrice();
}
