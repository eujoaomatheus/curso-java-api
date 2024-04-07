package com.estudos.java.cursoapiv1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private String imgUrl;

    // Foi utilizado o SET para que não seja repetidas as categorias
    // Set é um Conjunto
    private Set<Category> categories = new HashSet<>();
}
