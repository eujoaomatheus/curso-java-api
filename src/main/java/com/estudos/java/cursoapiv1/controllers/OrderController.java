package com.estudos.java.cursoapiv1.controllers;

import com.estudos.java.cursoapiv1.entities.Order;
import com.estudos.java.cursoapiv1.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> listar() {
        return new ResponseEntity<>(orderService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> buscarPeloId(@PathVariable Long id) {
        Order user = orderService.buscarPorId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> salvar(@RequestBody Order user) {
        Order order = orderService.salvar(user);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
