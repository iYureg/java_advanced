package ru.example.java.pattern.decorator;

public class OrderWithCoupon implements Order{

    private final Order order;

    public OrderWithCoupon(Order order) {
        this.order = order;
    }

    @Override
    public int price() {
        return order.price() > 1000
                ? order.price() - 50
                : order.price();
    }
}
