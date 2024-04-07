package com.estudos.java.cursoapiv1.controllers;

import com.estudos.java.cursoapiv1.entities.Category;
import com.estudos.java.cursoapiv1.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> listar() {
        return new ResponseEntity<>(categoryService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> buscarPeloId(@PathVariable Long id) {
        Category Category = categoryService.buscarPeloId(id);
        return new ResponseEntity<>(Category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> salvar(@RequestBody Category Category) {
        Category usuario = categoryService.salvar(Category);
        return new ResponseEntity<>(Category, HttpStatus.OK);
    }
}
