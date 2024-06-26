package com.estudos.java.cursoapiv1.repositories;

import com.estudos.java.cursoapiv1.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
