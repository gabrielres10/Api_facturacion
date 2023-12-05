package com.example.demo.persistence.repositories;

import com.example.demo.persistence.model.Detail;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    List<Detail> findByInvoiceId_InvoiceNumber(Long invoiceNumber);
}