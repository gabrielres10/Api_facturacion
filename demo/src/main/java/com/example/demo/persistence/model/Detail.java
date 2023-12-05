package com.example.demo.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a Detail of an order. This detail relates an invoice with a product.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailNumber; //Número de detalle de orden

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoiceId; //Id de factura

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; //Id de producto 
}