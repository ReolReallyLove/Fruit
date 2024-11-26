package org.example.supermarket.controller;

import org.example.supermarket.request.CalculationRequest;
import org.example.supermarket.service.SupermarketService;
import org.example.supermarket.strategy.DiscountAfterAmountPriceCalculationStrategy;
import org.example.supermarket.strategy.DiscountPriceCalculationStrategy;
import org.example.supermarket.strategy.NormalPriceCalculationStrategy;
import org.example.supermarket.strategy.PriceCalculationStrategy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supermarket")
public class SupermarketController {

    private final SupermarketService supermarketService;

    // 构造函数注入 SupermarketService
    public SupermarketController(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    @PostMapping("/calculateTotalPrice")
    public double calculateTotalPrice(@RequestBody CalculationRequest request) {
        // 1. 确保水果和重量的数量相同
        if (request.getFruitList().size() != request.getWeights().size()) {
            throw new IllegalArgumentException("水果种类需要和数量一致");
        }

        List<Integer> weights = request.getWeights();

        // 2. 确保每种水果的重量都是非负数
        boolean allNonNegative = weights.stream().allMatch(weight -> weight >= 0);

        if(!allNonNegative){
            throw new IllegalArgumentException("重量不能为负数");
        }


        // 3. 根据请求的策略选择对应的策略类
        PriceCalculationStrategy strategy;
        switch (request.getStrategyType()) {
            case "normal":
                strategy = new NormalPriceCalculationStrategy();
                break;
            case "discount":
                strategy = new DiscountPriceCalculationStrategy();
                break;
            case "discountAfterAmount":
                strategy = new DiscountAfterAmountPriceCalculationStrategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid strategy type");
        }

        // 调用服务层计算总价格
        return supermarketService.calculateTotalPrice(strategy, request.getFruitList(), request.getWeights());
    }
}
