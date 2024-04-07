package com.estudos.java.cursoapiv1.services;

import com.estudos.java.cursoapiv1.entities.Product;
import com.estudos.java.cursoapiv1.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listar() {

        return productRepository.findAll();
    }

    public Product buscarPeloId(Long id) {

        return productRepository.findById(id).orElse(null);
    }

    public Product salvar(Product user) {

        return productRepository.save(user);
    }
}
