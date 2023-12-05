package com.example.demo.services;

import com.example.demo.persistence.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceI {

    // Método para crear un nuevo cliente
    Customer createCustomer(Customer customer);

    // Método para obtener todos los clientes
    List<Customer> getAllCustomers();

    // Método para obtener un cliente por su ID
    Optional<Customer> getCustomerById(Long customerId);

    // Método para actualizar la información de un cliente
    Customer updateCustomer(Long customerId, Customer updatedCustomer);

    // Método para eliminar un cliente por su ID
    void deleteCustomer(Long customerId);
}
