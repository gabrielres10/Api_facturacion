package com.example.demo.services.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.persistence.model.Invoice;
import com.example.demo.persistence.repositories.InvoiceRepository;
import com.example.demo.services.InvoiceServiceI;

@Service
public class InvoiceServiceImpl implements InvoiceServiceI{

    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     * This method consults the invoice of a customer if exists, by using the customer id as parameter
     * @param customerId, Long
     * @return Invoice of the customer, Optional<Invoice>. This variable can contain or not the invoice 
     * depending on the existence of the customer using its Id as search criteria.
     */
    @Override
    public Optional<Invoice> consultInvoice(long customerId) {
         
         List<Invoice> invoices = invoiceRepository.findByCustomer_CustomerId(customerId);

         // Devolver la primera factura encontrada (si existe)
         return invoices.isEmpty() ? Optional.empty() : Optional.of(invoices.get(0));
    }


    @Override
    public Optional<Invoice> getInvoiceById(long invoiceId) {
         return invoiceRepository.findById(invoiceId);
    }

    
}
