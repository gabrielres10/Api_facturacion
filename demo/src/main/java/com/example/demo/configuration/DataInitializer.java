package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import com.example.demo.persistence.model.Customer;
import com.example.demo.persistence.model.Detail;
import com.example.demo.persistence.model.Invoice;
import com.example.demo.persistence.model.Product;
import com.example.demo.persistence.repositories.CustomerRepository;
import com.example.demo.persistence.repositories.DetailRepository;
import com.example.demo.persistence.repositories.InvoiceRepository;
import com.example.demo.persistence.repositories.ProductRepository;

import jakarta.annotation.PostConstruct;

/**
 * This class contains all needed methods to register data to the model after the project is compiled.
 * Some entities are supposed to be instanced after the run method is used.
 */
@Component
public class DataInitializer {

    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostConstruct
    public void init() {
        //------------------------Create customers--------------------
        Customer customer1 = new Customer(null, "John", "Doe", "123 Main St", "1990-01-01", "123456789", "john@example.com", "Regular");
        Customer customer2 = new Customer(null, "Jane", "Smith", "456 Oak St", "1985-05-15", "987654321", "jane@example.com", "Premium");

        customerRepository.saveAll(List.of(customer1, customer2));

        //------------------------Create products----------------------
        Product product1 = new Product(null, "Product A", 19.99, 100);
        Product product2 = new Product(null, "Product B", 29.99, 50);

        productRepository.saveAll(List.of(product1, product2));

        //-------------------------Create invoices---------------------
        Invoice invoice1 = new Invoice(null, customer1, new Date());
        Invoice invoice2 = new Invoice(null, customer2, new Date());

        invoiceRepository.saveAll(List.of(invoice1, invoice2));

        //------------------------Create details-----------------------
        Detail detail1 = new Detail(null, invoice1, product1);
        Detail detail2 = new Detail(null, invoice1, product2);
        Detail detail3 = new Detail(null, invoice2, product1);

        detailRepository.saveAll(List.of(detail1, detail2, detail3));


        System.out.println("********************************DATA LOADED SUCCESSFULLY********************************");

        
    }
    
}
