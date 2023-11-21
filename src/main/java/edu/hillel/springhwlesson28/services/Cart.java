package edu.hillel.springhwlesson28.services;

import edu.hillel.springhwlesson28.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<Product> userCart = new ArrayList<>();
    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id) {
        final Product product = productRepository.getProductById(id);
        if (product != null) {
            userCart.add(product);
            System.out.println("Product [" + product + "] successfully added to cart.");
        } else {
            System.out.println("Product with id \"" + id + "\" not found.");
        }
    }

    public void removeProduct(int id) {
        final Product targetProduct = productRepository.getProductById(id);
        if (targetProduct != null) {
            if (userCart.contains(targetProduct)) {
                userCart.remove(targetProduct);
                System.out.println("Product with id \"" + id + "\" successfully removed from cart.");
            } else {
                System.out.println("This product isn't exist in your cart.");
            }
        } else {
            System.out.println("Product with id \"" + id + "\" not found.");
        }
    }

    public List<Product> getCart() {
        return userCart;
    }
}
