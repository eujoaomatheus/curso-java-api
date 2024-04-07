package com.estudos.java.cursoapiv1.controllers;

import com.estudos.java.cursoapiv1.entities.Product;
import com.estudos.java.cursoapiv1.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> listar() {
        return new ResponseEntity<>(productService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> buscarPeloId(@PathVariable Long id) {
        Product user = productService.buscarPeloId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> salvar(@RequestBody Product user) {
        Product usuario = productService.salvar(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
