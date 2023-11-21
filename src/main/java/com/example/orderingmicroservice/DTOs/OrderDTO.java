package com.example.orderingmicroservice.DTOs;

import com.example.orderingmicroservice.model.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long customerId;
    private Map<String, Double> productPrices;
    private double latitude;
    private double longitude;
}
