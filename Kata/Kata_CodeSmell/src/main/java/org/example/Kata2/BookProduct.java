package org.example.Kata2;

public class BookProduct extends Product{

    public BookProduct(double basePrice) {
        super(basePrice);
    }

    @Override
    public double calculaterPrice() {
        return basePrice  + basePrice * 0.05;
    }
}
