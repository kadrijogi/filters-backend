package com.filters.demo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filters.demo.model.Criteria;

public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
    
}
