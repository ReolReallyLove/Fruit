package org.example.supermarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.supermarket.strategy.PriceCalculationStrategy;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Apple.class, name = "apple"),
        @JsonSubTypes.Type(value = Strawberry.class, name = "strawberry"),
        @JsonSubTypes.Type(value = Mango.class, name = "Mango")
})
public interface Fruit {

    // 水果名称
    String getName();

    // 水果每公斤价格
    double getPricePerKg();

    // 计算水果价格，重量和策略
    double calculatePrice(int weight, PriceCalculationStrategy strategy);
}
