package com.estudos.java.cursoapiv1.entities;

import com.estudos.java.cursoapiv1.entities.primarykeys.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ITEMPEDIDO")
@Data
@NoArgsConstructor
public class OrderItem {

    public OrderItem(Order order, Product product, Double price, Integer quantity) {
        id.setOrder(order);
        id.setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }

    @EmbeddedId
    private OrderItemPK id;

    private Integer quantity;

    private Double price;

    /*
    * Criando Getter e Setter do Order e Product, para que seja possível acessar esses valroes do mundo exterior
    */

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Order getOrder() {
        return id.getOrder();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Product getProduct() {
        return id.getProduct();
    }
}
