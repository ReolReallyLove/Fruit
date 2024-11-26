package org.example.supermarket.model;

import org.example.supermarket.strategy.PriceCalculationStrategy;

public class Mango implements Fruit {

    private static final double PRICE_PER_KG = 20.0; // 芒果价格

    @Override
    public String getName() {
        return "Mango";
    }

    @Override
    public double getPricePerKg() {
        return PRICE_PER_KG;
    }

    @Override
    public double calculatePrice(int weight, PriceCalculationStrategy strategy) {
        return strategy.calculatePrice(this, weight); // 委托给策略计算
    }
}
