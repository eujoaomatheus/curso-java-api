package com.estudos.java.cursoapiv1.services;

import com.estudos.java.cursoapiv1.entities.Order;
import com.estudos.java.cursoapiv1.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> listar() {

        return orderRepository.findAll();
    }


    public Order buscarPorId(Long id) {

        return orderRepository.findById(id).orElse(null);
    }


    public Order salvar(Order order) {

        return orderRepository.save(order);
    }


}
