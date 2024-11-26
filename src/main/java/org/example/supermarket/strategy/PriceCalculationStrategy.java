package org.example.supermarket.strategy;


import org.example.supermarket.model.Fruit;

public interface PriceCalculationStrategy {
    double calculatePrice(Fruit fruit, int weight);
}
