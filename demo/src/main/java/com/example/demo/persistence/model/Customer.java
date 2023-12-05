package com.example.demo.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a Customer
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId; //Id del cliente
    private String name; //Nombre del cliente
    private String lastName; //Apellido del cliente
    private String address; //Dirección del clinete
    private String birthdate; //Cumpleaños del cliente
    private String phone; //Teléfono del cliente
    private String email; //Correo electrónico del cliente
    private String category; //Categoría del cliente
}