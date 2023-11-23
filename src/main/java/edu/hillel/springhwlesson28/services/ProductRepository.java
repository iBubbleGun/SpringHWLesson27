package edu.hillel.springhwlesson28.services;

import edu.hillel.springhwlesson28.model.Product;
import edu.hillel.springhwlesson28.util.InitialProducts;

import java.util.List;

public class ProductRepository {

    private final List<Product> products;

    public ProductRepository() {
        this.products = new InitialProducts().getProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("New product [" + product + "] successfully added.");
    }

    public void deleteProduct(int id) {
        final Product product = getProductById(id);
        if (product != null) {
            products.remove(product);
            System.out.println("Product with id \"" + id + "\" successfully removed.");
        } else {
            System.out.println("Product with id \"" + id + "\" not found.");
        }
    }

    public boolean isProductExist(int id) {
        return products.stream().anyMatch(p -> p.getId() == id);
    }
}
