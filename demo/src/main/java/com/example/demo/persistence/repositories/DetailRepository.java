package com.example.demo.persistence.repositories;

import com.example.demo.persistence.model.Detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    

}