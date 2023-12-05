package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.persistence.model.Invoice;

/**
 * This interface contains the declaration of all the services related with the Invoice Entity
 */
public interface InvoiceServiceI {    
    Optional<Invoice> consultInvoice(long customerId);
    double calculateTotalAmount(Long customerId);
}
