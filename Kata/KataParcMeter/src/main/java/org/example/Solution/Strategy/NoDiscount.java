package org.example.Solution.Strategy;

import org.example.Solution.ValueObject.Price;

public class NoDiscount implements DiscountCalculator {
    @Override
    public Price apply(Price basePrice) {
        return basePrice;
    }
}
