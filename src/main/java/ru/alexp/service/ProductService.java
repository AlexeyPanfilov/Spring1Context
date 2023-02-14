package ru.alexp.service;

import org.springframework.stereotype.Component;
import ru.alexp.products.Product;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductService {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void fillProducts() {
        products = Arrays.asList(
                new Product(1, "Toy", 500),
                new Product(2, "T-Shirt", 1000),
                new Product(3, "Cola", 100),
                new Product(4, "Juice", 100),
                new Product(5, "Bread", 50),
                new Product(6, "Chocolate", 150),
                new Product(7, "Juice", 100),
                new Product(8, "Tomato", 200),
                new Product(9, "Potato", 30),
                new Product(10, "Jagermeister", 2000)
        );
    }

    public void printAll() {
        System.out.println("Products list:\n");
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("\nEnd of list\n");
    }

    public Product findByTitle(String title) {
//        Product product = new Product();
//        for (Product p : products) {
//            if (p.getTitle().equalsIgnoreCase(title)) {
//                product = p;
//            }
//        }
//        return product;
        return products.stream().filter(p -> p.getTitle().equalsIgnoreCase(title)).findFirst().get();
    }
}