package com.estudos.java.cursoapiv1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_USER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String password;

    //Um usuario pode ter vários Pedidos
    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST})
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();



}
