package org.example.supermarket.model;

import org.example.supermarket.strategy.PriceCalculationStrategy;

public class Strawberry implements Fruit {

    private static final double PRICE_PER_KG = 13.0; // 草莓价格

    @Override
    public String getName() {
        return "Strawberry";
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
