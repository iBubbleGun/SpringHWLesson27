package edu.hillel.springhwlesson28.configuration;

import edu.hillel.springhwlesson28.services.Cart;
import edu.hillel.springhwlesson28.services.ProductRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {

    private final ApplicationContext applicationContext;

    public BeanConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Cart cart() {
        return new Cart(applicationContext.getBean(ProductRepository.class));
    }
}
