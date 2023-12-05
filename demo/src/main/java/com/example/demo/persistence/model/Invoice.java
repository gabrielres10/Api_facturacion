package com.example.demo.persistence.model;

import java.util.Date;

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
 * This class represents an invoice associated with a customer.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceNumber; // Numero de factura
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer; // Id del cliente
    
    private Date date; // Fecha de factura
}
