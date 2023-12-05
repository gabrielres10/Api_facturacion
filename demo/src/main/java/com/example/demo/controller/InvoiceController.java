package com.example.demo.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.model.Invoice;
import com.example.demo.services.InvoiceServiceI;

/**
 * This class contains the control functions related to the Invoice Entity.
 * This class will only have getClientInvoice so it can be consulted after the data injection present in the
 * DataInitializer.java class, which will instanciate all needed data in order this consults can be achieved.
 */
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceServiceI noteService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Invoice> getClientInvoice(@PathVariable Long customerId) {
        Optional<Invoice> note = noteService.consultInvoice(customerId);
        return note.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    
}