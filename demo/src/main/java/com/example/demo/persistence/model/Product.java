package com.example.demo.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a product 
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId; //Id del producto
    private String name; //Nombre del producto
    private Double price; //Precio del producto
    private Integer stock; //Cantidad del producto en Stock
}