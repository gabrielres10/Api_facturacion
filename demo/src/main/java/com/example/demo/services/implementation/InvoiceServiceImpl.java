package com.example.demo.services.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.persistence.model.Detail;
import com.example.demo.persistence.model.Invoice;
import com.example.demo.persistence.model.Product;
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
    public double calculateTotalAmount(Long customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomer_Id(customerId);

        double totalAmount = invoices.stream()
                .flatMap(invoice -> invoice.getDetails().stream())
                .mapToDouble(detail -> calculateDetailAmount(detail))
                .sum();

        // Aplicar descuento si es necesario
        if (totalAmount > 1000000 && invoices.stream().anyMatch(invoice -> invoice.getDetails().size() >= 5)) {
            return totalAmount * 0.9; // Aplicar descuento del 10%
        }

        return totalAmount;
    }

    private double calculateDetailAmount(Detail detail) {
        Product product = detail.getProduct();
        int quantity = detail.getQuantity();
        double price = product.getPrice();
        return quantity * price;
    }
    
}
