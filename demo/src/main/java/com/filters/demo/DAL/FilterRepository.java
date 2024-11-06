package com.filters.demo.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filters.demo.model.Filter;

public interface FilterRepository extends JpaRepository<Filter, Long> {
    
}
