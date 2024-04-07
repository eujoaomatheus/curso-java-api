package com.estudos.java.cursoapiv1.entities;

import com.estudos.java.cursoapiv1.utils.EntityUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PRODUTO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product extends EntityUtils {

    private String name;

    private String description;

    private Double price;

    private String imgUrl;

    @Transient
    // Foi utilizado o SET para que não seja repetidas as categorias
    // Set é um Conjunto
    private Set<Category> categories = new HashSet<>();
}
