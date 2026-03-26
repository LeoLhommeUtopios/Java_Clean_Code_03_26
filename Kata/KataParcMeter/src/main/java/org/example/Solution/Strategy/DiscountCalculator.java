package org.example.Solution.Strategy;

import org.example.Solution.ValueObject.Price;

public interface DiscountCalculator {
    Price apply(Price basePrice);
}
