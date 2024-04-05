package com.estudos.java.cursoapiv1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "TB_PEDIDO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant moment;

    //Muitos pedidos podem pertencer ao mesmo client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
}
