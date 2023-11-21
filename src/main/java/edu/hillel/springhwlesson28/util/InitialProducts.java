package edu.hillel.springhwlesson28.util;

import edu.hillel.springhwlesson28.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class InitialProducts {

    private final Random rnd = new Random();
    private final List<Product> products = new ArrayList<>();

    public InitialProducts() {
        IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Product(i, "Product " + i, getRandomDouble()))
                .forEach(products::add);
    }

    public List<Product> getProducts() {
        return products;
    }

    private double getRandomDouble() {
        final double MIN_PRODUCT_COST = 0.99;
        final double MAX_PRODUCT_COST = 9999.99;
        final double randomValue = MIN_PRODUCT_COST + (MAX_PRODUCT_COST - MIN_PRODUCT_COST) * rnd.nextDouble();
        return Math.round(randomValue * 100.0) / 100.0;
    }
}
