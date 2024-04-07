package com.estudos.java.cursoapiv1.entities;

import com.estudos.java.cursoapiv1.utils.EntityUtils;
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
public class User extends EntityUtils {

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
