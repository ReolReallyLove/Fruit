package org.example.supermarket.service;

import org.example.supermarket.model.Apple;
import org.example.supermarket.model.Fruit;
import org.example.supermarket.model.Mango;
import org.example.supermarket.model.Strawberry;
import org.example.supermarket.strategy.PriceCalculationStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaolr
 * @since 2024/11/21 16:38
 */
@Service
public class SupermarketService {

    public double calculateTotalPrice(PriceCalculationStrategy strategy, List<Fruit> fruits, List<Integer> weights){
        if (fruits == null || weights == null || fruits.size() != weights.size()) {
            throw new IllegalArgumentException("水果不能为空，重量不能为空");
        }
        double totalPrice = 0;

        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            int weight = weights.get(i);

            // 判断水果类型并调用相应的 calculatePrice 方法
            if (fruit instanceof Apple) {
                totalPrice += ((Apple) fruit).calculatePrice(weight, strategy);
            } else if (fruit instanceof Strawberry) {
                totalPrice += ((Strawberry) fruit).calculatePrice(weight, strategy);
            } else if (fruit instanceof Mango) {
                totalPrice += ((Mango) fruit).calculatePrice(weight, strategy);
            }
        }

        return totalPrice;

    }
}
