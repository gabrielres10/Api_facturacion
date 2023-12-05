package com.example.demo.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.TotalCostResponse;
import com.example.demo.persistence.model.Detail;
import com.example.demo.persistence.model.Invoice;
import com.example.demo.persistence.repositories.DetailRepository;
import com.example.demo.services.InvoiceServiceI;

/**
 * This class contains the control functions related to the Invoice Entity.
 * This class will only have getClientInvoice so it can be consulted after the
 * data injection present in the
 * DataInitializer.java class, which will instanciate all needed data in order
 * this consults can be achieved.
 */
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceServiceI invoiceServiceI;

    @Autowired
    private DetailRepository detailRepository;

    @GetMapping("/{customerId}")
    public ResponseEntity<Invoice> getClientInvoice(@PathVariable Long customerId) {
        Optional<Invoice> note = invoiceServiceI.consultInvoice(customerId);
        return note.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    /**
     * This method receives as parameter the id of the invoice and calculates the total price.
     * @param invoiceId
     * @return TotalCostResponse, this class contains the result of the total price and a text that confirms
     * or denies if the invoice has discount
     */
    @GetMapping("/{invoiceId}/totalCost")
    public ResponseEntity<TotalCostResponse> getTotalCost(@PathVariable Long invoiceId) {
        // Obtener la factura por ID
        TotalCostResponse response = null;

        Optional<Invoice> found = invoiceServiceI.getInvoiceById(invoiceId);
        if (found.isPresent()) {
            Invoice clientInvoice = found.get();
            List<Detail> details = detailRepository.findByInvoiceId_InvoiceNumber(clientInvoice.getInvoiceNumber());

            double totalCost = details.stream()
                    .mapToDouble(detail -> detail.getProduct().getPrice())
                    .sum();

            response = new TotalCostResponse(totalCost, "No tiene descuento");        
            
            if (totalCost > 1000000 && details.size() >= 5) {
                double discount = totalCost * 0.10;
                totalCost -= discount;
                response = new TotalCostResponse(totalCost, "Tiene descuento");
            }
            
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}