package ru.example.java.pattern.decorator;

import java.util.List;

public class BaseOrder implements Order {

    private final List<Integer> price;

    public BaseOrder(List<Integer> price) {
        this.price = price;
    }

    @Override
    public int price() {
        return price.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
