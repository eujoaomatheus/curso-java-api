package com.estudos.java.cursoapiv1.entities;

import com.estudos.java.cursoapiv1.utils.EntityUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class  Product extends EntityUtils {

    private String name;

    private String description;

    private Double price;

    private String imgUrl;

    /***
     * O @JoinTable serve para fazer a tabela de relacionamento entre as entidades no ManyToMany
     * Nesse caso é descrito o nome da table resultante, o nome da chave estrangeira da classe onde está sendo implementada
     * Nessa caso é a Product e por fim o nome da chave estrangeira da table destino que aqui é a category_id
     * Foi utilizado o SET para que não seja repetidas as categorias
     * Set é um Conjunto
     * ***/
    @ManyToMany(cascade = {CascadeType.ALL})
   // @JsonIgnore
    @JoinTable(name = "TB_PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
}
