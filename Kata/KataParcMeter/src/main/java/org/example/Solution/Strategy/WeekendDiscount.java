package org.example.Solution.Strategy;


import org.example.Solution.ValueObject.Price;

public class WeekendDiscount implements DiscountCalculator {
    private static final double WEEKEND_DISCOUNT_RATE = 0.1;

    @Override
    public Price apply(Price basePrice) {
        return basePrice.multiply(1.0 - WEEKEND_DISCOUNT_RATE);
    }
}
