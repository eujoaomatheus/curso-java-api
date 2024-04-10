package com.estudos.java.cursoapiv1.entities.primarykeys;

import com.estudos.java.cursoapiv1.entities.Order;
import com.estudos.java.cursoapiv1.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/***
 *
 * Essa classe tem a função de ser a Chave Primária composta da classe OrderItem
 * Tendo um relacionamento com produto e pedido
 *
 ***/


@Getter
@Setter
@EqualsAndHashCode(of = {"order", "product"})
@Embeddable
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
