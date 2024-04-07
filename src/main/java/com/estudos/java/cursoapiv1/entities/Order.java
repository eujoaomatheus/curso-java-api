package com.estudos.java.cursoapiv1.entities;

import com.estudos.java.cursoapiv1.enums.OrderStatus;
import com.estudos.java.cursoapiv1.utils.EntityUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "TB_PEDIDO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    public Order(Long id, Instant moment, OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.client = client;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant moment;

    @Setter
    private Integer status;
    //Muitos pedidos podem pertencer ao mesmo client
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private User client;

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }

    }
}
