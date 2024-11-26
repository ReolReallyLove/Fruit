package org.example.supermarket.strategy;


import org.example.supermarket.model.Fruit;
import org.example.supermarket.model.Strawberry;

/**
 * 折扣定价策略
 */

public class DiscountPriceCalculationStrategy implements PriceCalculationStrategy {
    @Override
    public double calculatePrice(Fruit fruit, int weight) {
        if (fruit instanceof Strawberry) {
            // 草莓打 8 折
            return fruit.getPricePerKg() * weight * 0.8;
        }
        // 对于其他水果不做折扣
        return fruit.getPricePerKg() * weight;
    }
}
