package ru.alexp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.alexp.appconfig.AppConfig;
import ru.alexp.products.Product;
import ru.alexp.service.Cart;
import ru.alexp.service.OrderService;
import ru.alexp.service.ProductService;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        productService.printAll();
        Cart cart = context.getBean("cart", Cart.class);
        cart.addToCart(productService.findByTitle("ToY"));
        cart.addToCart(productService.findByTitle("toy"));
        cart.addToCart(productService.findByTitle("T-SHIRT"));
        cart.addToCart(productService.findByTitle("Cola"));
        cart.addToCart(productService.findByTitle("JAGERMEISTER"));
        cart.addToCart(productService.findByTitle("Jagermeister"));
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.createOrder();
        context.close();
    }
}
