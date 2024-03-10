package ru.example.java.pattern.decorator;

import java.util.List;

public class OrderWith20 implements Order {

    private final Order order;

    public OrderWith20(Order order) {
        this.order = order;
    }

    @Override
    public int price() {
        return (int) (order.price() * 0.8);
    }
}
