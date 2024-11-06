package com.filters.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filters.demo.DAL.FilterRepository;
import com.filters.demo.model.Filter;

@Service
public class FilterService {

    @Autowired
    private FilterRepository filterRepository;

    // Method to save a filter
    public Filter saveFilter(Filter filter) {
        return filterRepository.save(filter);
    }

    // Method to get all filters
    public List<Filter> getAllFilters() {
        return filterRepository.findAll();
    }

    // Method to get a filter by ID
    public Optional<Filter> getFilterById(Long id) {
        return filterRepository.findById(id);
    }

    // Method to delete a filter by ID
    public void deleteFilterById(Long id) {
        filterRepository.deleteById(id);
    }
    
}
