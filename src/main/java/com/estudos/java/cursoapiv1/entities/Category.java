package com.estudos.java.cursoapiv1.entities;


import com.estudos.java.cursoapiv1.utils.EntityUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CATEGORIA")
public class Category extends EntityUtils {

    private String name;

    @Getter
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

}
