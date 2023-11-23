package edu.hillel.springhwlesson28;

import edu.hillel.springhwlesson28.model.Product;
import edu.hillel.springhwlesson28.services.Cart;
import edu.hillel.springhwlesson28.services.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringHwLesson28Application {

    public static void main(String[] args) {

        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringHwLesson28Application.class, args);

        final ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        // lets to add some new product to already existing product repository
        productRepository.addProduct(new Product(150, "Product 150", 23.23));
        // our all products from product repository
        System.out.println("Our all products from product repository:\n" + productRepository.getProducts());

        final Cart cart = applicationContext.getBean(Cart.class);
        System.out.println("\nInitial user cart (must be empty): " + cart.getCart());
        System.out.println();

        // added 5 products to cart
        cart.addProduct(25);
        cart.addProduct(50);
        cart.addProduct(15);
        cart.addProduct(20);
        cart.addProduct(11);
        System.out.println("\nUser cart (must contains 5 products): " + cart.getCart());
        System.out.println();

        // remove some product from cart
        cart.removeProduct(50);
        System.out.println("User cart (must contains 4 products): " + cart.getCart());

        // Initialization new cart.
        // So it must be empty, because we use "prototype" scope for Cart bean.
        // But the product repository is only one (default "singleton" scope).
        // So now we have two different carts
        // (new one empty and old one contains 4 products) and one product repository.
        final Cart newCart = applicationContext.getBean(Cart.class);
        System.out.println("\nInitial new user cart (must be empty): " + newCart.getCart());
        System.out.println("Old user cart (must contains 4 products): " + cart.getCart());
    }
}
