package org.example.supermarket.strategy;


import org.example.supermarket.model.Fruit;

/**
 * 满减策略
 */
public class DiscountAfterAmountPriceCalculationStrategy implements PriceCalculationStrategy {
    @Override
    public double calculatePrice(Fruit fruit, int weight) {
        double totalPrice = fruit.getPricePerKg() * weight;

        // 购物满 100 减 10
        if (totalPrice >= 100) {
            totalPrice -= 10;
        }

        return totalPrice;
    }
}
