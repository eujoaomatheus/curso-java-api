package com.estudos.java.cursoapiv1.services;

import com.estudos.java.cursoapiv1.entities.Category;
import com.estudos.java.cursoapiv1.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    final
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listar() {

        return categoryRepository.findAll();
    }

    public Category buscarPeloId(Long id) {

        return categoryRepository.findById(id).orElse(null);
    }

    public Category salvar(Category Category) {

        return categoryRepository.save(Category);
    }
}
