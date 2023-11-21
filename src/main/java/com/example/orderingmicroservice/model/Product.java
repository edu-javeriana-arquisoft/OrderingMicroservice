package com.example.orderingmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, columnDefinition = "DOUBLE DEFAULT 0.0")
    private double price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Orders order;
}
