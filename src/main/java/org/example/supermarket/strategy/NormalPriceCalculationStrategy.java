package org.example.supermarket.strategy;


import org.example.supermarket.model.Fruit;

/**
 * 正常价格无折扣策略
 */

public class NormalPriceCalculationStrategy implements PriceCalculationStrategy {
    @Override
    public double calculatePrice(Fruit fruit, int weight) {
        return fruit.getPricePerKg() * weight;
    }
}
