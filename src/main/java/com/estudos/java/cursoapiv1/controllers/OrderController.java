package com.estudos.java.cursoapiv1.controllers;

import com.estudos.java.cursoapiv1.entities.Order;
import com.estudos.java.cursoapiv1.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> listar() {

        List<Order> pedidos = orderService.listar();

        System.out.println(pedidos);

        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> buscarPeloId(@PathVariable Long id) {

        Order order = orderService.buscarPorId(id);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> salvar(@RequestBody Order o) {

        Order order = orderService.salvar(o);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
