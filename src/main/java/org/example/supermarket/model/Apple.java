package org.example.supermarket.model;

import org.example.supermarket.strategy.PriceCalculationStrategy;

public class Apple implements Fruit {

    private static final double PRICE_PER_KG = 8.0; // 苹果价格

    @Override
    public String getName() {
        return "Apple";
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
