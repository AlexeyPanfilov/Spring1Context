package ru.alexp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alexp.products.Product;

import javax.xml.crypto.KeySelector;
import java.util.Map;

@Component
public class OrderService {

    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void createOrder() {
        System.out.println("\nYour cart:\n");
        Map<Product, Integer> order = cart.getCart();
        int sum = 0;
        for (Product p : order.keySet()) {
            System.out.println(p + " " + order.get(p) + " шт. " + order.get(p) * p.getPrice());
            sum += order.get(p) * p.getPrice();
        }
        System.out.println("Total: " + sum + " cr.");
    }
}
