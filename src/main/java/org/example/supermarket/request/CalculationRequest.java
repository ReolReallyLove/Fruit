package org.example.supermarket.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.supermarket.model.Fruit;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CalculationRequest {
    private String strategyType;  // 策略类型: normal, discount, discountAfterAmount
    private List<Fruit> fruitList;  // 水果数组
    private List<Integer> weights;  // 对应水果的重量数组 (整数)
}