package com.example.demo.services.implementation;

import com.example.demo.persistence.model.Customer;
import com.example.demo.persistence.repositories.CustomerRepository;
import com.example.demo.services.CustomerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        if (customerRepository.existsById(customerId)) {
            // Actualizar la información del cliente
            updatedCustomer.setCustomerId(customerId);
            return customerRepository.save(updatedCustomer);
        } else {
            // El cliente con el ID proporcionado no existe
            return null; // O manejar de acuerdo a tus necesidades
        }
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
