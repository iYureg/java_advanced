package ru.example.java.pattern.decorator;

import java.util.List;

public class App {
    public static void main(String[] args) {
        var order = new BaseOrder(List.of(1000, 1));
        System.out.println(order.price());

        var orderWith20 = new OrderWith20(order);
        System.out.println(orderWith20.price());

        var orderWithCoupon = new OrderWith20(new OrderWith20(new OrderWithCoupon(order)));
        System.out.println(orderWithCoupon.price());
    }
}
