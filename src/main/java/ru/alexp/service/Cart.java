package ru.alexp.service;

import org.springframework.stereotype.Component;
import ru.alexp.products.Product;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cart {

    private Map<Product, Integer> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        if (!cart.containsKey(product)) {
            cart.put(product, 1);
            System.out.println(product.getTitle() + " added");
        } else {
            int count = cart.get(product);
            count++;
            cart.put(product, count);
            System.out.println(product.getTitle() + " added");
        }
    }

    @Override
    public String toString() {
        System.out.println("\nCart:\n");
        StringBuilder sb = new StringBuilder();
        for (Product p : cart.keySet()) {
            sb.append(p.toString()).append(" ").append(cart.get(p)).append(" шт.").append("\n");
        }
        return sb.toString();
    }
}
