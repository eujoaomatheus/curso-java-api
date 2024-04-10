package com.estudos.java.cursoapiv1.config;

import com.estudos.java.cursoapiv1.entities.Category;
import com.estudos.java.cursoapiv1.entities.Order;
import com.estudos.java.cursoapiv1.entities.Product;
import com.estudos.java.cursoapiv1.entities.User;
import com.estudos.java.cursoapiv1.enums.OrderStatus;
import com.estudos.java.cursoapiv1.repositories.CategoryRepository;
import com.estudos.java.cursoapiv1.repositories.OrderRepository;
import com.estudos.java.cursoapiv1.repositories.ProductRepository;
import com.estudos.java.cursoapiv1.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    final UserRepository userRepository;
    final OrderRepository orderRepository;
    final CategoryRepository categoryRepository;
    final ProductRepository productRepository;

    public TestConfig(UserRepository userRepository,
                      OrderRepository orderRepository,
                      CategoryRepository categoryRepository,
                      ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        // Injetando usuarios no banco

        User u1 = new User( "Maria Brown", "maria@gmail.com", "988888888", "123456", new ArrayList<>());
        User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456", new ArrayList<>());

        userRepository.saveAll(Arrays.asList(u1, u2));

        //Injetando os  Pedidos no banco

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED,u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        //Injetando os  Categorias no banco

        Category c1 = new Category("Eletronics", new HashSet<>());
        Category c2 = new Category("Books", new HashSet<>());
        Category c3 = new Category("Computers", new HashSet<>());

        Product p1 = new Product("The Lord of the Rings","Lorem ipsum dolor sit amet, consectetur.",90.5 ,"", new HashSet<>());
        Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 944.1 ,"", new HashSet<>());
        Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1299.09 ,"", new HashSet<>());
        Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 100.3,"", new HashSet<>());
        Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 5555.5 ,"", new HashSet<>());

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        p1.getCategories().add(c2);
        p2.getCategories().addAll(Arrays.asList(c1, c3));
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }
}
