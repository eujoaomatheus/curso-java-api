package com.estudos.java.cursoapiv1.config;

import com.estudos.java.cursoapiv1.entities.Order;
import com.estudos.java.cursoapiv1.entities.User;
import com.estudos.java.cursoapiv1.enums.OrderStatus;
import com.estudos.java.cursoapiv1.repositories.OrderRepository;
import com.estudos.java.cursoapiv1.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    final UserRepository userRepository;
    final OrderRepository orderRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        // Injetando usuarios no banco

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", new ArrayList<>());
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", new ArrayList<>());

        userRepository.saveAll(Arrays.asList(u1, u2));

        //Injetando os  Pedidos no banco

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED,u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
