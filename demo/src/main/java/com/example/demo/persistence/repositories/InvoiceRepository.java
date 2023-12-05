package com.example.demo.persistence.repositories;

import java.util.List;
import com.example.demo.persistence.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByCustomer_CustomerId(Long customerId);

}
